package com.tours.TravelCR.dao;

import com.tours.TravelCR.domain.Destino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinoDao extends JpaRepository<Destino, Long> {
}