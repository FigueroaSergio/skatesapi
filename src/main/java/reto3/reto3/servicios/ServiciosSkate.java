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
import reto3.reto3.entidades.Skate;
import reto3.reto3.repositorios.RepositorioSkate;

/**
 *
 * @author figue
 */
@Service
public class ServiciosSkate {
    @Autowired
    private RepositorioSkate metodosCrud;

    public List<Skate> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Skate> getBike(int bikeId) {
        return metodosCrud.getBike(bikeId);
    }

    public Skate save(Skate bike){
        if(bike.getId()==null){
            return metodosCrud.save(bike);
        }else{
            Skate e=metodosCrud.getBike(bike.getId()).orElse(null);
            if(e==null){
                return metodosCrud.save(bike);
            }else{
                return bike;
            }
        }
    }

    public Skate update(Skate bike){
        if(bike.getId()!=null){
            Skate e=metodosCrud.getBike(bike.getId()).orElse(null);
            if(!(e==null)){
                if(bike.getName()!=null){
                    e.setName(bike.getName());
                }
                if(bike.getBrand()!=null){
                    e.setBrand(bike.getBrand());
                }
                if(bike.getYear()!=null){
                    e.setYear(bike.getYear());
                }
                if(bike.getDescription()!=null){
                    e.setDescription(bike.getDescription());
                }
                if(bike.getCategory()!=null){
                    e.setCategory(bike.getCategory());
                }
                metodosCrud.save(e);
                return e;
            }else{
                return bike;
            }
        }else{
            return bike;
        }
    }


    public boolean deleteBike(int bikeId) {
        Boolean aBoolean = getBike(bikeId).map(bike -> {
            metodosCrud.delete(bike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
