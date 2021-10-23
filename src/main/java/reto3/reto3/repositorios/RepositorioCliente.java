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
import reto3.reto3.entidades.Cliente;
import reto3.reto3.interfaces.InterfaceCliente;

/**
 *
 * @author figue
 */
@Repository
public class RepositorioCliente {
    @Autowired
	    private InterfaceCliente crud1;
	
	    public List<Cliente> getAll(){
	        return (List<Cliente>) crud1.findAll();
	    }
	    public Optional<Cliente> getCliente(int id){
	        return crud1.findById(id);
	    }
	
	    public Cliente save(Cliente cliente){
	        return crud1.save(cliente);
	    }
	    public void delete(Cliente cliente){
	        crud1.delete(cliente);
	    }
}
