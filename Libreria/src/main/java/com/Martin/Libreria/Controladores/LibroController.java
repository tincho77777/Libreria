package com.Martin.Libreria.Controladores;

import com.Martin.Libreria.Entidades.Libro;
import com.Martin.Libreria.Errores.ErrorServicio;
import com.Martin.Libreria.Servicios.LibroServicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/libro")         //localhost:8080/lista
public class LibroController {

    @Autowired
    private LibroServicios libroServicios;

    @GetMapping("/lista")
    public String lista(ModelMap modelo) {
        List<Libro> libros = libroServicios.listarLibros();
        modelo.addAttribute("libros", libros);
        return "list-libro.html";
    }

    @GetMapping("/registro")    //localhost:8080/libros/registro
    public String formulario() {

        return "form-libro";
    }

    @PostMapping("/registro")
    public String guardar(ModelMap modelo, @RequestParam Long ISBN, @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, @RequestParam Integer ejemplaresPrestados, @RequestParam Integer ejemplaresRestantes, @RequestParam String nombreEditorial, @RequestParam String nombreAutor) throws ErrorServicio {

        try {
            libroServicios.registrarLibro(ISBN, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes, nombreEditorial, nombreAutor);

            modelo.put("exito","registro exitoso!");
            return "form-libro";
        } catch (Exception e) {
            modelo.put("error", "faltó algun dato!");
            return "from-libro";
        }

    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        try {
            libroServicios.eliminarLibro(id);
            return "redirect:/libro/lista";
        } catch (Exception e) {
            return "listaLibros.html";
        }
    }

    @GetMapping("/modificar/{id}")
    public String modificar(ModelMap modelo, @PathVariable String id) {
        Libro libro = libroServicios.listarLibros(id);
        modelo.addAttribute("libro", libro);
        return "modificarLibro";

    }

    @PostMapping("/confirmarModificacion/{id}")
    public String confirmarModificacion(ModelMap modelo, @PathVariable String id, @RequestParam long ISBN, @RequestParam String titulo, @RequestParam int anio, @RequestParam int ejemplares, @RequestParam int ejemplaresPrestados) {
        try {
            libroServicios.modificarLibro(ISBN, titulo, anio, ejemplares, ejemplaresPrestados, id, ejemplaresPrestados);
            modelo.put("exito", "Registro exitoso");
            return "redirect:/libro/lista";
        } catch (Exception e) {
            modelo.put("error", "Falto algun dato");
            return "form-libro";
        }
    }
}
