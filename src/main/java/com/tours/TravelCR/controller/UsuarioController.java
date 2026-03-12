/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tours.TravelCR.controller;

/**
 *
 * @author joses
 */

import com.tours.TravelCR.domain.Usuario;
import com.tours.TravelCR.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {

        model.addAttribute("usuario", new Usuario());

        return "registro";

    }

    @PostMapping("/registro")
    public String registrarUsuario(Usuario usuario, Model model) {

        if (usuarioService.existeCorreo(usuario.getCorreo())) {

            model.addAttribute("error", "El correo ya esta registrado");
            model.addAttribute("usuario", usuario);

            return "registro";
        }

        usuarioService.guardar(usuario);

        return "redirect:/login";

    }

    @GetMapping("/login")
    public String mostrarLogin() {

        return "login";

    }

}