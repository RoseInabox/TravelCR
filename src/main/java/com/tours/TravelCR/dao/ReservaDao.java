package com.tours.TravelCR.dao;

import com.tours.TravelCR.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaDao extends JpaRepository<Reserva, Long> {
}