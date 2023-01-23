package com.ensim.tpnote.tpnote;

public class ApiAddress {
    public ApiAddress(Feature[] features, String type, String version, String attribution, String licence, String query, int limit) {
        this.features = features;
        this.type = type;
        this.version = version;
        this.attribution = attribution;
        this.licence = licence;
        this.query = query;
        this.limit = limit;
    }

    public ApiAddress() {
    }

    public Feature[] getFeatures() {
        return features;
    }

    private Feature[] features;
    private String type;
    private String version;
    private String attribution;
    private String licence;
    private String query;
    private int limit;
}

