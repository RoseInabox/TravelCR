package com.tours.TravelCR.controller;

import com.tours.TravelCR.domain.Usuario;
import com.tours.TravelCR.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PerfilController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/perfil")
    public String verPerfil(Authentication auth, Model model) {
        Usuario usuario = usuarioService.buscarPorCorreo(auth.getName());
        model.addAttribute("usuario", usuario);
        return "perfil";
    }

    @PostMapping("/perfil")
    public String actualizarPerfil(@ModelAttribute Usuario usuarioForm, Authentication auth) {
        Usuario usuario = usuarioService.buscarPorCorreo(auth.getName());

        usuario.setNombreCompleto(usuarioForm.getNombreCompleto());
        usuario.setFechaNacimiento(usuarioForm.getFechaNacimiento());

        usuarioService.actualizar(usuario);

        return "redirect:/perfil?exito";
    }
}