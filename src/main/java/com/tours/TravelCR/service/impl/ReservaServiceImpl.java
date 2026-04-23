package com.tours.TravelCR.service.impl;

import com.tours.TravelCR.dao.ReservaDao;
import com.tours.TravelCR.domain.Reserva;
import com.tours.TravelCR.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaDao reservaDao;

    @Override
    public void guardar(Reserva reserva) {
        reservaDao.save(reserva);
    }

    @Override
    public Reserva buscarPorId(Long id) {
        return reservaDao.findById(id).orElse(null);
    }

    @Override
    public List<Reserva> listar() {
        return reservaDao.findAll();
    }

    @Override
    public void eliminar(Long id) {
        reservaDao.deleteById(id);
    }
}
