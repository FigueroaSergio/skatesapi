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
import reto3.reto3.entidades.Cliente;
import reto3.reto3.repositorios.RepositorioCliente;

/**
 *
 * @author figue
 */
@Service
public class ServiciosCliente {
    @Autowired
     private RepositorioCliente metodosCrud;
     
     public List<Cliente> getAll(){
        return metodosCrud.getAll();
    }
     
      public Optional<Cliente> getClient(int clientId) {
        return metodosCrud.getCliente(clientId);
    }

    public Cliente save(Cliente client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Cliente e= metodosCrud.getCliente(client.getIdClient()).orElse(null);
            if(e==null){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }

    public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Cliente e= metodosCrud.getCliente(client.getIdClient()).orElse(null);
            if(!(e==null)){
                if(client.getName()!=null){
                    e.setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.setPassword(client.getPassword());
                }
                metodosCrud.save(e);
                return e;
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
