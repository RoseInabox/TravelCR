package com.tours.TravelCR.controller;

import com.tours.TravelCR.dao.TourDao;
import com.tours.TravelCR.dao.DestinoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TourController {

    @Autowired
    private TourDao tourRepository;

    @Autowired
    private DestinoDao destinoDao;

    @GetMapping("/tours")
    public String mostrarTours(
            @RequestParam(required = false) Long idDestino,
            @RequestParam(required = false) String fecha,
            Model model) {

        var destinos = destinoDao.findAll();
        var tours = tourRepository.findAll();

        if (idDestino != null && fecha != null && !fecha.isEmpty()) {
            tours = tourRepository.findByDestino_IdDestinoAndFecha(
                    idDestino,
                    java.time.LocalDate.parse(fecha)
            );
        } else if (idDestino != null) {
            tours = tourRepository.findByDestino_IdDestino(idDestino);
        } else if (fecha != null && !fecha.isEmpty()) {
            tours = tourRepository.findByFecha(
                    java.time.LocalDate.parse(fecha)
            );
        }

        model.addAttribute("tours", tours);
        model.addAttribute("destinos", destinos);

        return "tours";
    }

    @GetMapping("/tour/{id}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {

        var tour = tourRepository.findById(id).orElse(null);

        model.addAttribute("tour", tour);

        return "tour_detalle";
    }
}
