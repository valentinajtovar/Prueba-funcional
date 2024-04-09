package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Nacionalidad;
import uniandes.edu.co.proyecto.repositorio.NacionalidadRepository;

@Controller
public class NacionalidadController {
    @Autowired
    private NacionalidadRepository nacionalidadRepository;
    
    @GetMapping("/nacionalidades")
    public String listarNacionalidades(Model model) {
        model.addAttribute("nacionalidades", nacionalidadRepository.darNacionalidades());
        return "nacionalidadesLista";
    }

    @GetMapping("/nacionalidades/new")
    public String formularioNuevaNacionalidad(Model model) {
        model.addAttribute("nacionalidad", new Nacionalidad());
        return "nacionalidadNueva";
    }

    @PostMapping("/nacionalidades/new/save")
    public String guardarNacionalidad(@ModelAttribute Nacionalidad nacionalidad) {
        nacionalidadRepository.save(nacionalidad);
        return "redirect:/nacionalidades";
    }

    @GetMapping("/nacionalidades/{nombre}/edit")
    public String formularioEditarNacionalidad(@PathVariable("nombre") String nombre, Model model) {
        Nacionalidad nacionalidad = nacionalidadRepository.darNacionalidadPorNombre(nombre).orElse(null);
        if (nacionalidad != null) {
            model.addAttribute("nacionalidad", nacionalidad);
            return "nacionalidadEditar";
        } else {
            return "redirect:/nacionalidades";
        }
    }

    @PostMapping("/nacionalidades/{nombre}/edit/save")
    public String guardarEdicionNacionalidad(@PathVariable("nombre") String nombre, @ModelAttribute Nacionalidad nacionalidad) {
        nacionalidadRepository.actualizarNacionalidad(nombre, nacionalidad.getNombre());
        return "redirect:/nacionalidades";
    }

    @GetMapping("/nacionalidades/{nombre}/delete")
    public String eliminarNacionalidad(@PathVariable("nombre") String nombre) {
        nacionalidadRepository.eliminarNacionalidad(nombre);
        return "redirect:/nacionalidades";
    }
}