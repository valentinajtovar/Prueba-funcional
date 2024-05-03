package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoPrestamo;

public interface TipoPrestamoRepository extends JpaRepository<TipoPrestamo, String> {

    @Query(value = "SELECT * FROM TIPO_PRESTAMO", nativeQuery = true)
    Collection<TipoPrestamo> darTiposPrestamo();

    @Query(value = "SELECT TIPO_PRESTAMO FROM TIPO_PRESTAMO", nativeQuery = true)
    Collection<String> darTiposPrestamoNombre();

    @Query(value = "SELECT * FROM TIPO_PRESTAMO WHERE tipoPrestamo = :tipoPrestamo", nativeQuery = true)
    Optional<TipoPrestamo> buscarTipoPrestamoPorNombre(@Param("tipoPrestamo") String tipoPrestamo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TIPO_PRESTAMO (tipoPrestamo) VALUES (:tipoPrestamo)", nativeQuery = true)
    void insertarTipoPrestamo(@Param("tipoPrestamo") String tipoPrestamo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TIPO_PRESTAMO SET tipoPrestamo = :tipoPrestamo WHERE tipoPrestamo = :tipoPrestamo", nativeQuery = true)
    void actualizarTipoPrestamo(@Param("tipoPrestamo") String tipoPrestamo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM TIPO_PRESTAMO WHERE tipoPrestamo = :tipoPrestamo", nativeQuery = true)
    void eliminarTipoPrestamo(@Param("tipoPrestamo") String tipoPrestamo);
}
