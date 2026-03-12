/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tours.TravelCR.dao;

/**
 *
 * @author joses
 */
import com.tours.TravelCR.domain.Tour;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourDao extends JpaRepository<Tour, Long> {

    List<Tour> findByDestino_IdDestino(Long idDestino);

    List<Tour> findByFecha(LocalDate fecha);

    List<Tour> findByDestino_IdDestinoAndFecha(Long idDestino, LocalDate fecha);
}