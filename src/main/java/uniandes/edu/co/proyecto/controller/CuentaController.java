package uniandes.edu.co.proyecto.controller;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.Optional;

import org.slf4j.LoggerFactory;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class CuentaController {
    @Autowired
    private CuentaRepository cuentaRepository;

    private static final Logger logger = LoggerFactory.getLogger(CuentaController.class);

    //logger.debug("Agregando cuenta: {}", cuenta);
    // logger.debug("Eliminando cuenta con ID: {}", id);

/*
    public void consignarDinero(String numeroCuenta, double monto) {
        // Lógica para consignar dinero
        // Suponemos que el saldo se actualiza correctamente

        // Registro del log
        logger.info("Fecha: {}, Número de cuenta: {}, Monto: {}, Tipo de operación: Consignación",
                    LocalDate.now(), numeroCuenta, monto);
    } */

    
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
       
        java.sql.Date fechaUltimaTransaccion = new java.sql.Date(System.currentTimeMillis());


        double saldoNumero = Double.parseDouble(saldo);
        
        cuentaRepository.insertarCuenta(tipoCuenta, estadoCuenta, saldoNumero, fechaUltimaTransaccion);
        
        return "redirect:/cuenta";
    }

    @GetMapping("/cuenta/{id_cuenta}/desactivar_Cuenta")
    public String desactivarCuenta(@PathVariable("id_cuenta") Integer idCuenta,Model model) {
        cuentaRepository.cambiarEstadoCerrada(idCuenta);
        return "redirect:/cuenta";
    }

    @GetMapping("/cuenta/{id_cuenta}/cerrar_cuenta")
    public String cerrarCuenta(@PathVariable("id_cuenta") Integer idCuenta,Model model) {
        cuentaRepository.cambiarEstadoDesactivada(idCuenta);
        return "redirect:/cuenta";
    }
}
