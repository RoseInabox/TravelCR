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
import com.tours.TravelCR.dao.DestinoDao;
import com.tours.TravelCR.domain.Soporte;
import com.tours.TravelCR.service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioController {

    @Autowired
    private TourDao tourDao;

    @Autowired
    private DestinoDao destinoDao;

    @GetMapping("/")
    public String inicio(Model model) {

        var tours = tourDao.findAll();
        var destinos = destinoDao.findAll();

        model.addAttribute("tours", tours);
        model.addAttribute("destinos", destinos);

        return "index";
    }

    @GetMapping("/buscarTours")
    public String buscarTours(@RequestParam(required = false) Long idDestino, Model model) {
        var tours = (idDestino != null) ? tourDao.findByDestino_IdDestino(idDestino) : tourDao.findAll();
        model.addAttribute("tours", tours);
        return "tours";
    }

    @GetMapping("/soporte")
    public String mostrarSoporte() {
        return "soporte";
    }

    @Autowired
    private SoporteService soporteService;

    @PostMapping("/soporte")
    public String procesarSoporte(
            @RequestParam String nombre,
            @RequestParam String correo,
            @RequestParam String tipo,
            @RequestParam String descripcion,
            Model model) {

        Soporte soporte = new Soporte();
        soporte.setNombre(nombre);
        soporte.setCorreo(correo);
        soporte.setTipo(tipo);
        soporte.setDescripcion(descripcion);

        soporteService.guardar(soporte);

        model.addAttribute("exito", true);
        return "soporte";
    }
}
