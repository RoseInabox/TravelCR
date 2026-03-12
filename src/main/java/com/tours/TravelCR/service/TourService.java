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
import java.time.LocalDate;
import java.util.List;

public interface TourService {

    List<Tour> listarTodos();

    List<Tour> buscarPorDestino(Long idDestino);

    List<Tour> buscarPorFecha(LocalDate fecha);

    List<Tour> buscarPorDestinoYFecha(Long idDestino, LocalDate fecha);
}