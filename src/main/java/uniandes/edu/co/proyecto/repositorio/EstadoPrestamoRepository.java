package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.EstadoPrestamo;

public interface EstadoPrestamoRepository extends JpaRepository<EstadoPrestamo, String> {
    
    @Query(value = "SELECT * FROM ESTADO_PRESTAMO", nativeQuery = true)
    Collection<EstadoPrestamo> darEstadosPrestamo();

    @Query(value = "SELECT * FROM ESTADO_PRESTAMO WHERE estadoPrestamo = :estadoPrestamo", nativeQuery = true)
    Optional<EstadoPrestamo> darEstadoPrestamo(@Param("estadoPrestamo") String estadoPrestamo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ESTADO_PRESTAMO (estadoPrestamo) VALUES (:estadoPrestamo)", nativeQuery = true)
    void insertarEstadoPrestamo(@Param("estadoPrestamo") String estadoPrestamo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ESTADO_PRESTAMO SET estadoPrestamo = :estadoPrestamo WHERE estadoPrestamo = :estadoPrestamo", nativeQuery = true)
    void actualizarEstadoPrestamo(@Param("estadoPrestamo") String estadoPrestamo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ESTADO_PRESTAMO WHERE estadoPrestamo = :estadoPrestamo", nativeQuery = true)
    void eliminarEstadoPrestamo(@Param("estadoPrestamo") String estadoPrestamo);
}