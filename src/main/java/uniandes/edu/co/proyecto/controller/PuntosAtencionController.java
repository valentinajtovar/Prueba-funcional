
package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uniandes.edu.co.proyecto.modelo.PuntosAtencion;
import uniandes.edu.co.proyecto.modelo.TiposPuntosAtencion;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.repositorio.PuntosAtencionRepository;
import uniandes.edu.co.proyecto.repositorio.TiposPuntosAtencionRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class PuntosAtencionController {
    @Autowired
    private PuntosAtencionRepository puntosAtencionRepository;

    @Autowired 
    private TiposPuntosAtencionRepository tiposPuntosAtencionRepository;

    @Autowired
    private OficinaRepository oficinaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping("/puntosAtencion")
    public String listarPuntosAtencion(Model model) {
        model.addAttribute("puntosAtencion", puntosAtencionRepository.darPuntosAtencion());
        return "puntosAtencion";
    }

    @GetMapping("/login_usuario/verificacionLogin/{id_usuario}/puntosAtencion")
    public String listarPuntosAtencionSesionIniciada(Model model) {
        model.addAttribute("puntosAtencion", puntosAtencionRepository.darPuntosAtencion());
        return "puntosAtencion";
    }


    @GetMapping("/login_usuario/verificacionLogin/{id_usuario}/puntosAtencion/nueva")
    public String formularioNuevoPuntosAtencion(@PathVariable("id_usuario") Integer idUsuario,Model model,RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioRepository.buscarUsuarioId(idUsuario);
         if ( (usuario.getTipoUsuario().getTipoUsuario().equals("ADMINISTRADOR"))) {
            model.addAttribute("puntosAtencion", new PuntosAtencion());
            model.addAttribute("tiposPuntosAtencion", tiposPuntosAtencionRepository.darTiposPuntosAtencion());
            model.addAttribute("oficinas", oficinaRepository.darOficinas());
            model.addAttribute("idUsuario", idUsuario);
            return "puntosAtencionNuevo";}

         else {
                redirectAttributes.addFlashAttribute("errorCreacionUsuario", "No tienes permisos");
                return "redirect:/login_usuario/verificacionLogin/" + usuario.getIdUsuario();
            }
        
    
    }

    @PostMapping("/login_usuario/verificacionLogin/{id_usuario}/puntosAtencion/nueva/save")
    public String guardarPuntoAtencionSesionIniciada( @PathVariable("id_usuario") Integer idUsuario,String nombre,
            String locacion,String tipo, String horarioApertura, String horarioCierre, Integer idOficina) {
                puntosAtencionRepository.insertarPuntosAtencion(nombre, tipo, locacion, horarioApertura, horarioCierre, idOficina);
        return "redirect:/login_usuario/verificacionLogin/" + idUsuario;
    }

    @PostMapping("puntoAtencion/new/save")
    public String guardarPuntosAtencion(@ModelAttribute("nombre") String nombre,@ModelAttribute("tipo") String tipo,@ModelAttribute("locacion") String locacion,@ModelAttribute("horarioApertura") String horarioApertura,@ModelAttribute("horarioCierre") String horarioCierre,@ModelAttribute("idOficina") Integer idOficina, @PathVariable("id_usuario") Integer idUsuario) {
        puntosAtencionRepository.insertarPuntosAtencion(nombre, tipo, locacion, horarioApertura, horarioCierre, idOficina);
        return "redirect:/puntosAtencion" ;
    }


    @GetMapping("/puntosAtencion/{id_Punto_Atencion}/delete")
    public String eliminarPuntosAtencion(@PathVariable("id_Punto_Atencion") Integer idPuntosAtencion,Model model) {
        puntosAtencionRepository.eliminarPuntosAtencion(idPuntosAtencion);
        return "redirect:/puntosAtencion";
    }
}
