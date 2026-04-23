package com.tours.TravelCR.controller;

import com.tours.TravelCR.dao.DestinoDao;
import com.tours.TravelCR.domain.Destino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/destinos")
public class AdminDestinoController {

    @Autowired
    private DestinoDao destinoDao;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("destinos", destinoDao.findAll());
        model.addAttribute("destino", new Destino());
        return "admin_destinos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Destino destino = destinoDao.findById(id).orElse(new Destino());

        model.addAttribute("destino", destino);
        model.addAttribute("destinos", destinoDao.findAll());

        return "admin_destinos";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Destino destino) {
        destinoDao.save(destino);
        return "redirect:/admin/destinos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        destinoDao.deleteById(id);
        return "redirect:/admin/destinos";
    }
}