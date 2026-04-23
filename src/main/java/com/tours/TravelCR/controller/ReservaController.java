package com.tours.TravelCR.controller;

import com.tours.TravelCR.dao.TourDao;
import com.tours.TravelCR.domain.Reserva;
import com.tours.TravelCR.domain.Usuario;
import com.tours.TravelCR.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private TourDao tourDao;

    @PostMapping("/reservar")
    public String reservar(
            @RequestParam Long idTour,
            @RequestParam int cantidad,
            Model model) {

        var tour = tourDao.findById(idTour).orElse(null);

        Reserva reserva = new Reserva();
        reserva.setTour(tour);
        reserva.setCantidadPersonas(cantidad);
        reserva.setEstadoPago("PENDIENTE");

        reservaService.guardar(reserva);

        return "redirect:/pago/" + reserva.getIdReserva();
    }

    @GetMapping("/reservas")
    public String listarReservas(@RequestParam(required = false) String exito, Model model) {

        if (exito != null) {
            model.addAttribute("mensaje", "Comprobante enviado correctamente, en revisión");
            model.addAttribute("tipoMensaje", "ok");
        } else {
            model.addAttribute("mensaje", "Aquí puedes ver el estado de tus reservas y pagos");
            model.addAttribute("tipoMensaje", "info");
        }

        model.addAttribute("reservas", reservaService.listar());

        return "reservas";
    }

    @GetMapping("/reservas/{id}")
    public String verReserva(@PathVariable Long id, Model model) {

        Reserva reserva = reservaService.buscarPorId(id);

        model.addAttribute("reserva", reserva);

        return "reserva_detalle";
    }

    @PostMapping("/reservas/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id, RedirectAttributes redirectAttributes) {

        reservaService.eliminar(id);

        redirectAttributes.addFlashAttribute("mensaje", "Reserva eliminada correctamente");
        redirectAttributes.addFlashAttribute("tipoMensaje", "ok");

        return "redirect:/reservas";
    }
}
