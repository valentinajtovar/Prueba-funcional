package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.DatosUsuario;

public interface DatosUsuarioRepository extends JpaRepository<DatosUsuario, Integer> {


    @Query(value = "SELECT * FROM DATOS_USUARIO", nativeQuery = true)
    Collection<DatosUsuario> darDatosUsuarios();

    @Query(value = "SELECT * FROM DATOS_USUARIO WHERE login = :login", nativeQuery = true)
    DatosUsuario buscarUsuarioPorLogin(@Param("login") String login);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO DATOS_USUARIO (login, clave) VALUES (:login, :clave)", nativeQuery = true)
    void insertarDatosUsuario(@Param("login") String login, @Param("clave") String clave);

    @Modifying
    @Transactional
    @Query(value = "UPDATE DATOS_USUARIO SET clave = :clave, id_datos_usuario = :id_datos_usuario WHERE login = :login", nativeQuery = true)
    void actualizarDatosUsuario(@Param("id_datos_usuario") Integer id_datos_usuario,@Param("login") String login, @Param("clave") String clave);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM DATOS_USUARIO WHERE login = :login", nativeQuery = true)
    void eliminarDatosUsuario(@Param("login") String login);
}