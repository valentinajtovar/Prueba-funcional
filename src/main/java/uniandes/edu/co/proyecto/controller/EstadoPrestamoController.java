package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.EstadoPrestamo;
import uniandes.edu.co.proyecto.repositorio.EstadoPrestamoRepository;

@Controller
public class EstadoPrestamoController {
    @Autowired
    private EstadoPrestamoRepository estadoPrestamoRepository;
    
    @GetMapping("/estadosPrestamo")
    public String listarEstadosPrestamo(Model model) {
        model.addAttribute("estadosPrestamo", estadoPrestamoRepository.darEstadosPrestamo());
        return "estadosPrestamoLista";
    }

    @GetMapping("/estadosPrestamo/new")
    public String formularioNuevoEstadoPrestamo(Model model) {
        model.addAttribute("estadoPrestamo", new EstadoPrestamo());
        return "estadoPrestamoNuevo";
    }

    @PostMapping("/estadosPrestamo/new/save")
    public String guardarEstadoPrestamo(@ModelAttribute EstadoPrestamo estadoPrestamo) {
        estadoPrestamoRepository.save(estadoPrestamo);
        return "redirect:/estadosPrestamo";
    }

    @GetMapping("/estadosPrestamo/{estadoPrestamo}/edit")
    public String formularioEditarEstadoPrestamo(@PathVariable("estadoPrestamo") String estadoPrestamo, Model model) {
        EstadoPrestamo estadoPrestamoEncontrado = estadoPrestamoRepository.darEstadoPrestamo(estadoPrestamo).orElse(null);
        if (estadoPrestamoEncontrado != null) {
            model.addAttribute("estadoPrestamo", estadoPrestamoEncontrado);
            return "estadoPrestamoEditar";
        } else {
            return "redirect:/estadosPrestamo";
        }
    }

    @PostMapping("/estadosPrestamo/{estadoPrestamo}/edit/save")
    public String guardarEstadoPrestamoEditado(@PathVariable("estadoPrestamo") String estadoPrestamo, @ModelAttribute EstadoPrestamo estadoPrestamoActualizado) {
        estadoPrestamoRepository.actualizarEstadoPrestamo(estadoPrestamoActualizado.getEstadoPrestamo());
        return "redirect:/estadosPrestamo";
    }

    @GetMapping("/estadosPrestamo/{estadoPrestamo}/delete")
    public String eliminarEstadoPrestamo(@PathVariable("estadoPrestamo") String estadoPrestamo) {
        estadoPrestamoRepository.eliminarEstadoPrestamo(estadoPrestamo);
        return "redirect:/estadosPrestamo";
    }
}