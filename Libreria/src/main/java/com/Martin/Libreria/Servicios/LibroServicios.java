
package com.Martin.Libreria.Servicios;

import com.Martin.Libreria.Entidades.Autor;
import com.Martin.Libreria.Entidades.Editorial;
import com.Martin.Libreria.Entidades.Libro;
import com.Martin.Libreria.Errores.ErrorServicio;
import com.Martin.Libreria.Repositorios.LibroRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicios {
    
    @Autowired   //con el autowired la variable se inicializa automaticamente, que el servidor de aplicaciones inicizlice esta variable
    private LibroRepositorio libroRepositorio;
    
    //en servicios solo podemos llamar a otros sevicios no puedo llamar a por ej autorRepositorio.
    
    @Transactional    //cada vez que consultamos a la base se dato se usa @transactional porque si hay problemas a mitad de camino no modifique nada importante
    public void registrarLibro(Long ISBN,String titulo,Integer anio,Integer ejemplares,Integer ejemplaresPrestados,Integer ejemplaresRestantes,String nombreEditorial,String nombreAutor)throws ErrorServicio{
        
        if ( ISBN == null || ISBN<0 ){
            throw new ErrorServicio("El numero ISBN no puede ser nulo");
        }
        
        if ( titulo == null || titulo.isEmpty() ){
            throw new ErrorServicio("El titulo no puede ser nulo");
        }
        
        if ( anio == null || anio<0 ){
            throw new ErrorServicio("El año no puede ser nulo");
        }
        
        if ( ejemplares == null || ejemplares<0 ){
            throw new ErrorServicio("El numero de ejemplares no puede ser nulo");
        }
        
        if ( ejemplaresPrestados == null || ejemplaresPrestados<0 ){
            throw new ErrorServicio("El numero de ejemplares prestados no puede ser nulo");
        }
        
        if ( ejemplaresRestantes == null || ejemplaresRestantes<0 ){
            throw new ErrorServicio("El numero de ejemplares restantes no puede ser nulo");
        }
        
        if ( nombreEditorial == null || nombreEditorial.isEmpty() ){
            throw new ErrorServicio("El nombre de la editorial no puede ser nulo");
        }
        
        if ( nombreAutor == null || nombreAutor.isEmpty() ){
            throw new ErrorServicio("El nombre del autor no puede ser nulo");
        }
        
        Libro libro = new Libro();
        libro.setISBN(ISBN);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        libro.setEjemplaresRestantes(ejemplaresRestantes);
        Editorial editorial = new Editorial();
        editorial.setNombre(nombreEditorial);
        Autor autor = new Autor();
        autor.setNombre(nombreAutor);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        
        libroRepositorio.save(libro); //con el save guardamos el libro en la base de datos, se encarga de transformar esta entidad en un tabla para la base de datos
        
    }
    @Transactional
    public void modificarLibro(Long ISBN,String titulo,Integer anio,Integer ejemplares,Integer ejemplaresPrestados, String id,Integer ejemplaresRestantes) throws ErrorServicio{
        
         if ( ISBN == null || ISBN<0 ){
            throw new ErrorServicio("El numero ISBN no puede ser nulo");
        }
        
        if ( titulo == null || titulo.isEmpty() ){
            throw new ErrorServicio("El titulo no puede ser nulo");
        }
        
        if ( anio == null || anio<0 ){
            throw new ErrorServicio("El año no puede ser nulo");
        }
        
        if ( ejemplares == null || ejemplares<0 ){
            throw new ErrorServicio("El numero de ejemplares no puede ser nulo");
        }
        
        if ( ejemplaresPrestados == null || ejemplaresPrestados<0 ){
            throw new ErrorServicio("El numero de ejemplares prestados no puede ser nulo");
        }
        
        if ( ejemplaresRestantes == null || ejemplaresRestantes<0 ){
            throw new ErrorServicio("El numero de ejemplares restantes no puede ser nulo");
        }
      
        
        Libro libro = libroRepositorio.buscarPorId(id);
        libro.setISBN(ISBN);
        libro.setAnio(anio);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        libro.setEjemplaresRestantes(ejemplaresRestantes);
        libroRepositorio.save(libro);
        
    }
    
    @Transactional
    public void eliminarLibro(String id){
        Libro libro = libroRepositorio.buscarPorId(id);
        libroRepositorio.delete(libro);
        
    }
    
    public List<Libro> listarLibros(){
        List<Libro> libros = libroRepositorio.listarLibros();
        return libros;
    }
    
    public Libro listarLibros(String id){
        Libro libro = libroRepositorio.buscarPorId(id);
        return libro;
    }
      
}
