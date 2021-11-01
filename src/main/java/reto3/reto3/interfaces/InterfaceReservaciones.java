/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3.reto3.interfaces;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import reto3.reto3.entidades.Reservacion;

/**
 *
 * @author figue
 */
public interface InterfaceReservaciones extends CrudRepository<Reservacion,Integer>{
     public List<Reservacion>findAllByStatus(String status);
     
     public List<Reservacion>findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);
     
     @Query("SELECT c.client, COUNT(c.client) from Reservacion AS c group  by c.client order by COUNT(c.client)DESC")
     public List<Object[]> countTotalReservationByClient();
     
     }      
