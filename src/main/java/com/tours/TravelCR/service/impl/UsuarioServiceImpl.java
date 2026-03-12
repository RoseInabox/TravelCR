/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tours.TravelCR.service.impl;

/**
 *
 * @author joses
 */

import com.tours.TravelCR.dao.RolDao;
import com.tours.TravelCR.dao.UsuarioDao;
import com.tours.TravelCR.domain.Rol;
import com.tours.TravelCR.domain.Usuario;
import com.tours.TravelCR.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private RolDao rolDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void guardar(Usuario usuario) {

        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuario.setActivo(true);

        Rol rol = rolDao.findByNombre("ROLE_USER");

        List<Rol> roles = new ArrayList<>();
        roles.add(rol);

        usuario.setRoles(roles);

        usuarioDao.save(usuario);

    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        return usuarioDao.findByCorreo(correo);
    }

    @Override
    public boolean existeCorreo(String correo) {
        return usuarioDao.existsByCorreo(correo);
    }

}