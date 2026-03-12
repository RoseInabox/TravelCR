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
import com.tours.TravelCR.domain.Tour;
import com.tours.TravelCR.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TourController {


    @Autowired
    private TourDao tourRepository;

    @GetMapping("/tours")
    public String mostrarTours(Model model){

        var listaTours = tourRepository.findAll();

        model.addAttribute("tours", listaTours);

        return "tours";
    }
}

