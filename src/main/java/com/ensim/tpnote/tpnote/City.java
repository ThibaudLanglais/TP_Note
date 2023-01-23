package com.ensim.tpnote.tpnote;

public class City {
    public String cp, name, latitude, longitude, altitude;

    public City(String cp, String name, String latitude, String longitude, String altitude) {
        this.cp = cp;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public City() {
    }

    public String getCp() {
        return cp;
    }

    public String getName() {
        return name;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getAltitude() {
        return altitude;
    }
}
