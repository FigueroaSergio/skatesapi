/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3.reto3.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reto3.reto3.entidades.Reservacion;
import reto3.reto3.reportes.ConstadorClientes;
import reto3.reto3.reportes.StatusReservas;
import reto3.reto3.servicios.ServiciosReservaciones;

/**
 *
 * @author figue
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorReservaciones {
     @Autowired
    private ServiciosReservaciones servicio;
    @GetMapping("/all")
    public List<Reservacion> getReservations(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservacion> getReservation(@PathVariable("id") int reservationId) {
        return servicio.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion save(@RequestBody Reservacion reservation) {
        return servicio.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion update(@RequestBody Reservacion reservation) {
        return servicio.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicio.deleteReservation(reservationId);
    }
    @GetMapping("/report-status")
    public StatusReservas getReservas(){
        return servicio.getReporteStatusReservaciones();
    }
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservacion> getReservas(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return servicio.getReporteTiempoReservacion(dateOne,dateTwo);
    }
    @GetMapping("/report-clients")
    public List<ConstadorClientes> getTopClientes(){
        return servicio.getTopClientes();
    }
}
