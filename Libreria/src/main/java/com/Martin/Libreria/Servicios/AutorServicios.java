package com.Martin.Libreria.Servicios;

import com.Martin.Libreria.Entidades.Autor;
import com.Martin.Libreria.Errores.ErrorServicio;
import com.Martin.Libreria.Repositorios.AutorRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServicios {

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Transactional
    public void cargarAutor(String nombreAutor) throws ErrorServicio {

        validar(nombreAutor);
        Autor autor = new Autor();
        autor.setNombre(nombreAutor);
        autorRepositorio.save(autor);

    }

    @Transactional
    public void modificarAutor(String nombreAutor, String id) throws ErrorServicio {
        Autor autor = autorRepositorio.buscarPorId(id);
        validar(nombreAutor);
        autor.setNombre(nombreAutor);
        autorRepositorio.save(autor);

    }

    @Transactional
    public void eliminarAutor(String nombreAutor, String id) throws ErrorServicio {
        Autor autor = autorRepositorio.buscarPorId(id);
        autorRepositorio.delete(autor);
    }

    private void validar(String nombreAutor) throws ErrorServicio {

        if (nombreAutor == null || nombreAutor.isEmpty()) {
            throw new ErrorServicio("El nombre del autor no puede estar vacio!");
        }
    }

    public List<Autor> listarAutores() {
        List<Autor> autores = autorRepositorio.listarAutores();
        return autores;
    }

    public Autor listarAutor(String id) {
        Autor autor = autorRepositorio.buscarPorId(id);
        return autor;
    }

}
