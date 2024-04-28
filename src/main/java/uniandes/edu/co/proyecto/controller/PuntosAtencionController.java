
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
        return "puntosAtencion";
    }

    @GetMapping("/puntosAtencion/new")
    public String formularioNuevoPuntosAtencion(Model model) {
        model.addAttribute("puntosAtencion", new PuntosAtencion());
        return "puntosAtencionNuevo";
    }

    @PostMapping("/puntosAtencion/new/save")
    public String guardarPuntosAtencion(@ModelAttribute("nombre") String nombre,@ModelAttribute("tipo") String tipo,@ModelAttribute("locacion") String locacion,@ModelAttribute("horarioApertura") String horarioApertura,@ModelAttribute("horarioCierre") String horarioCierre,@ModelAttribute("idOficina") String idOficina) {
        int idOficinaNumero = Integer.parseInt(idOficina);
        System.out.println(nombre);
        System.out.println(tipo);
        System.out.println(locacion);
        System.out.println(horarioApertura);
        System.out.println(horarioCierre);
        System.out.println(idOficinaNumero);
        puntosAtencionRepository.insertarPuntosAtencion(nombre, tipo, locacion, horarioApertura, horarioCierre, idOficinaNumero);
        return "redirect:/puntosAtencion";
    }


    @GetMapping("/puntosAtencion/{id_Punto_Atencion}/delete")
    public String eliminarPuntosAtencion(@PathVariable("id_Punto_Atencion") Integer idPuntosAtencion,Model model) {
        puntosAtencionRepository.eliminarPuntosAtencion(idPuntosAtencion);
        return "redirect:/puntosAtencion";
    }
}
