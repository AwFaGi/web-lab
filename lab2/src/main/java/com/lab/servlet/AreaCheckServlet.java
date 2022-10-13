package com.lab.servlet;

import com.lab.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AreaCheckServlet", value = "/area-check")
public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long startTime = System.nanoTime();
        String x_string = request.getParameter("x_value");
        String y_string = request.getParameter("y_value");
        String r_string = request.getParameter("r_value");

        /* validate sensibility */
        if (
                !DataValidator.validateDouble(x_string) ||
                !DataValidator.validateDouble(y_string) ||
                !DataValidator.validateDouble(r_string)
        ){
            response.sendRedirect("/error/2");
        }

        /* create point object */
        Point point = new Point(
                Double.parseDouble(x_string),
                Double.parseDouble(y_string),
                Double.parseDouble(r_string)
        );

        /* validate values */
        if (!PointValidator.validate(point)) {
            response.sendRedirect("/error/2");
        }

        /* validate area hit */
        boolean gotInto = AreaInValidator.validate(point);
        point.setStatus(gotInto);

        /* save it into context */
        String userID = request.getSession(true).getId();
        String getString = "values_" + userID;
        Object supposedToBeModel = getServletContext().getAttribute(getString);
        Model model;
        if (supposedToBeModel == null){
            model = new Model();
        } else {
            model = (Model) supposedToBeModel;
        }
        point.setWorkingTime((System.nanoTime() - startTime) / 1000);
        model.add(point);
        getServletContext().setAttribute(getString, model);

        /* show result html page */
        response.sendRedirect("/result.jsp");
    }
}
