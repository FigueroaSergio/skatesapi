/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3.reto3.interfaces;

import org.springframework.data.repository.CrudRepository;
import reto3.reto3.entidades.Categoria;

/**
 *
 * @author figue
 */
public interface InterfaceCategoria extends CrudRepository<Categoria,Integer>{
    
}
