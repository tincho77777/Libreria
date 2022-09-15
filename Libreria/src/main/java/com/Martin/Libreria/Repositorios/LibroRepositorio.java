
package com.Martin.Libreria.Repositorios;

import com.Martin.Libreria.Entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository <Libro, String> {     //si lo creamos como clase java normal acordarse cambiarlo a interface aca 
    
    
    @Query("SELECT c FROM Libro c")
    public List <Libro> listarLibros();
    
    
    @Query("SELECT c FROM Libro c WHERE c.id = :id")
    public Libro buscarPorId(@Param ("id")String id);
}
