package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.PuntosAtencion;

public interface PuntosAtencionRepository extends JpaRepository<PuntosAtencion, Integer> {

    @Query(value = "SELECT 1 FROM DUAL", nativeQuery = true)
    Integer testConnection();

    @Query(value = "SELECT * FROM PUNTOS_ATENCION", nativeQuery = true)
    List<PuntosAtencion> darPuntosAtencion();

    @Query(value = "SELECT * FROM PUNTOS_ATENCION WHERE idPuntosAtencion = :idPuntosAtencion", nativeQuery = true)
    Optional<PuntosAtencion> buscarPuntosAtencionPorId(@Param("idPuntosAtencion") Integer idPuntosAtencion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PUNTOS_ATENCION (nombre, tipo, locacion) VALUES (:nombre, :tipo, :locacion)", nativeQuery = true)
    void insertarPuntosAtencion(@Param("nombre") String nombre, @Param("tipo") String tipo, @Param("locacion") String locacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PUNTOS_ATENCION SET nombre = :nombre, tipo = :tipo, locacion = :locacion WHERE idPuntosAtencion = :idPuntosAtencion", nativeQuery = true)
    void actualizarPuntosAtencion(@Param("idPuntosAtencion") Integer idPuntosAtencion, @Param("nombre") String nombre, @Param("tipo") String tipo, @Param("locacion") String locacion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PUNTOS_ATENCION WHERE idPuntosAtencion = :idPuntosAtencion", nativeQuery = true)
    void eliminarPuntosAtencion(@Param("idPuntosAtencion") Integer idPuntosAtencion);
}