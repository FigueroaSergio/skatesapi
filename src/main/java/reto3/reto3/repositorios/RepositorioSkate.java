/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3.reto3.repositorios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.reto3.entidades.Skate;
import reto3.reto3.interfaces.InterfaceSkate;

/**
 *
 * @author figue
 */
@Repository
public class RepositorioSkate {
    @Autowired
	    private InterfaceSkate crud;
	
	    public List<Skate> getAll(){
	        return (List<Skate>) crud.findAll();
	    }
	
	    public Optional<Skate> getBike(int id){
	        return crud.findById(id);
	    }
	
	    public Skate save(Skate bike){
	        return crud.save(bike);
	    }
	    public void delete(Skate bike){
	        crud.delete(bike);
	    }
}
