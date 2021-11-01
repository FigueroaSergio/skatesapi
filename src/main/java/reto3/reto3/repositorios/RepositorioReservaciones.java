/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3.reto3.repositorios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.reto3.entidades.Cliente;
import reto3.reto3.entidades.Reservacion;
import reto3.reto3.interfaces.InterfaceReservaciones;
import reto3.reto3.reportes.ConstadorClientes;

/**
 *
 * @author figue
 */
@Repository
public class RepositorioReservaciones {
     @Autowired
	    private InterfaceReservaciones crud4;
	
	    public List<Reservacion> getAll(){
	        return (List<Reservacion>) crud4.findAll();
	    }
	    public Optional<Reservacion> getReservation(int id){
	        return crud4.findById(id);
	    }
	    public Reservacion save(Reservacion reservation){
	        return crud4.save(reservation);
	    }
	    public void delete(Reservacion reservation){
	        crud4.delete(reservation);
	    }
            public List<Reservacion> reservacionStatus(String status){
                return crud4.findAllByStatus(status);
            }
            public List<Reservacion> reservacionTiempo(Date a, Date b){
                return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
            }
            
            public List<ConstadorClientes> getTopClientes(){
                List<ConstadorClientes> res = new ArrayList<>();
                List<Object[]>report = crud4.countTotalReservationByClient();
                for(int i = 0; i<report.size();i++){
                    res.add(new ConstadorClientes((Long)report.get(i)[1],(Cliente)report.get(i)[0]));
                    
                }
                return res;
            }
            
}           
