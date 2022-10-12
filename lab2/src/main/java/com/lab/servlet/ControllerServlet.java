package com.lab.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        /* validate presence*/
        String x_string = request.getParameter("x_value");
        String y_string = request.getParameter("y_value");
        String r_string = request.getParameter("r_value");

        if (x_string == null || y_string == null || r_string == null){
            response.sendRedirect("/error/1");
        }

        getServletContext().getRequestDispatcher("/area-check").forward(request, response);

    }

}