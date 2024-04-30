package uniandes.edu.co.proyecto.controller;
import java.util.Collection;
import java.util.Optional;

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


import uniandes.edu.co.proyecto.modelo.Usuario;


import uniandes.edu.co.proyecto.repositorio.TipoDocumentoRepository;
import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired 
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    
    
    @GetMapping("/usuario")
    public String usuarios(Model model ) { //aqui van las consultas extra
        model.addAttribute("usuario", usuarioRepository.darUsuarios());
        return "usuario";
    }

    @GetMapping("/usuario/new")
    public String formularioNuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("tipoDocumento", tipoDocumentoRepository.darTipoDocumentos());
        model.addAttribute("tipoUsuario", tipoUsuarioRepository.darTipoUsuarios());
        return "usuarioNuevo";
    }

    @Transactional
    @PostMapping("/usuario/new/save")
    public String guardarUsuario( @ModelAttribute Usuario usuario ) {
                usuarioRepository.crearUsuario( usuario.getTipoDocumento().getTipoDocumento(), usuario.getNumeroDocumento(), usuario.getNombre(), usuario.getNacionalidad(),usuario.getDireccionFisica(),usuario.getDireccionDigital(),usuario.getTelefono(),usuario.getCodigoPostal(),usuario.getTipoUsuario().getTipoUsuario());

                return "redirect:/usuario";} 
    
                @GetMapping("/usuario/gerente")
                public String formularioNuevoUsuarioGerente(Model model) {
                    model.addAttribute("usuario", new Usuario());
                    model.addAttribute("tipoDocumento", tipoDocumentoRepository.darTipoDocumentos());
                    model.addAttribute("tipoUsuario", tipoUsuarioRepository.darTipoUsuarioGerente("CLIENTE NATURAL", "CLIENTE JURIDICO"));
                    return "usuarioNuevo";
                }


    @PostMapping("/usuario/gerente/save")
    public String guardarUsuarioPorGerente( @ModelAttribute Usuario usuario ) {
        usuarioRepository.crearUsuario( usuario.getTipoDocumento().getTipoDocumento(), usuario.getNumeroDocumento(), usuario.getNombre(), usuario.getNacionalidad(),usuario.getDireccionFisica(),usuario.getDireccionDigital(),usuario.getTelefono(),usuario.getCodigoPostal(),usuario.getTipoUsuario().getTipoUsuario());

        return "redirect:/usuario";} 

        @GetMapping("/usuario/admi")
        public String formularioNuevoUsuarioAdmi(Model model) {
            model.addAttribute("usuario", new Usuario());
            model.addAttribute("tipoDocumento", tipoDocumentoRepository.darTipoDocumentos());
            model.addAttribute("tipoUsuario", tipoUsuarioRepository.darTipoUsuarioAdmi("CAJERO", "GERENTE DE OFICINA", "GERENTE GENERAL"));
            return "usuarioNuevo";
        }


@PostMapping("/usuario/admi/save")
public String guardarUsuarioPoraAdmi( @ModelAttribute Usuario usuario ) {
usuarioRepository.crearUsuario( usuario.getTipoDocumento().getTipoDocumento(), usuario.getNumeroDocumento(), usuario.getNombre(), usuario.getNacionalidad(),usuario.getDireccionFisica(),usuario.getDireccionDigital(),usuario.getTelefono(),usuario.getCodigoPostal(),usuario.getTipoUsuario().getTipoUsuario());

return "redirect:/usuario";} 

@GetMapping("/usuario/{idUsuario}/edit")
public String usuarioEditar(@PathVariable("idUsuario") Integer idUsuario, Model model) {
    Usuario usuario = usuarioRepository.buscarUsuarioPorId(idUsuario);
    if (usuario != null) {
        model.addAttribute("usuario", usuario);
        model.addAttribute("tipoDocumento", tipoDocumentoRepository.darTipoDocumentos());
        model.addAttribute("tipoUsuario", tipoUsuarioRepository.darTipoUsuarios());
        return "usuarioEditar";
    } else {
        return "redirect:/usuario";
    }
}

@PostMapping("/usuario/{idUsuario}/edit/save")
public String usuarioEditarGuardar(@PathVariable("idUsuario") Integer idUsuario, @ModelAttribute Usuario usuario) {
    usuarioRepository.actutalizarUsuario(idUsuario, usuario.getTipoDocumento().getTipoDocumento(),usuario.getNumeroDocumento(),usuario.getNombre(),
    usuario.getNacionalidad(),usuario.getDireccionFisica(),usuario.getDireccionDigital(),usuario.getTelefono(),usuario.getCodigoPostal(),
    usuario.getTipoUsuario().getTipoUsuario());
    return "redirect:/usuario";
}

@GetMapping("/usuario/{idUsuario}/delete")
public String usuarioBorrar(@PathVariable("idUsuario") Integer id_usuario) {
    usuarioRepository.eliminarUsuario(id_usuario);
    return "redirect:/usuario";
}


}
