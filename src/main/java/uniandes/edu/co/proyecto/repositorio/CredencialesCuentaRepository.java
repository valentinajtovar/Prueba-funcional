package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.*;
public interface CredencialesCuentaRepository extends JpaRepository<CredencialesCuenta, Integer>{
    


    @Query(value = "SELECT * FROM CREDENCIALES_CUENTA", nativeQuery = true)
    Collection<CredencialesCuenta> darCredencialesCuenta();

    @Query(value = "SELECT ID_CUENTA FROM CREDENCIALES_CUENTA WHERE ID_USUARIO =:id_usuario" , nativeQuery = true)
    Collection<Integer> buscarCredencialesCuentaPorIdUsuario(@Param("id_usuario") Integer id_usuario);



    @Query(value = "SELECT * FROM CREDENCIALES_CUENTA WHERE ID_CUENTA =:id_cuenta" , nativeQuery = true)
    CredencialesCuenta buscarCredencialesCuentaPorIdCuenta(@Param("id_cuenta") Integer id_cuenta);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CREDENCIALES_CUENTA ( id_cuenta, id_usuario, id_gerente, fecha_creacion) VALUES (:id_cuenta, :id_usuario, :id_gerente, :fecha_creacion)", nativeQuery = true)
    void insertarCredencialesCuenta(@Param("id_usuario") Integer id_usuario, @Param("id_gerente") Integer id_gerente, @Param("id_cuenta") Integer id_cuenta, @Param("fecha_creacion") Date fecha_creacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CREDENCIALES_CUENTA SET ID_USUARIO = :id_usuario, ID_GERENTE = :id_gerente, ID_CUENTA = :id_cuenta WHERE ID_USUARIO = :id_usuario AND ID_GERENTE = :id_gerente AND ID_CUENTA = :id_cuenta", nativeQuery = true)
    void actualizarCredencialesCuenta(@Param("id_usuario") Integer id_usuario,@Param("id_gerente") Integer id_gerente, @Param("id_cuenta") Integer id_cuenta);
 
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CREDENCIALES_CUENTA WHERE ID_USUARIO = :id_usuario AND ID_GERENTE =:id_gerente AND ID_CUENTA =:id_cuenta", nativeQuery = true)
    void eliminarCredencialesCuenta(@Param("id_usuario") Integer id_usuario, @Param("id_gerente") Integer id_gerente, @Param("id_cuenta") Integer id_cuenta);
    

    @Query(value = "SELECT C.id_cuenta FROM CUENTA C\r\n" + //
                " LEFT JOIN CREDENCIALES_CUENTA D ON C.id_cuenta = D.id_cuenta\r\n" + //
                                        " WHERE D.id_gerente=:idGerente", nativeQuery = true)
    Collection<Integer> darCuentasGerente(@Param("idGerente") Integer idGerente);
}
