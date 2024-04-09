
package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.PuntosAtencion;
import uniandes.edu.co.proyecto.repositorio.PuntosAtencionRepository;

@Controller
public class PuntosAtencionController {
    @Autowired
    private PuntosAtencionRepository puntosAtencionRepository;
    
    @GetMapping("/puntosAtencion")
    public String listarPuntosAtencion(Model model) {
        model.addAttribute("puntosAtencion", puntosAtencionRepository.darPuntosAtencion());
        return "puntosAtencionLista";
    }

    @GetMapping("/puntosAtencion/new")
    public String formularioNuevoPuntosAtencion(Model model) {
        model.addAttribute("puntosAtencion", new PuntosAtencion());
        return "puntosAtencionNuevo";
    }

    @PostMapping("/puntosAtencion/new/save")
    public String guardarPuntosAtencion(@ModelAttribute PuntosAtencion puntosAtencion) {
        puntosAtencionRepository.save(puntosAtencion);
        return "redirect:/puntosAtencion";
    }

    @GetMapping("/puntosAtencion/{idPuntosAtencion}/edit")
    public String formularioEditarPuntosAtencion(@PathVariable("idPuntosAtencion") Integer idPuntosAtencion, Model model) {
        PuntosAtencion puntosAtencion = puntosAtencionRepository.buscarPuntosAtencionPorId(idPuntosAtencion).orElse(null);
        if (puntosAtencion != null) {
            model.addAttribute("puntosAtencion", puntosAtencion);
            return "puntosAtencionEditar";
        } else {
            return "redirect:/puntosAtencion";
        }
    }

    @PostMapping("/puntosAtencion/{idPuntosAtencion}/edit/save")
    public String guardarEdicionPuntosAtencion(@PathVariable("idPuntosAtencion") Integer idPuntosAtencion, @ModelAttribute PuntosAtencion puntosAtencion) {
        puntosAtencionRepository.actualizarPuntosAtencion(
            idPuntosAtencion,
            puntosAtencion.getNombre(),
            puntosAtencion.getTipo(),
            puntosAtencion.getLocacion()
        );
        return "redirect:/puntosAtencion";
    }

    @GetMapping("/puntosAtencion/{idPuntosAtencion}/delete")
    public String eliminarPuntosAtencion(@PathVariable("idPuntosAtencion") Integer idPuntosAtencion) {
        puntosAtencionRepository.eliminarPuntosAtencion(idPuntosAtencion);
        return "redirect:/puntosAtencion";
    }
}
