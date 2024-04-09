package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoCuenta;

public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, String> {

    @Query(value = "SELECT * FROM TIPO_CUENTA", nativeQuery = true)
    Collection<TipoCuenta> darTiposCuenta();

    @Query(value = "SELECT * FROM TIPO_CUENTA WHERE tipoCuenta = :tipoCuenta", nativeQuery = true)
    Optional<TipoCuenta> buscarTipoCuentaPorNombre(@Param("tipoCuenta") String tipoCuenta);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TIPO_CUENTA (tipoCuenta) VALUES (:tipoCuenta)", nativeQuery = true)
    void insertarTipoCuenta(@Param("tipoCuenta") String tipoCuenta);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TIPO_CUENTA SET tipoCuenta = :tipoCuenta WHERE tipoCuenta = :tipoCuenta", nativeQuery = true)
    void actualizarTipoCuenta(@Param("tipoCuenta") String tipoCuenta);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM TIPO_CUENTA WHERE tipoCuenta = :tipoCuenta", nativeQuery = true)
    void eliminarTipoCuenta(@Param("tipoCuenta") String tipoCuenta);
}