package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TipoDocumento;
import uniandes.edu.co.proyecto.repositorio.TipoDocumentoRepository;

@Controller
public class TipoDocumentoController {
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;


    @GetMapping("/tiposDocumento")
    public String tiposDocumento(Model model) {
        model.addAttribute("tiposDocumento", tipoDocumentoRepository.darTipoDocumentos());
        return "tiposDocumento";
    }

    @GetMapping("/tiposDocumento/new")
    public String tipoDocumentoForm(Model model) {
        model.addAttribute("tipoDocumento", new TipoDocumento());
        return "tipoDocumentoNuevo";
    }

    @PostMapping("/tiposDocumento/new/save")
    public String tipoDocumentoGuardar(@ModelAttribute TipoDocumento tipoDocumento) {
        tipoDocumentoRepository.insertarTipoDocumento(tipoDocumento.getTipoDocumento());
        return "redirect:/tiposDocumento";
    }

    @GetMapping("/tiposDocumento/{tipoDocumento}/edit")
    public String tipoDocumentoEditarForm(@PathVariable("tipoDocumento") String tipoDocumento, Model model) {
        TipoDocumento tipoDocumentoEncontrado = tipoDocumentoRepository.darTipoDocumento(tipoDocumento).get();
        if (tipoDocumentoEncontrado != null) {
            model.addAttribute("tipoDocumento", tipoDocumentoEncontrado);
            return "tipoDocumentoEditar";
        } else {
            return "redirect:/tiposDocumento";
        }
    }

    @PostMapping("/tiposDocumento/{tipoDocumento}/edit/save")
    public String tipoDocumentoEditarGuardar(@PathVariable("tipoDocumento") String tipoDocumento, @ModelAttribute TipoDocumento tipoDocumentoActualizado) {
        tipoDocumentoRepository.actualizarTipoDocumento(tipoDocumentoActualizado.getTipoDocumento());
        return "redirect:/tiposDocumento";
    }

    @GetMapping("/tiposDocumento/{tipoDocumento}/delete")
    public String tipoDocumentoEliminar(@PathVariable("tipoDocumento") String tipoDocumento) {
        tipoDocumentoRepository.eliminarTipoDocumento(tipoDocumento);
        return "redirect:/tiposDocumento";
    }
}