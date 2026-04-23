package com.tours.TravelCR.service;

import com.tours.TravelCR.domain.Reserva;
import java.util.List;

public interface ReservaService {

    public void guardar(Reserva reserva);
    Reserva buscarPorId(Long id);

    public List<Reserva> listar();
    
    public void eliminar(Long id);
}