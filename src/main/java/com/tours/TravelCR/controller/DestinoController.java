package com.tours.TravelCR.controller;

import com.tours.TravelCR.dao.DestinoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DestinoController {

    @Autowired
    private DestinoDao destinoDao;

    @GetMapping("/listaDestinos")
    public String mostrarDestinos(Model model) {
        var destinos = destinoDao.findAll();
        model.addAttribute("destinos", destinos);
        return "destinos";
    }
}