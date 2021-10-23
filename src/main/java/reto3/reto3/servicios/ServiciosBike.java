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
import reto3.reto3.entidades.Bike;
import reto3.reto3.repositorios.RepositorioBike;

/**
 *
 * @author figue
 */
@Service
public class ServiciosBike {
    @Autowired
    private RepositorioBike metodosCrud;

    public List<Bike> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Bike> getBike(int bikeId) {
        return metodosCrud.getBike(bikeId);
    }

    public Bike save(Bike bike){
        if(bike.getId()==null){
            return metodosCrud.save(bike);
        }else{
            Bike e=metodosCrud.getBike(bike.getId()).orElse(null);
            if(e==null){
                return metodosCrud.save(bike);
            }else{
                return bike;
            }
        }
    }

    public Bike update(Bike bike){
        if(bike.getId()!=null){
            Bike e=metodosCrud.getBike(bike.getId()).orElse(null);
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
