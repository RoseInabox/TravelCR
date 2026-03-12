/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tours.TravelCR.service;

/**
 *
 * @author joses
 */
import com.tours.TravelCR.domain.Tour;

public interface TourService {

    void guardar(Tour tour);

    Tour buscarPorCorreo(String correo);

    boolean existeCorreo(String correo);

}