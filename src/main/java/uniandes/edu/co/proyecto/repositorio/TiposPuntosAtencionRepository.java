package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TiposPuntosAtencion;


public interface TiposPuntosAtencionRepository extends JpaRepository<TiposPuntosAtencion, Integer> {


    @Query(value = "SELECT * FROM TIPOS_PUNTOS_ATENCION", nativeQuery = true)
    Collection<TiposPuntosAtencion> darTiposPuntosAtencion();

    @Query(value = "SELECT * FROM TIPOS_PUNTOS_ATENCION WHERE id_Tipos_Puntos_Atencion = (:id_Tipos_Puntos_Atencion)", nativeQuery = true)
    Optional<TiposPuntosAtencion> darTipoPuntosAtencion(@Param("id_Tipos_Puntos_Atencion") Integer id_Tipos_Puntos_Atencion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TIPOS_PUNTOS_ATENCION (nombre) VALUES (:nombre)", nativeQuery = true)
    void insertarTiposPuntosAtencion(@Param("nombre") String nombre);    

    @Modifying
    @Transactional
    @Query(value = "UPDATE TIPOS_PUNTOS_ATENCION SET nombre = :nombre WHERE id_Tipos_Puntos_Atencion = :id_Tipos_Puntos_Atencion", nativeQuery = true)
    void actualizarTiposPuntosAtencion(@Param("id_Tipos_Puntos_Atencion") Integer idTiposPuntosAtencion,  @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM TIPOS_PUNTOS_ATENCION WHERE id_Tipos_Puntos_Atencion = :id_Tipos_Puntos_Atencion", nativeQuery = true)
    void eliminarTiposPuntosAtencion(@Param("id_Tipos_Puntos_Atencion") Integer idTiposPuntosAtencion);

}