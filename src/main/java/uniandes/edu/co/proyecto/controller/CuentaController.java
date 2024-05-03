package uniandes.edu.co.proyecto.controller;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uniandes.edu.co.proyecto.modelo.CredencialesCuenta;
import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.modelo.PuntosAtencion;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.CredencialesCuentaRepository;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import uniandes.edu.co.proyecto.repositorio.EstadoCuentaRepository;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.repositorio.TipoCuentaRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class CuentaController {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private CredencialesCuentaRepository credencialesCuentaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoCuentaRepository tipoCuentaRepository;

    @Autowired
    private EstadoCuentaRepository estadoCuentaRepository;
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

    @GetMapping("/{idUsuario}/gerenteoficina/cuentagerenteoficina/lista_cuentas")
    public String listaCuentasSesionIniciada(Model model,@PathVariable("idUsuario") Integer idUsuario, RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioRepository.buscarUsuarioId(idUsuario);
        if ((usuario.getTipoUsuario().getTipoUsuario().equals("GERENTE DE OFICINA")) || (usuario.getTipoUsuario().getTipoUsuario().equals("GERENTE GENERAL"))){
            model.addAttribute("cuentas", cuentaRepository.darCuentas());
            model.addAttribute("idUsuario", idUsuario);
            return "cuenta";
        }
        else{
            redirectAttributes.addFlashAttribute("noPermisos", "No tienes permiso para ver esta página.");
            return "redirect:/login_usuario/verificacionLogin/" + idUsuario;
        }
        
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

    @GetMapping("/cuenta/{id_cuenta}/{idUsuario}/desactivar_Cuenta")
    public String desactivarCuenta(@PathVariable("id_cuenta") Integer idCuenta, @PathVariable("idUsuario") Integer idGerente, Model model,RedirectAttributes redirectAttributes) {
        
        CredencialesCuenta credencialesCuenta = credencialesCuentaRepository.buscarCredencialesCuentaPorIdCuenta(idCuenta);
        Cuenta cuenta = cuentaRepository.buscarCuentaPorId(idCuenta);
        if(credencialesCuenta.getGerente().getId().equals(idGerente)){
            if(cuenta.getEstadoCuenta().getEstadoCuenta().equals("ACTIVA")){
                cuentaRepository.cambiarEstadoDesactivada(idCuenta);
            }
            else{
                redirectAttributes.addFlashAttribute("errorEstadoCuenta", "El estado de cuenta es diferente a ACTIVA");
            }
        }
        else{
            redirectAttributes.addFlashAttribute("errorGerente", "El gerente no es el mismo que intenta hacer la modificacion");
        }
        return "redirect:/{idUsuario}/gerenteoficina/cuentagerenteoficina/lista_cuentas";
    }

    @GetMapping("/cuenta/{id_cuenta}/{idUsuario}/cerrar_cuenta")
    public String cerrarCuenta(@PathVariable("id_cuenta") Integer idCuenta, @PathVariable("idUsuario") Integer idGerente, Model model,RedirectAttributes redirectAttributes) {
        CredencialesCuenta credencialesCuenta = credencialesCuentaRepository.buscarCredencialesCuentaPorIdCuenta(idCuenta);
        Cuenta cuenta = cuentaRepository.buscarCuentaPorId(idCuenta);
        if(credencialesCuenta.getGerente().getId().equals(idGerente)){
            if(cuenta.getEstadoCuenta().getEstadoCuenta().equals("ACTIVA")){
                if (cuenta.getSaldo() == 0){
                    cuentaRepository.cambiarEstadoCerrada(idCuenta);
                }
                else{
                    redirectAttributes.addFlashAttribute("errorSaldo", "El saldo de la cuenta es diferente a 0");
                }
            }
            else{
                redirectAttributes.addFlashAttribute("errorEstadoCuenta", "El estado de cuenta es diferente a ACTIVA");
            }
        }
        else{
            redirectAttributes.addFlashAttribute("errorGerente", "El gerente no es el mismo que intenta hacer la modificacion");
        }
        System.out.println("entro");
        return "redirect:/{idUsuario}/gerenteoficina/cuentagerenteoficina/lista_cuentas";
    }

    /*@GetMapping("/cuenta/{id_cuenta}/cerrar_cuenta")
    public String cerrarCuenta(@PathVariable("id_cuenta") Integer idCuenta,Model model) {
        cuentaRepository.cambiarEstadoDesactivada(idCuenta);
        return "redirect:/cuenta";
    }*/

    @GetMapping("/cuenta/{id_cuenta}/cuenta_retirar")
    public String cuentaRetirar(@PathVariable("id_cuenta") Integer idCuenta, Model model) {
        Cuenta cuenta = cuentaRepository.buscarCuentaPorId(idCuenta);
        if (cuenta != null) {
            model.addAttribute("cuenta", cuenta);
            return "cuentaRetirar";
        }          
         else {
        return "redirect:/cuenta";
    }
    } 
    
    @GetMapping("/cuenta/{id_cuenta}/cuenta_consignar")
    public String cuentaConsignar(@PathVariable("id_cuenta") Integer idCuenta, Model model) {
        Cuenta cuenta = cuentaRepository.buscarCuentaPorId(idCuenta);
        if (cuenta != null) {
            model.addAttribute("cuenta", cuenta);
            return "cuentaConsignar";
        }          
         else {
        return "redirect:/cuenta";
    }
    } 

    @PostMapping("/cuenta/{id_cuenta}/cuenta_retirar/save")
    public String retirarCuentaGuardar(@PathVariable("id_cuenta") Integer idCuenta, @RequestParam("monto") String monto) {
        Cuenta cuenta = cuentaRepository.buscarCuentaPorId(idCuenta);
        Double montoFloat = Double.parseDouble(monto);
        Double montoFinal = cuenta.getSaldo()-montoFloat;
        cuentaRepository.cambiarSaldo(idCuenta,montoFinal);
        logger.info("Fecha: {}, Número de cuenta: {}, Monto: {}, Tipo de operación: rertiro",
                    LocalDate.now(), idCuenta, monto);
        return "redirect:/cuenta";
}

@PostMapping("/cuenta/{id_cuenta}/cuenta_consignar/save")
    public String consignarCuentaGuardar(@PathVariable("id_cuenta") Integer idCuenta, @RequestParam("monto") String monto) {
        Cuenta cuenta = cuentaRepository.buscarCuentaPorId(idCuenta);
        Double montoFloat = Double.parseDouble(monto);
        Double montoFinal = cuenta.getSaldo()+montoFloat;
        cuentaRepository.cambiarSaldo(idCuenta,montoFinal);
        logger.info("Fecha: {}, Número de cuenta: {}, Monto: {}, Tipo de operación: rertiro",
                    LocalDate.now(), idCuenta, monto);
        return "redirect:/cuenta";
}


@GetMapping("{idUsuario}/gerenteoficina/cuentagerenteoficina")
public String listarCuentasGerente(Model model,@PathVariable("idUsuario") Integer idUsuario) {
    Collection<Integer> cuentas = credencialesCuentaRepository.darCuentasGerente(idUsuario);
    Collection<Cuenta> cuentasFinales = new ArrayList<>();
    for (Integer cuenta : cuentas) {
        cuentasFinales.add(cuentaRepository.buscarCuentaPorId(cuenta));}
    model.addAttribute("cuentas", cuentasFinales);

    return "cuentagerenteoficina";
}

@GetMapping("{idUsuario}/gerenteoficina/cuentagerenteoficina/cuentanuevogerente/new")
public String formularioNuevoCuentaGerenteOficina(@PathVariable("idUsuario") Integer idUsuario,Model model) {
    model.addAttribute("tipoCuentas", tipoCuentaRepository.darTiposCuenta());
    model.addAttribute("estadoCuentas", estadoCuentaRepository.darEstadoCuenta("ACTIVA"));
    model.addAttribute("clientes", usuarioRepository.darListaUsuarios("CLIENTE NATURAL", "CLIENTE JURIDICO"));
    model.addAttribute("idGerente", idUsuario);
    model.addAttribute("cuenta", new Cuenta());
    model.addAttribute("credenciales", new CredencialesCuenta());
    return "cuentanuevogerente";
}

@PostMapping("/{idUsuario}/gerenteoficina/cuentagerenteoficina/cuentanuevogerente/new/save")
public String guardarCuentaGerenteDeOficina(@ModelAttribute Cuenta cuenta, @ModelAttribute CredencialesCuenta credenciales, @PathVariable("idUsuario") Integer idGerente,@RequestParam("tipoCuenta") String tipoCuenta,@RequestParam("estadoCuenta") String estadoCuenta,@RequestParam("saldo") String saldo,@RequestParam("fechaUltimaTransaccion") Date fechaUltimaTransaccion,@RequestParam("idUsuario") Integer idCliente){
    double saldoDouble = Double.parseDouble(saldo);
    cuentaRepository.insertarCuenta(tipoCuenta,estadoCuenta,saldoDouble,fechaUltimaTransaccion);
    Integer idCuenta = cuentaRepository.DarIdMaximo();
    credencialesCuentaRepository.insertarCredencialesCuenta(idCliente, idGerente, idCuenta);;
    return "sesionIniciada";
}
}
