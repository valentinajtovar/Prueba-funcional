package uniandes.edu.co.proyecto.controller;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.DatosUsuario;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.DatosUsuarioRepository;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.repositorio.TipoDocumentoRepository;
import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
    
    @GetMapping("/usuario")
    public String listarUsuario(Model model) {
        model.addAttribute("usuario", usuarioRepository.darUsuarios());
        return "usuario";
    }

    @GetMapping("/login_usuario")
    public String login(Model model) {
        model.addAttribute("usuario", usuarioRepository.darUsuarios());
        return "loginUsuario";
    }

    @GetMapping("/usuario/new")
    public String formularioNuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarioNuevo";
    }


    @GetMapping("/login_usuario/verificacionLogin/{tipoUsuario}/{idUsuario}")
    public String sesionIniciada(@PathVariable("tipoUsuario") String tipo,@PathVariable("idUsuario") Integer idUsuario, Model model, RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioRepository.buscarUsuarioId(idUsuario);
        if (usuario != null) {
            model.addAttribute("usuario",usuarioRepository.buscarUsuarioId(idUsuario));
            return tipo;
        }          
         else {
            
        return "redirect:/login_usuario";
        }
    }


    @PostMapping("/login_usuario/verificacionLogin")
    public String verificarLogin(@RequestParam("login") String login,@RequestParam("clave") String clave,RedirectAttributes redirectAttributes) {
        Collection<String> logins = usuarioRepository.darLogin();
        boolean existeLogin = false;
        Usuario usuario = new Usuario();
        for (String elementoLogin: logins)
		{
            if (login.equals(elementoLogin)){
                existeLogin = true;
                usuario = usuarioRepository.darUsuarioPorLogin(login);
                break;
            }
		}
        if(existeLogin){
            
            if(usuario.getClave().equals(clave)){
                redirectAttributes.addFlashAttribute("idUsuario", usuario.getIdUsuario());
                return "redirect:/login_usuario/verificacionLogin/" + usuario.getTipoUsuario().getTipoUsuarioSinEspacios()+ "/" + usuario.getIdUsuario();
            }
            else{
                redirectAttributes.addFlashAttribute("errorLogin", "Usuario o contraseña no coincide");
                return "redirect:/login_usuario";
            }
        }
        else{
            redirectAttributes.addFlashAttribute("errorLogin", "Usuario o contraseña no coincide");
            return "redirect:/login_usuario";
        }
        
    }




}
