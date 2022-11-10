package org.example.beans;

import org.example.util.AreaInValidator;

import java.time.LocalDateTime;

public class ExtendedPoint {
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    private double x;
    private double y;
    private double r;
    private boolean status;
    private LocalDateTime timeStamp;

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    private long workingTime;

    public ExtendedPoint(){

    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public void setWorkingTime(long workingTime) {
        this.workingTime = workingTime;
    }

    public boolean getStatus(){
        return status;
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

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    public long getWorkingTime() {
        return workingTime;
    }

    public void selfEval() {
        long startTime = System.nanoTime();
        setTimeStamp(java.time.LocalDateTime.now());
        setX(this.x);
        setY(this.y);
        setR(this.r);
        setStatus(AreaInValidator.validate(this));
        setWorkingTime(System.nanoTime() - startTime);
    }
}
