package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TipoPrestamo;
import uniandes.edu.co.proyecto.repositorio.TipoPrestamoRepository;

@Controller
public class TipoPrestamoController {
    @Autowired
    private TipoPrestamoRepository tipoPrestamoRepository;
    
    @GetMapping("/tiposPrestamo")
    public String listarTiposPrestamo(Model model) {
        model.addAttribute("tiposPrestamo", tipoPrestamoRepository.darTiposPrestamo());
        return "tiposPrestamoLista";
    }

    @GetMapping("/tiposPrestamo/new")
    public String formularioNuevoTipoPrestamo(Model model) {
        model.addAttribute("tipoPrestamo", new TipoPrestamo());
        return "tipoPrestamoNuevo";
    }

    @PostMapping("/tiposPrestamo/new/save")
    public String guardarTipoPrestamo(@ModelAttribute TipoPrestamo tipoPrestamo) {
        tipoPrestamoRepository.save(tipoPrestamo);
        return "redirect:/tiposPrestamo";
    }

    @GetMapping("/tiposPrestamo/{tipoPrestamo}/edit")
    public String formularioEditarTipoPrestamo(@PathVariable("tipoPrestamo") String tipoPrestamo, Model model) {
        TipoPrestamo tipoPrestamoEncontrado = tipoPrestamoRepository.buscarTipoPrestamoPorNombre(tipoPrestamo).orElse(null);
        if (tipoPrestamoEncontrado != null) {
            model.addAttribute("tipoPrestamo", tipoPrestamoEncontrado);
            return "tipoPrestamoEditar";
        } else {
            return "redirect:/tiposPrestamo";
        }
    }

    @PostMapping("/tiposPrestamo/{tipoPrestamo}/edit/save")
    public String guardarEdicionTipoPrestamo(@PathVariable("tipoPrestamo") String tipoPrestamo, @ModelAttribute TipoPrestamo tipoPrestamoActualizado) {
        tipoPrestamoRepository.actualizarTipoPrestamo(tipoPrestamoActualizado.getPrestamo());
        return "redirect:/tiposPrestamo";
    }

    @GetMapping("/tiposPrestamo/{tipoPrestamo}/delete")
    public String eliminarTipoPrestamo(@PathVariable("tipoPrestamo") String tipoPrestamo) {
        tipoPrestamoRepository.eliminarTipoPrestamo(tipoPrestamo);
        return "redirect:/tiposPrestamo";
    }
}
