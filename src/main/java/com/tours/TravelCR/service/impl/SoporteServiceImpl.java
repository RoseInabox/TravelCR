package com.tours.TravelCR.service;

import com.tours.TravelCR.dao.SoporteDao;
import com.tours.TravelCR.domain.Soporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SoporteServiceImpl implements SoporteService {

    @Autowired
    private SoporteDao soporteDao;

    @Override
    public void guardar(Soporte soporte) {
        soporteDao.save(soporte);
    }

    @Override
    public List<Soporte> listar() {
        return soporteDao.findAll();
    }

    @Override
    public Soporte obtenerPorId(Long id) {
        return soporteDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        soporteDao.deleteById(id);
    }
}