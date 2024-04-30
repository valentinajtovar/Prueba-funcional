package uniandes.edu.co.proyecto.controller;
import java.time.LocalDate;
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

import uniandes.edu.co.proyecto.modelo.DatosUsuario;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.DatosUsuarioRepository;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DatosUsuarioRepository datosUsuarioRepository;
    
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
                System.out.println("------------------------");
                System.out.println("clave correcta");
                System.out.println("------------------------");
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
        
        return "redirect:/login_usuario";
}

    
    @Transactional
    @PostMapping("/usuario/new/save")
    public String guardarUsuario( @ModelAttribute("tipo_Documento") String tipo_Documento,@ModelAttribute("numero_documento") String numero_documento,@ModelAttribute("nombre") String nombre,@ModelAttribute("nacionalidad") String nacionalidad,@ModelAttribute("direccion_fisica") String direccion_fisica,@ModelAttribute("direccion_digital") String direccion_digital,@ModelAttribute("telefono") String telefono,@ModelAttribute("codigo_postal") String codigo_postal,@ModelAttribute("tipo_usuario") String tipo_usuario,@ModelAttribute("datos_usuario") String datos_usuario,@ModelAttribute("login") String login,@ModelAttribute("clave") String clave) {
                
                Integer id = usuarioRepository.encontrarIdMaximo()+1;
                
                int numeroDocumento = Integer.parseInt(numero_documento);
                
                int codigoPostal = Integer.parseInt(codigo_postal);
                
                long telefonoLong = Long.parseLong(telefono);

                
                Collection<String> datosUsuarios = datosUsuarioRepository.darLogin();/*esta linea es para poder verificar si existe el nombre escogido, te trae la lista */
                datosUsuarioRepository.insertarDatosUsuario(login, clave);
                Collection<DatosUsuario> listaDatos = datosUsuarioRepository.darDatosUsuarios();
                
                /*for(DatosUsuario dato: listaDatos){
                    if(dato.getLogin().equals(login)){
                        datoUsuario= dato;
                    }
                }*/
                
                /*usuarioRepository.crearUsuario(id,tipo_Documento,numeroDocumento,nombre,nacionalidad,direccion_fisica,direccion_digital,telefonoLong,codigoPostal,tipo_usuario,idDatosUsuario);
                 */
                return "redirect:/usuario";} 


}
