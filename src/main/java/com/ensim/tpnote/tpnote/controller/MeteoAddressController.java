package com.ensim.tpnote.tpnote.controller;

import com.ensim.tpnote.tpnote.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MeteoAddressController {
    @Autowired
    AddressRepository addressRepository;
    @GetMapping("/addresse")
    public String showAddresses(Model model) {
        return "addresse";
    }
}