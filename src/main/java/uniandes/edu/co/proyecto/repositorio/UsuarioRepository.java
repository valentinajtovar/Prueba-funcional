package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Query(value = "SELECT * FROM USUARIO", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT TIPO_DOCUMENTO FROM USUARIO", nativeQuery = true)
    Collection<String> darTIPO_DOCUMENTO();

    @Query(value = "SELECT NUMERO_DOCUMENTO FROM USUARIO", nativeQuery = true)
    Collection<Integer> darNUMERO_DOCUMENTO();

    @Query(value = "SELECT NOMBRE FROM USUARIO", nativeQuery = true)
    Collection<String> darNOMBRE();

    @Query(value = "SELECT DIRECCION_FISICA FROM USUARIO", nativeQuery = true)
    Collection<String> darDIRECCION_FISICA();

    @Query(value = "SELECT DIRECCION_DIGITAL FROM USUARIO", nativeQuery = true)
    Collection<String> darDIRECCION_DIGITAL();

    @Query(value = "SELECT TELEFONO FROM USUARIO", nativeQuery = true)
    Collection<Long> darTELEFONO();

    @Query(value = "SELECT CODIGO_POSTAL FROM USUARIO", nativeQuery = true)
    Collection<Integer> darCODIGO_POSTAL();

    @Query(value = "SELECT TIPO_USUARIO FROM USUARIO", nativeQuery = true)
    Collection<String> darTIPO_USUARIO();

    @Query(value = "SELECT LOGIN FROM USUARIO", nativeQuery = true)
    Collection<String> darLogin();

    @Query(value = "SELECT * FROM USUARIO WHERE LOGIN=:login", nativeQuery = true)
    Usuario darUsuarioPorLogin(@Param("login") String login);

    



    @Query(value = "SELECT * FROM USUARIO WHERE ID_USUARIO = :id_usuario", nativeQuery = true)
    Usuario buscarUsuarioId(@Param("id_usuario") Integer id_usuario);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USUARIO (ID_USUARIO,TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO,DATOS_USUARIO) VALUES (:id_usuario,:tipo_documento, :numero_documento, :nombre, :nacionalidad, :direccion_fisica, :direccion_digital, :telefono, :codigo_postal, :tipo_usuario,:datos_usuario)", nativeQuery = true)
    void crearUsuario(@Param("id_usuario") Integer id_usuario,@Param("tipo_documento") String tipo_documento, @Param("numero_documento") Integer numero_documento,@Param("nombre") String nombre,  @Param("nacionalidad") String nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_digital") String direccion_digital, @Param("telefono") Long telefono, @Param("codigo_postal") Integer codigo_postal, @Param("tipo_usuario") String tipo_usuario,@Param("datos_usuario") Integer datos_usuario);

    @Query(value = "SELECT MAX(ID_USUARIO) FROM USUARIO", nativeQuery = true)
    Integer encontrarIdMaximo();

    
    @Modifying
    @Transactional
    @Query(value = "UPDATE USUARIO SET TIPO_DOCUMENTO = :tipo_documento, NUMERO_DOCUMENTO =:numero_documento, NOMBRE =:nombre, NACIONALIDAD =:nacionalidad, DIRECCION_FISICA =:direccion_fisica , DIRECCION_DIGITAL = :direccion_digital, TELEFONO =:telefono, CODIGO_POSTAL =:codigo_postal, TIPO_USUARIO =:tipo_usuario, ID_DATOS_USUARIO =:id_datos_usuario  WHERE id_usuario = :id_usuario", nativeQuery = true)
    void actutalizarUsuario(@Param("id_usuario") String id_usuario, @Param("tipo_documento") String tipo_documento, @Param("numero_documento") Integer numero_documento,@Param("nombre") String nombre,  @Param("nacionalidad") Integer nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_digital") String direccion_digital, @Param("telefono") Integer telefono, @Param("codigo_postal") Integer codigo_postal, @Param("tipo_usuario") String tipo_usuario, @Param("id_datos_usuario") Integer id_datos_usuario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM USUARIO WHERE id_usuario = :id_usuario", nativeQuery = true)
    void eliminarUsuario(@Param("id_usuario") String id_usuario);
     
}