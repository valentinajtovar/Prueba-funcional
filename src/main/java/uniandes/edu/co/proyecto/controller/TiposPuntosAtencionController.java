
package uniandes.edu.co.proyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TiposPuntosAtencion;
import uniandes.edu.co.proyecto.repositorio.TiposPuntosAtencionRepository;

import org.springframework.ui.Model;

@Controller
public class TiposPuntosAtencionController {
    @Autowired
    private TiposPuntosAtencionRepository tiposPuntosAtencionRepository;
    
    @GetMapping("/tiposPuntosAtencion")
    public String listarTiposPuntosAtencion(Model model) {
        model.addAttribute("tiposPuntosAtencion", tiposPuntosAtencionRepository.darTiposPuntosAtencion());
        return "tiposPuntosAtencionLista";
    }

    @GetMapping("/tiposPuntosAtencion/new")
    public String formularioNuevaOficina(Model model) {
        model.addAttribute("tiposPuntosAtencion", new TiposPuntosAtencion());
        return "TiposPuntosAtencionNueva";
    }

    @PostMapping("/tiposPuntosAtencion/new/save")
    public String guardarTiposPuntosAtencion(@ModelAttribute TiposPuntosAtencion tiposPuntosAtencion) {
        tiposPuntosAtencionRepository.insertarTiposPuntosAtencion(tiposPuntosAtencion.getTipoPuntoAtencion());
        return "redirect:/tiposPuntosAtencion";
    }

    @GetMapping("/tiposPuntosAtencion/{id_Tipos_Puntos_Atencion}/edit")
    public String formularioEditarTiposPuntosAtencion(@PathVariable("id_Tipos_Puntos_Atencion") Integer idTiposPuntosAtencion, Model model) {
        Optional<TiposPuntosAtencion> tiposPuntosAtencion = tiposPuntosAtencionRepository.darTipoPuntosAtencion(idTiposPuntosAtencion);
        if (tiposPuntosAtencion != null) {
            model.addAttribute("tiposPuntosAtencion", tiposPuntosAtencion);
            return "tiposPuntosAtencionEditar";
        } else {
            return "redirect:/tiposPuntosAtencion";
        }
    }

    @PostMapping("/tiposPuntosAtencion/{idTiposPuntosAtencion}/edit/save")
    public String guardarEdicionTiposPuntosAtencion(@PathVariable("idTiposPuntosAtencion") Integer idTiposPuntosAtencion, @ModelAttribute TiposPuntosAtencion tiposPuntosAtencion) {
        tiposPuntosAtencionRepository.actualizarTiposPuntosAtencion(idTiposPuntosAtencion, tiposPuntosAtencion.getTipoPuntoAtencion());
        return "redirect:/tiposPuntosAtencion";
    }

    @GetMapping("/tiposPuntosAtencion/{idTiposPuntosAtencion}/delete")
    public String eliminarTiposPuntosAtencion(@PathVariable("idTiposPuntosAtencion") Integer idTiposPuntosAtencion) {
        tiposPuntosAtencionRepository.eliminarTiposPuntosAtencion(idTiposPuntosAtencion);
        return "redirect:/tiposPuntosAtencion";
    }
}
