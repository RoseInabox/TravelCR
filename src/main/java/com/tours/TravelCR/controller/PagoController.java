package com.tours.TravelCR.controller;

import com.tours.TravelCR.domain.Reserva;
import com.tours.TravelCR.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/{id}")
    public String verPago(@PathVariable Long id, Model model) {
        var reserva = reservaService.buscarPorId(id);
        model.addAttribute("reserva", reserva);
        return "pago_comprobante";
    }

    @PostMapping("/guardar")
    public String guardarComprobante(
            @RequestParam Long idReserva,
            @RequestParam("archivo") MultipartFile archivo) throws IOException {

        var reserva = reservaService.buscarPorId(idReserva);

        // Ruta carpeta uploads
        String carpeta = System.getProperty("user.dir") + "/uploads/";
        File dir = new File(carpeta);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String nombreArchivo = System.currentTimeMillis() + "_" + archivo.getOriginalFilename();

        File ruta = new File(carpeta + nombreArchivo);
        archivo.transferTo(ruta);

        reserva.setComprobantePago(nombreArchivo);
        reserva.setEstadoPago("EN_REVISION");

        reservaService.guardar(reserva);

        return "redirect:/reservas?exito=true";
    }
}
