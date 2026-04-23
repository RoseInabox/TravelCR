package com.tours.TravelCR.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "id_tour")
    private Tour tour;

    @Column(name = "fecha_reserva")
    private LocalDate fechaReserva;

    @Column(name = "cantidad_personas")
    private int cantidadPersonas;

    @Column(name = "estado")
    private String estado;

    public Reserva() {
        this.fechaReserva = LocalDate.now();
        this.estado = "PENDIENTE";
    }

    @Column(name = "comprobante_pago")
    private String comprobantePago;

    @Column(name = "estado_pago")
    private String estadoPago;

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComprobantePago() {
        return comprobantePago;
    }

    public void setComprobantePago(String comprobantePago) {
        this.comprobantePago = comprobantePago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }
}
