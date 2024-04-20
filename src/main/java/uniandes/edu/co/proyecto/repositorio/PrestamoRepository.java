package uniandes.edu.co.proyecto.repositorio;

import java.util.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.*;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    @Query(value = "SELECT * FROM PRESTAMO", nativeQuery = true)
    Collection<Prestamo> darPrestamos();


    @Query(value = "SELECT * FROM PRESTAMO WHERE id_prestamo = :id_prestamo", nativeQuery = true)
    void buscarPrestamoPorId(@Param("id_prestamo") Integer id_prestamo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PRESTAMO ( fecha, pagado, valor, estado, tipo_prestamo) VALUES ( :fecha, :pagado, :valor, :estado, :tipo_prestamo)", nativeQuery = true)
    void insertarPrestamo(@Param("fecha") Date fecha, @Param("pagado") Integer pagado,@Param("valor") double valor,  @Param("estado") String estado, @Param("tipo_prestamo") String tipo_prestamo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRESTAMO SET fecha =:fecha, pagado =:pagado, valor =:valor, estado =:estado, tipo_prestamo =:tipo_prestamo  WHERE id_prestamo =:id_prestamo", nativeQuery = true)
    void actutalizarPrestamo(@Param("id_prestamo") Integer id_prestamo, @Param("fecha") Date fecha, @Param("pagado") Integer pagado,@Param("valor") double valor,  @Param("estado") String estado, @Param("tipo_prestamo") String tipo_prestamo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PRESTAMO WHERE id_prestamo = :id_prestamo", nativeQuery = true)
    void eliminarPrestamo(@Param("id_prestamo") Integer id_prestamo);
    
    
}