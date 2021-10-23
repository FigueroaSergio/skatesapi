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
import reto3.reto3.entidades.Categoria;
import reto3.reto3.repositorios.RepositorioCategoria;

/**
 *
 * @author figue
 */
@Service
public class ServiciosCategoria {
    @Autowired
    private RepositorioCategoria metodosCrud;

    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Categoria> getCategoria(int CategoriaId) {
        return metodosCrud.getCategoria(CategoriaId);
    }

    public Categoria save(Categoria categoria) {
        if (categoria.getId()== null) {
            return metodosCrud.save(categoria);
        } else {
            Categoria categoria1 = metodosCrud.getCategoria(categoria.getId()).orElse(null);
            if (categoria1==null) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Categoria g=metodosCrud.getCategoria(categoria.getId()).orElse(null);
            if(!(g==null)){
                if(categoria.getDescription()!=null){
                    g.setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.setName(categoria.getName());
                }
                return metodosCrud.save(g);
            }
        }
        return categoria;
    }
    public boolean deletecategoria(int categoriaId){
        Boolean d=getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}
