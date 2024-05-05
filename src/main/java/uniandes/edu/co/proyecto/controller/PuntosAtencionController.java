
package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.PuntosAtencion;
import uniandes.edu.co.proyecto.modelo.TiposPuntosAtencion;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.repositorio.PuntosAtencionRepository;
import uniandes.edu.co.proyecto.repositorio.TiposPuntosAtencionRepository;

@Controller
public class PuntosAtencionController {
    @Autowired
    private PuntosAtencionRepository puntosAtencionRepository;

    @Autowired 
    private TiposPuntosAtencionRepository tiposPuntosAtencionRepository;

    @Autowired
    private OficinaRepository oficinaRepository;
    
    @GetMapping("/puntosAtencion")
    public String listarPuntosAtencion(Model model) {
        model.addAttribute("puntosAtencion", puntosAtencionRepository.darPuntosAtencion());
        return "puntosAtencion";
    }

    @GetMapping("/puntosAtencion/new")
    public String formularioNuevoPuntosAtencion(Model model) {
        model.addAttribute("puntosAtencion", new PuntosAtencion());
        model.addAttribute("tiposPuntosAtencion", tiposPuntosAtencionRepository.darTiposPuntosAtencion());
        model.addAttribute("oficinas", oficinaRepository.darOficinas());

        return "puntosAtencionNuevo";
    }

    @PostMapping("/puntosAtencion/new/save")
    public String guardarPuntosAtencion(@ModelAttribute("nombre") String nombre,@ModelAttribute("tipo") String tipo,@ModelAttribute("locacion") String locacion,@ModelAttribute("horarioApertura") String horarioApertura,@ModelAttribute("horarioCierre") String horarioCierre,@ModelAttribute("idOficina") Integer idOficina) {
        puntosAtencionRepository.insertarPuntosAtencion(nombre, tipo, locacion, horarioApertura, horarioCierre, idOficina);
        return "redirect:/puntosAtencion";
    }


    @GetMapping("/puntosAtencion/{id_Punto_Atencion}/delete")
    public String eliminarPuntosAtencion(@PathVariable("id_Punto_Atencion") Integer idPuntosAtencion,Model model) {
        puntosAtencionRepository.eliminarPuntosAtencion(idPuntosAtencion);
        return "redirect:/puntosAtencion";
    }
}
