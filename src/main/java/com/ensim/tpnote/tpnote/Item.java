package com.ensim.tpnote.tpnote;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String day, datetime, weather, tmin, tmax;

    public Item() {
    }

    public Item(String day, String datetime, String weather, String tmin, String tmax) {
        this.day = day;
        this.datetime = dateFormat.format(new Date(datetime));
        this.weather = weather;
        this.tmin = tmin;
        this.tmax = tmax;
    }

    public String getDay() {
        return day;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getWeather() {
        return weather;
    }

    public String getTmin() {
        return tmin;
    }

    public String getTmax() {
        return tmax;
    }
}
