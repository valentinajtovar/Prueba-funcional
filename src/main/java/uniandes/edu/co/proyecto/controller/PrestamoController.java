package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.modelo.PuntosAtencion;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.EstadoPrestamoRepository;
import uniandes.edu.co.proyecto.repositorio.PrestamoRepository;
import uniandes.edu.co.proyecto.repositorio.PuntosAtencionRepository;
import uniandes.edu.co.proyecto.repositorio.TipoPrestamoRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class PrestamoController {
    
    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstadoPrestamoRepository estadoPrestamoRepository;

    @Autowired
    private TipoPrestamoRepository tipoPrestamoRepository;

    private static final Logger logger = LoggerFactory.getLogger(PrestamoController.class);
    
    @GetMapping("/prestamo")
    public String listarprestamo(Model model) {
        model.addAttribute("prestamos", prestamoRepository.darPrestamos());
        return "prestamo";
    }

    
    @GetMapping("/login_usuario/verificacionLogin/{id_usuario}/prestamos")
    public String listarprestamoSesionIniciada(Model model,@PathVariable("id_usuario") Integer idUsuario,RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioRepository.buscarUsuarioId(idUsuario);
        if ((usuario.getTipoUsuario().getTipoUsuario().equals("GERENTE DE OFICINA")) || (usuario.getTipoUsuario().getTipoUsuario().equals("GERENTE GENERAL"))){
            model.addAttribute("prestamos", prestamoRepository.darPrestamos());
            model.addAttribute("idUsuario", idUsuario);
            return "prestamo";
        }
        else{
            redirectAttributes.addFlashAttribute("noPermisos", "No tienes permiso para ver esta página.");
            return "redirect:/login_usuario/verificacionLogin/" + idUsuario;
        }
    }

    @GetMapping("/prestamo/new")
    public String formularioNuevoPrestamo(Model model) {
        model.addAttribute("prestamos", new Prestamo());
        return "prestamoNuevo";
    }

    @GetMapping("/login_usuario/verificacionLogin/{id_usuario}/prestamos/nuevo")
    public String NuevoPrestamoSesionIniciada(Model model,@PathVariable("id_usuario") Integer idUsuario) {
        model.addAttribute("prestamos", new Prestamo());
        model.addAttribute("idUsuario", idUsuario);
        model.addAttribute("estadosPrestamo", estadoPrestamoRepository.darEstadosPrestamo());
        model.addAttribute("tiposPrestamoNombre", tipoPrestamoRepository.darTiposPrestamoNombre());
        return "prestamoNuevo";
    }

    @PostMapping("/prestamo/new/save/{id_usuario}")
    public String guardarPrestamo(@ModelAttribute("monto") String monto,@ModelAttribute("estadoPrestamo") String estado_prestamo,@ModelAttribute("tipoPrestamo") String tipo_prestamo,@ModelAttribute("interes") String interes,@ModelAttribute("cuota") String cuota,@ModelAttribute("dia_Mes_Cuota") String dia_Mes_Cuota,@ModelAttribute("valor_Cuota") String valor_Cuota,@PathVariable("id_usuario") Integer idUsuario) {
        java.sql.Date fecha = new java.sql.Date(System.currentTimeMillis());
        Float montoFloat = Float.parseFloat(monto);
        Float interesFloat = Float.parseFloat(interes);
        Float valorCuotaFloat = Float.parseFloat(valor_Cuota);
        Integer cuotaInteger = Integer.parseInt(cuota);
        Integer diaMesCuotaInteger = Integer.parseInt(dia_Mes_Cuota);
        prestamoRepository.insertarPrestamo(fecha,montoFloat,estado_prestamo,tipo_prestamo,interesFloat,cuotaInteger,diaMesCuotaInteger,valorCuotaFloat);
        return "redirect:/login_usuario/verificacionLogin/" + idUsuario;
    }

    @GetMapping("/prestamo/{id_Prestamo}/estado_cerrado")
    public String estadoCerradoPrestamo(@PathVariable("id_Prestamo") Integer idPrestamo,Model model) {
        prestamoRepository.estadoPrestamoCerrado(idPrestamo);
        return "redirect:/prestamo";
    }

    @GetMapping("/prestamo/{id_Prestamo}/prestamo_pago_cuota")
    public String pagoCuotaPrestamo(@PathVariable("id_Prestamo") Integer idPrestamo, Model model) {
        Prestamo prestamo = prestamoRepository.buscarPrestamoId(idPrestamo);
        if (prestamo != null) {
            model.addAttribute("prestamo", prestamo);
            return "prestamoPagoCuota";
        }          
         else {
        return "redirect:/prestamo";
    }
    }

    @GetMapping("/prestamo/{id_Prestamo}/prestamo_pago_cuota_extraordinaria")
    public String pagoCuotaExtraordinariaPrestamo(@PathVariable("id_Prestamo") Integer idPrestamo, Model model) {
        Prestamo prestamo = prestamoRepository.buscarPrestamoId(idPrestamo);
        if (prestamo != null) {
            model.addAttribute("prestamo", prestamo);
            return "prestamoPagoCuotaExtraordinaria";
        }          
         else {
        return "redirect:/prestamo";
    }
    }

    @PostMapping("/prestamo/{id_Prestamo}/prestamo_pago_cuota/save")
    public String pagoCuotaGuardar(@PathVariable("id_Prestamo") Integer idPrestamo, @RequestParam("monto") String monto) {
        Prestamo prestamo = prestamoRepository.buscarPrestamoId(idPrestamo);
        float montoFloat = Float.parseFloat(monto);
        float montoFinal = prestamo.getMonto()-montoFloat;
        prestamoRepository.actutalizarMontoPrestamo(idPrestamo,montoFinal);
        logger.info("Fecha: {}, Número de prestamo: {}, Monto: {}, Tipo de operación: pago ordinario",
                    LocalDate.now(), idPrestamo, monto);
        return "redirect:/prestamo";
}

@PostMapping("/prestamo/{id_Prestamo}/prestamo_pago_cuota_extraordinaria/save")
    public String pagoCuotaExtraordinariaGuardar(@PathVariable("id_Prestamo") Integer idPrestamo, @RequestParam("monto") String monto) {
        Prestamo prestamo = prestamoRepository.buscarPrestamoId(idPrestamo);
        float montoFloat = Float.parseFloat(monto);
        float montoFinal = prestamo.getMonto()-montoFloat;
        prestamoRepository.actutalizarMontoPrestamo(idPrestamo,montoFinal);
        logger.info("Fecha: {}, Número de prestamo: {}, Monto: {}, Tipo de operación: pago extraordinario",
                    LocalDate.now(), idPrestamo, monto);
        return "redirect:/prestamo";
}



}
