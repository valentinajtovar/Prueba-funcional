package uniandes.edu.co.proyecto.controller;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.modelo.PuntosAtencion;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;

@Controller
public class CuentaController {
    @Autowired
    private CuentaRepository cuentaRepository;
    
    @GetMapping("/cuenta")
    public String listarOficina(Model model) {
        model.addAttribute("cuentas", cuentaRepository.darCuentas());
        return "cuenta";
    }
    @GetMapping("/cuenta/new")
    public String formularioNuevoCuenta(Model model) {
        model.addAttribute("cuentas", new Cuenta());
        return "CuentaNuevo";
    }
    @PostMapping("/cuenta/new/save")
    public String guardarCuenta(@ModelAttribute("tipo_Cuenta") String tipoCuenta,@ModelAttribute("estado_cuenta") String estadoCuenta,@ModelAttribute("saldo") String saldo) {
        /*puntosAtencionRepository.insertarPuntosAtencion(nombre, tipo, locacion, horarioApertura, horarioCierre, idOficinaNumero);
        */
        java.sql.Date fechaUltimaTransaccion = new java.sql.Date(System.currentTimeMillis());


        double saldoNumero = Double.parseDouble(saldo);
        
        cuentaRepository.insertarCuenta(tipoCuenta, estadoCuenta, saldoNumero, fechaUltimaTransaccion);
        
        return "redirect:/cuenta";
    }
}
