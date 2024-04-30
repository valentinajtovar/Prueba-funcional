package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoDocumento;
import uniandes.edu.co.proyecto.modelo.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, String> {
        @Query(value = "SELECT * FROM TIPO_USUARIO", nativeQuery = true)
        Collection<TipoUsuario> darTipoUsuarios();

        @Query(value = "SELECT * FROM TIPO_USUARIO WHERE TIPO_USUARIO = :tipoUsuario", nativeQuery = true)
        TipoUsuario darTipoUsuario(@Param("tipoUsuario") String tipoUsuario);

        @Query(value = "SELECT * FROM TIPO_USUARIO WHERE TIPO_USUARIO=:tipoDocumento OR TIPO_USUARIO=:tipoDocumento1", nativeQuery = true)
        Collection<TipoUsuario>  darTipoUsuarioGerente(@Param("tipoDocumento") String tipoDocumento, @Param("tipoDocumento1") String tipoDocumento1);

        @Query(value = "SELECT * FROM TIPO_USUARIO WHERE TIPO_USUARIO=:tipoDocumento OR TIPO_USUARIO=:tipoDocumento1 or TIPO_USUARIO=:tipoDocumento2 ", nativeQuery = true)
        Collection<TipoUsuario>  darTipoUsuarioAdmi(@Param("tipoDocumento") String tipoDocumento, @Param("tipoDocumento1") String tipoDocumento1, @Param("tipoDocumento2") String tipoDocumento2);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO TIPO_USUARIO (tipoUsuario) VALUES (:tipoUsuario)", nativeQuery = true)
        void insertarTipoUsuario(@Param("tipoUsuario") String tipoUsuario);

        @Modifying
        @Transactional
        @Query(value = "UPDATE TIPO_USUARIO SET TIPO_USUARIO = :tipoUsuario WHERE TIPO_USUARIO = :tipoUsuario", nativeQuery = true)
        void actualizarTipoUsuario(@Param("tipoUsuario") String tipoUsuario);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM TIPO_USUARIO WHERE TIPO_USUARIO = :tipoUsuario", nativeQuery = true)
        void eliminarTipoUsuario(@Param("tipoUsuario") String tipoUsuario);
}