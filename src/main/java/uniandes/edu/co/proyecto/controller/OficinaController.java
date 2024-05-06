
package uniandes.edu.co.proyecto.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class OficinaController {
    @Autowired
    private OficinaRepository oficinaRepository;

    @Autowired 
    private UsuarioRepository usuarioRepository;
    
    @GetMapping("/oficina")
    public String listarOficina(Model model) {
        model.addAttribute("oficina", oficinaRepository.darOficinas());
        return "oficina";
    }

    
    @GetMapping("/oficina/new")
    public String formularioNuevaOficina(Model model) {
        model.addAttribute("oficina", new Oficina());
        model.addAttribute("gerentes", usuarioRepository.darListaTipoUsuario("GERENTE DE OFICINA"));
        return "oficinaNueva";
    }

    @GetMapping("/login_usuario/verificacionLogin/{id_usuario}/oficina/nueva")
    public String NuevaOficinaSesionIniciada(@PathVariable("id_usuario") Integer idUsuario,RedirectAttributes redirectAttributes,Model model) {
        Usuario usuario = usuarioRepository.buscarUsuarioId(idUsuario);
        if ((usuario.getTipoUsuario().getTipoUsuario().equals("ADMINISTRADOR")) || (usuario.getTipoUsuario().getTipoUsuario().equals("GERENTE GENERAL"))){
            model.addAttribute("oficina", new Oficina());
            model.addAttribute("idUsuario", idUsuario);
            return "oficinaNuevaSesionIniciada";
        }
        else{
            redirectAttributes.addFlashAttribute("noPermisos", "No tienes permiso para ver esta página.");
            return "redirect:/login_usuario/verificacionLogin/" + idUsuario;
        }
        
        
    }

    @PostMapping("/oficina/new/save")
    public String guardarOficina( @ModelAttribute Oficina oficina) {
        oficinaRepository.insertarOficina(oficina.getNombre(),oficina.getDireccion(), oficina.getNumeroPuntosDisponibles(), oficina.getGerente().getIdUsuario());
        return "redirect:/oficina";} 

    @PostMapping("/login_usuario/verificacionLogin/{id_usuario}/oficina/nueva/save")
    public String guardarOficinaSesionIniciada( @PathVariable("id_usuario") Integer idUsuario,@ModelAttribute("nombre") String nombre,
            @ModelAttribute("locacion") String locacion, @ModelAttribute("gerente") String gerente) {
        System.out.println("---------------------");
        System.out.println("entro");
        System.out.println("---------------------");
        return "redirect:/login_usuario/verificacionLogin/" + idUsuario;
    }



    @GetMapping("/oficina/{id_Oficina}/edit")
    public String formularioEditarOficina(@PathVariable("id_Oficina") Integer idOficina, Model model) {
        Oficina oficina = oficinaRepository.buscarOficinaPorId(idOficina);
        if (oficina != null) {
            model.addAttribute("oficina", oficina);
            return "oficinaEditar";
        }          
         else {
        return "redirect:/oficina";
    }
    }


    @PostMapping("/oficinas/{id_Oficina}/edit/save")
    public String OficinaEditarGuardar(@PathVariable("id_Oficina") Integer id, @ModelAttribute Oficina oficina) {
        oficinaRepository.actualizarOficina(id, oficina.getNombre(), oficina.getDireccion(), oficina.getNumeroPuntosDisponibles());
        return "redirect:/oficina";
    }



    @GetMapping("/oficina/{id_Oficina}/delete")
    public String eliminarOficina(@PathVariable("id_Oficina") Integer idOficina) {
        oficinaRepository.eliminarOficina(idOficina);
        return "redirect:/oficina";
    }
}
