package com.ensim.tpnote.tpnote;

public class ApiMeteoResponse {
    private City city;

    public ApiMeteoResponse(City city, Item[] forecast) {
        this.city = city;
        this.forecast = forecast;
    }

    public Item[] getForecast() {
        return forecast;
    }

    private Item[] forecast;

    public ApiMeteoResponse() {
    }

    public City getCity() {
        return city;
    }
}
