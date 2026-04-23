package com.tours.TravelCR.service;

import com.tours.TravelCR.domain.Soporte;
import java.util.List;

public interface SoporteService {

    void guardar(Soporte soporte);

    List<Soporte> listar();

    Soporte obtenerPorId(Long id);

    void eliminar(Long id);
}
