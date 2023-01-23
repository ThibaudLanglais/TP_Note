package com.ensim.tpnote.tpnote;

public class Geometry {
    public Geometry() {
    }
    private double[] coordinates;
    private String type;

    public Geometry(double[] coordinates, String type) {
        this.coordinates = coordinates;
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }
}
