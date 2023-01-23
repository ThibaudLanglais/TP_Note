package com.ensim.tpnote.tpnote.controller;

import com.ensim.tpnote.tpnote.AddressRepository;
import com.ensim.tpnote.tpnote.ApiAddress;
import com.ensim.tpnote.tpnote.ApiMeteoResponse;
import com.ensim.tpnote.tpnote.Feature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class MeteoController {
    private String token = "2ffee5fc1e1b53fe53ac9dbee5e05a9226116915bc601e9da624107685b83862";
    @PostMapping(path = "/meteo", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getResult(RestTemplate restTemplate, @RequestParam("address") String addressValue, ModelMap model) {
        model.addAttribute("address", addressValue);
        try {
            ApiAddress addressDAO = restTemplate.getForObject("https://api-adresse.data.gouv.fr/search/?limit=1&q=" + URLEncoder.encode(addressValue, StandardCharsets.UTF_8), ApiAddress.class);
            Feature feature = addressDAO.getFeatures()[0];
            double lng = feature.getGeometry().getCoordinates()[0];
            double lat = feature.getGeometry().getCoordinates()[1];
            String url = "https://api.meteo-concept.com/api/forecast/daily/?token=" + token +
            "&latlng=" +
            lat + "," + lng;
            ApiMeteoResponse meteoDAO = restTemplate.getForObject(url, ApiMeteoResponse.class);
            model.put("data", meteoDAO);
        } catch (Exception e) {
            System.err.println(e);
            return "addresse";
        }
        //https://api-adresse.data.gouv.fr/search/?q=
        //api.meteo-concept.com/api/forecast/daily
        return "meteo";
    }

    public static String searchAddress(String query) throws Exception {
        URL api = new URL("https://api-adresse.data.gouv.fr/search/?limit=1&q=" + URLEncoder.encode(query, StandardCharsets.UTF_8));
        URLConnection con = api.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        con.getInputStream()));
        String response = "";
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            response += inputLine;
        in.close();
        return response;
    }
}