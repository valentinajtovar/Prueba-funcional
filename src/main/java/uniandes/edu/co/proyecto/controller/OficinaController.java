
package uniandes.edu.co.proyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;

@Controller
public class OficinaController {
    @Autowired
    private OficinaRepository oficinaRepository;
    
    @GetMapping("/oficina")
    public String listarOficina(Model model) {
        model.addAttribute("oficina", oficinaRepository.darOficinas());
        return "oficina";
    }

    
    @GetMapping("/oficina/new")
    public String formularioNuevaOficina(Model model) {
        model.addAttribute("oficina", new Oficina());
        return "oficinaNueva";
    }

    @PostMapping("/oficina/new/save")
    public String guardarOficina( @ModelAttribute("nombre") String nombre,
            @ModelAttribute("locacion") String locacion, @ModelAttribute("gerente") Integer gerente) {
        oficinaRepository.insertarOficina(nombre, locacion, gerente);
        return "redirect:/oficina";} 



    @GetMapping("/oficina/{id_Oficina}/edit")
    public String formularioEditarOficina(@PathVariable("id_Oficina") Integer idOficina, Model model) {
        Oficina oficina = oficinaRepository.buscarOficinaPorId(idOficina);
        if (oficina != null) {
            model.addAttribute("oficina", oficina);
            return "oficinaEditar";
        }          
         else {
        return "redirect:/oficina";
    }
    }


    @PostMapping("/oficinas/{id_Oficina}/edit/save")
    public String OficinaEditarGuardar(@PathVariable("id_Oficina") Integer id, @ModelAttribute Oficina oficina) {
        oficinaRepository.actualizarOficina(id, oficina.getNombre(), oficina.getDireccion(), oficina.getNumeroPuntosDisponibles());
        return "redirect:/oficina";
    }



    @GetMapping("/oficina/{id_Oficina}/delete")
    public String eliminarOficina(@PathVariable("id_Oficina") Integer idOficina) {
        oficinaRepository.eliminarOficina(idOficina);
        return "redirect:/oficina";
    }
}
