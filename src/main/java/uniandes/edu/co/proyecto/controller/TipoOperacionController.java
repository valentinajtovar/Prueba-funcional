/*package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TipoOperacion;
import uniandes.edu.co.proyecto.repositorio.TipoOperacionRepository;

@Controller
public class TipoOperacionController {
    @Autowired
    private TipoOperacionRepository tipoOperacionRepository;
    
    @GetMapping("/tiposOperacion")
    public String listarTiposOperacion(Model model) {
        model.addAttribute("tiposOperacion", tipoOperacionRepository.darTiposOperacion());
        return "tiposOperacionLista";
    }

    @GetMapping("/tiposOperacion/new")
    public String formularioNuevoTipoOperacion(Model model) {
        model.addAttribute("tipoOperacion", new TipoOperacion());
        return "tipoOperacionNuevo";
    }

    @PostMapping("/tiposOperacion/new/save")
    public String guardarTipoOperacion(@ModelAttribute TipoOperacion tipoOperacion) {
        tipoOperacionRepository.save(tipoOperacion);
        return "redirect:/tiposOperacion";
    }

    @GetMapping("/tiposOperacion/{tipoOperacion}/edit")
    public String formularioEditarTipoOperacion(@PathVariable("tipoOperacion") String tipoOperacion, Model model) {
        TipoOperacion tipoOperacionEncontrado = tipoOperacionRepository.buscarTipoOperacionPorNombre(tipoOperacion).orElse(null);
        if (tipoOperacionEncontrado != null) {
            model.addAttribute("tipoOperacion", tipoOperacionEncontrado);
            return "tipoOperacionEditar";
        } else {
            return "redirect:/tiposOperacion";
        }
    }

    @PostMapping("/tiposOperacion/{tipoOperacion}/edit/save")
    public String guardarEdicionTipoOperacion(@PathVariable("tipoOperacion") String tipoOperacion, @ModelAttribute TipoOperacion tipoOperacionActualizado) {
        tipoOperacionRepository.actualizarTipoOperacion(tipoOperacionActualizado.getTipoOperacion());
        return "redirect:/tiposOperacion";
    }

    @GetMapping("/tiposOperacion/{tipoOperacion}/delete")
    public String eliminarTipoOperacion(@PathVariable("tipoOperacion") String tipoOperacion) {
        tipoOperacionRepository.eliminarTipoOperacion(tipoOperacion);
        return "redirect:/tiposOperacion";
    }
}
*/