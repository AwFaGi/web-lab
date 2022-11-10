package org.example.beans;

import org.example.util.Connector;

import java.util.ArrayList;
import java.util.Collections;

public class Model {
    private ArrayList<ExtendedPoint> data = new ArrayList<>();

    public void add(ExtendedPoint extendedPoint){
        data.add(extendedPoint);
        Connector.getInstance().makeBigAdd(extendedPoint);
    }

    public ArrayList<ExtendedPoint> get(){
        return new ArrayList<>(data);
    }

    public ArrayList<ExtendedPoint> getReversed() {
        ArrayList<ExtendedPoint> toReturn= new ArrayList<>(data);
        Collections.reverse(toReturn);
        return toReturn;
    }

    @Override
    public String toString() {
        return "Model{" +
                "data=" + data +
                '}';
    }
}