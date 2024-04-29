package uniandes.edu.co.proyecto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.modelo.PuntosAtencion;
import uniandes.edu.co.proyecto.repositorio.PrestamoRepository;
import uniandes.edu.co.proyecto.repositorio.PuntosAtencionRepository;

@Controller
public class PrestamoController {
    
    @Autowired
    private PrestamoRepository prestamoRepository;

    private static final Logger logger = LoggerFactory.getLogger(PrestamoController.class);
    
    @GetMapping("/prestamo")
    public String listarprestamo(Model model) {
        model.addAttribute("prestamos", prestamoRepository.darPrestamos());
        return "prestamo";
    }

    @GetMapping("/prestamo/new")
    public String formularioNuevoPrestamo(Model model) {
        model.addAttribute("prestamos", new Prestamo());
        return "prestamoNuevo";
    }

    @PostMapping("/prestamo/new/save")
    public String guardarPrestamo(@ModelAttribute("monto") String monto,@ModelAttribute("estado_prestamo") String estado_prestamo,@ModelAttribute("tipo_prestamo") String tipo_prestamo,@ModelAttribute("interes") String interes,@ModelAttribute("cuota") String cuota,@ModelAttribute("dia_Mes_Cuota") String dia_Mes_Cuota,@ModelAttribute("valor_Cuota") String valor_Cuota) {
        java.sql.Date fecha = new java.sql.Date(System.currentTimeMillis());
        Float montoFloat = Float.parseFloat(monto);
        Float interesFloat = Float.parseFloat(interes);
        Float valorCuotaFloat = Float.parseFloat(valor_Cuota);
        Integer cuotaInteger = Integer.parseInt(cuota);
        Integer diaMesCuotaInteger = Integer.parseInt(dia_Mes_Cuota);
        prestamoRepository.insertarPrestamo(fecha,montoFloat,estado_prestamo,tipo_prestamo,interesFloat,cuotaInteger,diaMesCuotaInteger,valorCuotaFloat);
        return "redirect:/prestamo";
    }

    @GetMapping("/prestamo/{id_Prestamo}/estado_cerrado")
    public String estadoCerradoPrestamo(@PathVariable("id_Prestamo") Integer idPrestamo,Model model) {
        prestamoRepository.estadoPrestamoCerrado(idPrestamo);
        return "redirect:/prestamo";
    }

}
