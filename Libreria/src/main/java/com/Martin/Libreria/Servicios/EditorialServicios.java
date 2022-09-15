package com.Martin.Libreria.Servicios;

import com.Martin.Libreria.Entidades.Editorial;
import com.Martin.Libreria.Errores.ErrorServicio;
import com.Martin.Libreria.Repositorios.EditorialRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServicios {

    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void cargarEditorial(String nombreEditorial) throws ErrorServicio {
        validar(nombreEditorial);
        Editorial editorial = new Editorial();
        editorial.setNombre(nombreEditorial);
        editorialRepositorio.save(editorial);
    }

    @Transactional
    public void modificarEditorial(String nombreEditorial, String id) throws ErrorServicio {
        validar(nombreEditorial);
        Editorial editorial = editorialRepositorio.buscarPorId(id);
        editorial.setNombre(nombreEditorial);
        editorialRepositorio.save(editorial);

    }
    
    @Transactional
    public void eliminarEditorial(String nombreEditorial, String id) throws ErrorServicio{
        Editorial editorial = editorialRepositorio.buscarPorId(id);
        editorialRepositorio.delete(editorial);
    }

    private void validar(String nombreEditorial) throws ErrorServicio {

        if (nombreEditorial == null || nombreEditorial.isEmpty()) {
            throw new ErrorServicio("El nombre de la editorial no puede estar vacio!");
        }
    }
    
    public List<Editorial> listarEditoriales(){
        List<Editorial> editoriales = editorialRepositorio.listarEditorial();
        return editoriales;
    }
    
    public Editorial listarEditorial(String id){
        Editorial editorial = editorialRepositorio.buscarPorId(id);
        return editorial;
    }
}
