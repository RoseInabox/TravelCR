/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tours.TravelCR.controller;

/**
 *
 * @author joses
 */


import com.tours.TravelCR.dao.TourDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioController {

    @Autowired
    private TourDao tourDao;

    @GetMapping("/")
    public String inicio(Model model) {
        var tours = tourDao.findAll();
        model.addAttribute("tours", tours);
        return "index";
    }

    @GetMapping("/buscarTours")
    public String buscarTours(@RequestParam(required = false) Long idDestino, Model model) {
        var tours = (idDestino != null) ? tourDao.findByDestino_IdDestino(idDestino) : tourDao.findAll();
        model.addAttribute("tours", tours);
        return "tours";
    }
}