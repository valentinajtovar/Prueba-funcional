package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoDocumento;
import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM USUARIO", nativeQuery = true)
    Collection<Usuario> darUsuarios();


    @Query(value = "SELECT * FROM USUARIO WHERE id_usuario=:id_usuario", nativeQuery = true)
    Usuario buscarUsuarioPorId(@Param("id_usuario") Integer id_usuario);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USUARIO (ID_USUARIO,TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO) VALUES (usuario_seq.NEXTVAL,:tipo_documento, :numero_documento, :nombre, :nacionalidad, :direccion_fisica, :direccion_digital, :telefono, :codigo_postal, :tipo_usuario)", nativeQuery = true)
    void crearUsuario(@Param("tipo_documento") String tipo_documento, @Param("numero_documento") Integer numero_documento,@Param("nombre") String nombre,  @Param("nacionalidad") String nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_digital") String direccion_digital, @Param("telefono") Long telefono, @Param("codigo_postal") Integer codigo_postal, @Param("tipo_usuario") String tipo_usuario);

    
    @Modifying
    @Transactional
    @Query(value = "UPDATE USUARIO SET tipo_documento=:tipo_documento, numero_documento =:numero_documento, NOMBRE =:nombre, NACIONALIDAD =:nacionalidad, DIRECCION_FISICA =:direccion_fisica , DIRECCION_DIGITAL = :direccion_digital, TELEFONO =:telefono, CODIGO_POSTAL =:codigo_postal, TIPO_USUARIO =:tipo_usuario  WHERE id_usuario=:id_usuario", nativeQuery = true)
    void actutalizarUsuario(@Param("id_usuario") Integer id_usuario,  @Param("tipo_documento") String tipo_documento, @Param("numero_documento") Integer numero_documento,@Param("nombre") String nombre,  @Param("nacionalidad") String nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_digital") String direccion_digital, @Param("telefono") Long telefono, @Param("codigo_postal") Integer codigo_postal, @Param("tipo_usuario") String tipo_usuario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM USUARIO WHERE id_usuario=:id_usuario", nativeQuery = true)
    void eliminarUsuario(@Param("id_usuario") Integer id_usuario);


  


}