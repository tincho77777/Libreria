
package com.Martin.Libreria.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")   //localhost:8080/
public class MainController {

    @GetMapping("/")          //localhost:8080/persona/inicio   //el get se usa para consultar informacion al servidor
    public String index() {        // lo primero que vemos cuando entramos al localhost es el index
        return "index.html";
    }
    
    //@PostMapping("")    Este se usa para la creacion de un nuevo registro, algo que todavia no existe
    
}
