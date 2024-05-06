package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

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

    

    @Query(value = "SELECT * FROM USUARIO WHERE TIPO_USUARIO=:tipo_usuario", nativeQuery = true)
    Collection<Usuario> darListaTipoUsuario(@Param("tipo_usuario") String tipo_usuario);

    @Query(value = "SELECT * FROM USUARIO WHERE TIPO_USUARIO=:tipo_usuario OR TIPO_USUARIO=:tipo_usuario1", nativeQuery = true)
    Collection<Usuario> darListaUsuarios(@Param("tipo_usuario") String tipo_usuario, @Param("tipo_usuario1") String tipo_usuario1);

    @Query(value = "SELECT * FROM USUARIO WHERE ID_USUARIO = :id_usuario", nativeQuery = true)
    Usuario buscarUsuarioId(@Param("id_usuario") Integer id_usuario);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USUARIO (TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO,LOGIN,CLAVE) VALUES (:tipo_documento, :numero_documento,:nombre , :nacionalidad, :direccion_fisica, :direccion_digital, :telefono, :codigo_postal, :tipo_usuario,:login,:clave)", nativeQuery = true)
    void crearUsuario(@Param("tipo_documento") String tipo_documento, @Param("numero_documento") Integer numero_documento,@Param("nombre") String nombre,  @Param("nacionalidad") String nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_digital") String direccion_digital, @Param("telefono") Long telefono, @Param("codigo_postal") Integer codigo_postal, @Param("tipo_usuario") String tipo_usuario,@Param("login") String login,@Param("clave") String clave);

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

    @Query(value ="SELECT * USUARIO LEFT JOIN  ", nativeQuery = true)
    Collection<Cuenta> usuariosInfoCompleto();

    @Query(value="SELECT CUENTA.ID_CUENTA, CUENTA.SALDO, OFICINA.NOMBRE " +
    "FROM USUARIO LEFT JOIN CREDENCIALES_CUENTA ON USUARIO.ID_USUARIO = CREDENCIALES_CUENTA.ID_USUARIO "+
    "LEFT JOIN CUENTA ON CREDENCIALES_CUENTA.ID_CUENTA = CUENTA.ID_CUENTA "+
    "LEFT JOIN OFICINA ON CREDENCIALES_CUENTA.ID_GERENTE = OFICINA.GERENTE WHERE USUARIO.ID_USUARIO=:id_usuario", nativeQuery= true)
    Collection<String> darCuentasUsuario(@Param("id_usuario") Integer id_usuario);

    @Query(value="SELECT PRESTAMO.ID_PRESTAMO, PRESTAMO.MONTO, OFICINA.GERENTE " + 
                "FROM USUARIO " + 
                "LEFT JOIN CREDENCIALES_PRESTAMO ON USUARIO.ID_USUARIO = CREDENCIALES_PRESTAMO.ID_CLIENTE " + 
                "LEFT JOIN PRESTAMO ON CREDENCIALES_PRESTAMO.ID_PRESTAMO = PRESTAMO.ID_PRESTAMO " + 
                "LEFT JOIN OFICINA ON CREDENCIALES_PRESTAMO.ID_GERENTE = OFICINA.GERENTE WHERE USUARIO.ID_USUARIO=:id_usuario", nativeQuery = true)
    Collection<String> darPrestamosUsuario(@Param("id_usuario") Integer id_usuario);
     
    @Query(value="SELECT CUENTA.ID_CUENTA, CUENTA.SALDO, OFICINA.NOMBRE " +
    "FROM USUARIO LEFT JOIN CREDENCIALES_CUENTA ON USUARIO.ID_USUARIO = CREDENCIALES_CUENTA.ID_USUARIO "+
    "LEFT JOIN CUENTA ON CREDENCIALES_CUENTA.ID_CUENTA = CUENTA.ID_CUENTA "+
    "LEFT JOIN OFICINA ON CREDENCIALES_CUENTA.ID_GERENTE = OFICINA.GERENTE WHERE USUARIO.ID_USUARIO=:id_usuario AND OFICINA.GERENTE=:id_gerente", nativeQuery= true)
    Collection<String> darCuentasUsuarioOficina(@Param("id_usuario") Integer id_usuario, @Param("id_gerente") Integer id_gerente);

    @Query(value="SELECT PRESTAMO.ID_PRESTAMO, PRESTAMO.MONTO, OFICINA.GERENTE " + 
                "FROM USUARIO " + 
                "LEFT JOIN CREDENCIALES_PRESTAMO ON USUARIO.ID_USUARIO = CREDENCIALES_PRESTAMO.ID_CLIENTE " + 
                "LEFT JOIN PRESTAMO ON CREDENCIALES_PRESTAMO.ID_PRESTAMO = PRESTAMO.ID_PRESTAMO " + 
                "LEFT JOIN OFICINA ON CREDENCIALES_PRESTAMO.ID_GERENTE = OFICINA.GERENTE WHERE USUARIO.ID_USUARIO=:id_usuario AND OFICINA.GERENTE=:id_gerente", nativeQuery = true)
    Collection<String> darPrestamosUsuarioOficina(@Param("id_usuario") Integer id_usuario, @Param("id_gerente") Integer id_gerente);
}