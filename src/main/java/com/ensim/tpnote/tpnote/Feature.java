package com.ensim.tpnote.tpnote;

public class Feature {
    public Feature(Geometry geometry, String type) {
        this.geometry = geometry;
        this.type = type;
    }

    public Feature() {
    }

    public Geometry getGeometry() {
        return geometry;
    }

    private Geometry geometry;
    private String type;

}
