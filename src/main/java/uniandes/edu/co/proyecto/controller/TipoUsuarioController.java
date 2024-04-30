package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;

@Controller
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;
    
    @GetMapping("/tiposUsuario")
    public String tiposUsuario(Model model) {
        model.addAttribute("tiposUsuario", tipoUsuarioRepository.darTipoUsuarios());
        return "tiposUsuario";
    }

    @GetMapping("/tiposUsuario/new")
    public String tipoUsuarioForm(Model model) {
        model.addAttribute("tipoUsuario", new TipoUsuario());
        return "tipoUsuarioNuevo";
    }

    @PostMapping("/tiposUsuario/new/save")
    public String tipoUsuarioGuardar(@ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.insertarTipoUsuario(tipoUsuario.getTipoUsuario());
        return "redirect:/tiposUsuario";
    }

    @GetMapping("/tiposUsuario/{tipoUsuario}/edit")
    public String tipoUsuarioEditarForm(@PathVariable("tipoUsuario") String tipoUsuario, Model model) {
        TipoUsuario tipoUsuarioEncontrado = tipoUsuarioRepository.darTipoUsuario(tipoUsuario).get();
        if (tipoUsuarioEncontrado != null) {
            model.addAttribute("tipoUsuario", tipoUsuarioEncontrado);
            return "tipoUsuarioEditar";
        } else {
            return "redirect:/tiposUsuario";
        }
    }

    @PostMapping("/tiposUsuario/{tipoUsuario}/edit/save")
    public String tipoUsuarioEditarGuardar(@PathVariable("tipoUsuario") String tipoUsuario, @ModelAttribute TipoUsuario tipoUsuarioActualizado) {
        tipoUsuarioRepository.actualizarTipoUsuario(tipoUsuarioActualizado.getTipoUsuario());
        return "redirect:/tiposUsuario";
    }

    @GetMapping("/tiposUsuario/{tipoUsuario}/delete")
    public String tipoUsuarioEliminar(@PathVariable("tipoUsuario") String tipoUsuario) {
        tipoUsuarioRepository.eliminarTipoUsuario(tipoUsuario);
        return "redirect:/tiposUsuario";
    }
}