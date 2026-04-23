package com.tours.TravelCR.controller;

import com.tours.TravelCR.dao.DestinoDao;
import com.tours.TravelCR.dao.TourDao;
import com.tours.TravelCR.domain.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/tours")
public class AdminTourController {

    @Autowired
    private TourDao tourDao;

    @Autowired
    private DestinoDao destinoDao;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("tours", tourDao.findAll());
        model.addAttribute("tour", new Tour());
        model.addAttribute("destinos", destinoDao.findAll());
        return "admin_tours";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Tour tour = tourDao.findById(id).orElse(new Tour());

        model.addAttribute("tour", tour);
        model.addAttribute("tours", tourDao.findAll());
        model.addAttribute("destinos", destinoDao.findAll());

        return "admin_tours";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Tour tour) {
        tourDao.save(tour);
        return "redirect:/admin/tours";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        tourDao.deleteById(id);
        return "redirect:/admin/tours";
    }
}