package org.example.beans;

import java.io.Serializable;

public class Point implements Serializable {
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    private double x=-3;
    private double y=-5;
    private double r=2;

    private Model model;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Point(){

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public void doExtend() {
        ExtendedPoint point = new ExtendedPoint();
        point.setX(x);
        point.setY(y);
        point.setR(r);
        point.selfEval();
        model.add(point);
    }
}
