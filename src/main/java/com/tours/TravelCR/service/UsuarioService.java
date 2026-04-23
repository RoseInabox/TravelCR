/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tours.TravelCR.service;

/**
 *
 * @author joses
 */
import com.tours.TravelCR.domain.Usuario;

public interface UsuarioService {

    void guardar(Usuario usuario);

    Usuario buscarPorCorreo(String correo);

    boolean existeCorreo(String correo);

    void actualizar(Usuario usuario);

}
