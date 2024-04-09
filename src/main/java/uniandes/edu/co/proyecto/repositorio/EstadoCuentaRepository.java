package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.EstadoCuenta;

public interface EstadoCuentaRepository extends JpaRepository<EstadoCuenta, String> {

    // Consulta para obtener todos los estados de cuenta
    @Query(value = "SELECT * FROM ESTADO_CUENTA", nativeQuery = true)
    Collection<EstadoCuenta> darEstadosCuenta();

    // Consulta para obtener un estado de cuenta por su ID
    @Query(value = "SELECT * FROM ESTADO_CUENTA WHERE ESTADO_CUENTA = :estadoCuenta", nativeQuery = true)
    Optional<EstadoCuenta> darEstadoCuenta(@Param("estadoCuenta") String estadoCuenta);

    // Método para insertar un nuevo estado de cuenta
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ESTADO_CUENTA (estadoCuenta) VALUES (:estadoCuenta)", nativeQuery = true)
    void insertarEstadoCuenta(@Param("estadoCuenta") String estadoCuenta);

    // Método para actualizar un estado de cuenta existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE ESTADO_CUENTA SET estadoCuenta = :estadoCuenta WHERE estadoCuenta = :id", nativeQuery = true)
    void actualizarEstadoCuenta(@Param("id") String id, @Param("estadoCuenta") String estadoCuenta);

    // Método para eliminar un estado de cuenta por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ESTADO_CUENTA WHERE estadoCuenta = :estadoCuenta", nativeQuery = true)
    void eliminarEstadoCuenta(@Param("estadoCuenta") String estadoCuenta);
}