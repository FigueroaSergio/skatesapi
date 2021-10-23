/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3.reto3.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.reto3.entidades.Reservacion;
import reto3.reto3.repositorios.RepositorioReservaciones;

/**
 *
 * @author figue
 */
@Service
public class ServiciosReservaciones {
    @Autowired
    private RepositorioReservaciones metodosCrud;

    public List<Reservacion> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Reservacion> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    public Reservacion save(Reservacion reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Reservacion e= metodosCrud.getReservation(reservation.getIdReservation()).orElse(null);
            if(e==null){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservacion update(Reservacion reservation){
        if(reservation.getIdReservation()!=null){
            Reservacion e= metodosCrud.getReservation(reservation.getIdReservation()).orElse(null);
            if(!(e==null)){

                if(reservation.getStartDate()!=null){
                    e.setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.setStatus(reservation.getStatus());
                }
                metodosCrud.save(e);
                return e;
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
