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


    //LOGIN ORIGINAL
/* 
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
*/
    //LOGIN QUE VERIFICA Y REGRESA DIRECCION POR TIPO DE USUARIO
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
                return "redirect:/login_usuario/verificacionLogin/" + usuario.getIdUsuario();
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

    @GetMapping("/login_usuario/verificacionLogin/{id_usuario}")
    public String sesionIniciada(@PathVariable("id_usuario") Integer idUsuario,Model model) {
        Usuario usuario = usuarioRepository.buscarUsuarioId(idUsuario);

        if (usuario != null) {
            model.addAttribute("idUsuario", idUsuario);
            return "sesionIniciada";
        }          
         else {
        return "redirect:/login_usuario";
        }
    }

    @GetMapping("/login_usuario/verificacionLogin/{id_usuario}/crear_usuario")
    public String crearUsuario(@PathVariable("id_usuario") Integer idUsuario,Model model,RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioRepository.buscarUsuarioId(idUsuario);
        Collection<String> tipoUsuarios= new ArrayList<>();
        if (usuario.getTipoUsuario().getTipoUsuario().equals("CAJERO") || (usuario.getTipoUsuario().getTipoUsuario().equals("GERENTE DE OFICINA"))|| (usuario.getTipoUsuario().getTipoUsuario().equals("GERENTE GENERAL"))) {
            Collection<String> tiposUsuarios = tipoUsuarioRepository.darNombres();
            Collection<String> tiposDocumentos = tipoDocumentoRepository.darTipoDocumentosNombres();
            for (String tipo: tiposUsuarios)
		    {
                if(usuario.getTipoUsuario().getTipoUsuario().equals("GERENTE DE OFICINA")){
                    tipoUsuarios.add(tipo);
                }
                else {
                    if(tipo.contains("CLIENTE") != true){
                        tipoUsuarios.add(tipo);
                    }
                }
		    }
            model.addAttribute("tiposUsuarios", tipoUsuarios);
            model.addAttribute("tiposDocumentos", tiposDocumentos);
            model.addAttribute("idUsuario", idUsuario);
            return "CrearUsuarioCliente";
        }
         else {
            redirectAttributes.addFlashAttribute("errorCreacionUsuario", "No tienes permisos para crear ningun tipo de usuario");
            return "redirect:/login_usuario/verificacionLogin/" + usuario.getIdUsuario();
        }
    }

    @PostMapping("/login_usuario/verificacionLogin/{id_usuario}/crear_usuario/save")
    public String crearUsuario(@PathVariable("id_usuario") Integer idUsuario,Model model,RedirectAttributes redirectAttributes ,@RequestParam("nombre") String nombre,@RequestParam("numeroDocumento") String numeroDocumento,@RequestParam("nacionalidad") String nacionalidad,@RequestParam("direccionFisica") String direccionFisica,@RequestParam("direccionDigital") String direccionDigital,@RequestParam("telefono") String telefono,@RequestParam("codigoPostal") String codigoPostal,@RequestParam("login") String login,@RequestParam("clave") String clave,@RequestParam("tipoDocumento") String tipoDocumento,@RequestParam("tipoUsuario") String tipoUsuario) {
        Collection<String> listaLogins = usuarioRepository.darLogin();
        Boolean loginExiste = false;
        for (String elementoLogin: listaLogins){
            if (elementoLogin.equals(login)){
                loginExiste = true;
            }
        }
        if (loginExiste){
            redirectAttributes.addFlashAttribute("errorCreacionUsuario", "El login ya existe, cambie de login y reintentelo");
            return "redirect:/login_usuario/verificacionLogin/" + idUsuario + "/crear_usuario";
        }
        else{
            model.addAttribute("idUsuario", idUsuario);
            int numeroDocumentoInteger = Integer.parseInt(numeroDocumento);
            Long telefonoLong = Long.parseLong(telefono);
            int codigoPostalInteger = Integer.parseInt(codigoPostal);
            usuarioRepository.crearUsuario(tipoDocumento,numeroDocumentoInteger,nombre,nacionalidad,direccionFisica,direccionDigital,telefonoLong,codigoPostalInteger,tipoUsuario,login,clave);
            return "redirect:/login_usuario/verificacionLogin/" + idUsuario ;
        } 
    }




}
