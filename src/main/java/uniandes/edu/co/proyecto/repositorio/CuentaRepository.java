package uniandes.edu.co.proyecto.repositorio;


import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.*;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {


    @Query(value = "SELECT * FROM CUENTA", nativeQuery = true)
    Collection<Cuenta> darCuentas();

    @Query(value = "SELECT * FROM CUENTA WHERE id_cuenta =:id_cuenta", nativeQuery = true)
    Cuenta buscarCuentaPorId(@Param("id_cuenta") Integer id_cuenta);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CUENTA (TIPO_CUENTA, ESTADO_CUENTA, SALDO, FECHA_ULTIMA_TRANSACCION) VALUES (:tipo_cuenta, :estado_cuenta, :saldo,:fecha)", nativeQuery = true)
    void insertarCuenta(@Param("tipo_cuenta") String tipo_cuenta, @Param("estado_cuenta") String estado_cuenta, @Param("saldo") double saldo,@Param("fecha") Date fecha);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CUENTA SET id_usuario =:id_usuario, tipo_cuenta = :tipo_cuenta, estado_cuenta =:estado_cuenta, valor =:valor WHERE id_cuenta = :id_cuenta", nativeQuery = true)
    void actualizarDatosUsuario(@Param("id_cuenta") Integer id_cuenta, @Param("id_usuario") String id_usuario,@Param("tipo_cuenta") String tipo_cuenta, @Param("estado_cuenta") String estado_cuenta, @Param("valor") double valor);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CUENTA WHERE id_cuenta = :id_cuenta", nativeQuery = true)
    void eliminarCuenta(@Param("id_cuenta") Integer id_cuenta);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CUENTA SET  ESTADO_CUENTA ='CERRADA' WHERE id_cuenta = :id_cuenta", nativeQuery = true)
    void cambiarEstadoCerrada(@Param("id_cuenta") Integer id_cuenta);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CUENTA SET  ESTADO_CUENTA ='DESACTIVADA' WHERE id_cuenta = :id_cuenta", nativeQuery = true)
    void cambiarEstadoDesactivada(@Param("id_cuenta") Integer id_cuenta);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CUENTA SET  SALDO =:saldo WHERE id_cuenta = :id_cuenta", nativeQuery = true)
    void cambiarSaldo(@Param("id_cuenta") Integer id_cuenta,@Param("saldo") Double saldo);

    
}