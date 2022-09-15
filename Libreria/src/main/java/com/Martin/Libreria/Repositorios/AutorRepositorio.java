
package com.Martin.Libreria.Repositorios;

import com.Martin.Libreria.Entidades.Autor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository< Autor,String> {
    
    
    @Query("SELECT c FROM Autor c")
    public List<Autor> listarAutores();
    
    
    @Query("SELECT c FROM Autor c WHERE c.id = :id")
    public Autor buscarPorId(@Param("id")String id);    //el @Param se pone porque en la query se busca por id
    
    
    
}
