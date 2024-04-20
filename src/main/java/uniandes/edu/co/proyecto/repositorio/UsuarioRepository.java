package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Query(value = "SELECT * FROM USUARIO", nativeQuery = true)
    Collection<Usuario> darUsuarios();


    @Query(value = "SELECT * FROM USUARIO WHERE id_usuario = :id_usuario", nativeQuery = true)
    void buscarUsuarioPorId(@Param("id_usuario") String id_usuario);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USUARIO (id_usuario, tipo_documento, numero_documento, nombre, nacionalidad, direccion_fisica, direccion_digital, telefono, codigo_postal, tipo_usuario) VALUES (:id_usuario, :tipo_documento, :numero_documento, :nombre, :nacionalidad, :direccion_fisica, :direccion_digital, :telefono, :codigo_postal, :tipo_usuario)", nativeQuery = true)
    void insertarUsuario(@Param("id_usuario") String id_usuario, @Param("tipo_documento") String tipo_documento, @Param("numero_documento") Integer numero_documento,@Param("nombre") String nombre,  @Param("nacionalidad") Integer nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_digital") String direccion_digital, @Param("telefono") Integer telefono, @Param("codigo_postal") Integer codigo_postal, @Param("tipo_usuario") String tipo_usuario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USUARIO SET tipo_documento = :tipo_documento, numero_documento =:numero_documento, nombre =:nombre, nacionalidad =:nacionalidad, direccion_fisica =:direccion_fisica , direccion_digital = :direccion_digital, telefono =:telefono, codigo_postal =:codigo_postal, tipo_usuario =:tipo_usuario WHERE id_usuario = :id_usuario", nativeQuery = true)
    void actutalizarUsuario(@Param("id_usuario") String id_usuario, @Param("tipo_documento") String tipo_documento, @Param("numero_documento") Integer numero_documento,@Param("nombre") String nombre,  @Param("nacionalidad") Integer nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_digital") String direccion_digital, @Param("telefono") Integer telefono, @Param("codigo_postal") Integer codigo_postal, @Param("tipo_usuario") String tipo_usuario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM USUARIO WHERE id_usuario = :id_usuario", nativeQuery = true)
    void eliminarUsuario(@Param("id_usuario") String id_usuario);
    
    
}