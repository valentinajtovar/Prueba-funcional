package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TipoCuenta;
import uniandes.edu.co.proyecto.repositorio.TipoCuentaRepository;

@Controller
public class TipoCuentaController {
    @Autowired
    private TipoCuentaRepository tipoCuentaRepository;
    
    @GetMapping("/tiposCuenta")
    public String listarTiposCuenta(Model model) {
        model.addAttribute("tiposCuenta", tipoCuentaRepository.darTiposCuenta());
        return "tiposCuentaLista";
    }

    @GetMapping("/tiposCuenta/new")
    public String formularioNuevoTipoCuenta(Model model) {
        model.addAttribute("tipoCuenta", new TipoCuenta());
        return "tipoCuentaNuevo";
    }

    @PostMapping("/tiposCuenta/new/save")
    public String guardarTipoCuenta(@ModelAttribute TipoCuenta tipoCuenta) {
        tipoCuentaRepository.save(tipoCuenta);
        return "redirect:/tiposCuenta";
    }

    @GetMapping("/tiposCuenta/{tipoCuenta}/edit")
    public String formularioEditarTipoCuenta(@PathVariable("tipoCuenta") String tipoCuenta, Model model) {
        TipoCuenta tipoCuentaEncontrado = tipoCuentaRepository.buscarTipoCuentaPorNombre(tipoCuenta).orElse(null);
        if (tipoCuentaEncontrado != null) {
            model.addAttribute("tipoCuenta", tipoCuentaEncontrado);
            return "tipoCuentaEditar";
        } else {
            return "redirect:/tiposCuenta";
        }
    }

    @PostMapping("/tiposCuenta/{tipoCuenta}/edit/save")
    public String guardarEdicionTipoCuenta(@PathVariable("tipoCuenta") String tipoCuenta, @ModelAttribute TipoCuenta tipoCuentaActualizado) {
        tipoCuentaRepository.actualizarTipoCuenta(tipoCuentaActualizado.getTipoCuenta());
        return "redirect:/tiposCuenta";
    }

    @GetMapping("/tiposCuenta/{tipoCuenta}/delete")
    public String eliminarTipoCuenta(@PathVariable("tipoCuenta") String tipoCuenta) {
        tipoCuentaRepository.eliminarTipoCuenta(tipoCuenta);
        return "redirect:/tiposCuenta";
    }
}
