package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.EstadoCuenta;
import uniandes.edu.co.proyecto.repositorio.EstadoCuentaRepository;

@Controller
public class EstadoCuentaController {

    @Autowired
    private EstadoCuentaRepository estadoCuentaRepository;
    
    @GetMapping("/estadosCuenta")
    public String listarEstadosCuenta(Model model) {
        model.addAttribute("estadosCuenta", estadoCuentaRepository.findAll());
        return "listaEstadosCuenta";
    }

    @GetMapping("/estadosCuenta/nuevo")
    public String formularioNuevoEstadoCuenta(Model model) {
        model.addAttribute("estadoCuenta", new EstadoCuenta());
        return "formularioNuevoEstadoCuenta";
    }

    @PostMapping("/estadosCuenta/nuevo/guardar")
    public String guardarEstadoCuenta(@ModelAttribute EstadoCuenta estadoCuenta) {
        estadoCuentaRepository.save(estadoCuenta);
        return "redirect:/estadosCuenta";
    }

    @GetMapping("/estadosCuenta/{estadoCuenta}/editar")
    public String formularioEditarEstadoCuenta(@PathVariable("estadoCuenta") String estadoCuenta, Model model) {
        EstadoCuenta estadoCuentaEncontrado = estadoCuentaRepository.findById(estadoCuenta).orElse(null);
        if (estadoCuentaEncontrado != null) {
            model.addAttribute("estadoCuenta", estadoCuentaEncontrado);
            return "formularioEditarEstadoCuenta";
        } else {
            return "redirect:/estadosCuenta";
        }
    }

    @PostMapping("/estadosCuenta/{estadoCuenta}/editar/guardar")
    public String guardarEdicionEstadoCuenta(@PathVariable("estadoCuenta") String estadoCuenta, @ModelAttribute EstadoCuenta estadoCuentaActualizado) {
        estadoCuentaActualizado.setEstadoCuenta(estadoCuenta); // Mantener el mismo ID
        estadoCuentaRepository.save(estadoCuentaActualizado);
        return "redirect:/estadosCuenta";
    }

    @GetMapping("/estadosCuenta/{estadoCuenta}/eliminar")
    public String eliminarEstadoCuenta(@PathVariable("estadoCuenta") String estadoCuenta) {
        estadoCuentaRepository.deleteById(estadoCuenta);
        return "redirect:/estadosCuenta";
    }

    
}
