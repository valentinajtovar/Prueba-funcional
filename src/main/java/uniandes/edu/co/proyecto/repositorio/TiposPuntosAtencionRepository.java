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


public interface TiposPuntosAtencionRepository extends JpaRepository<TiposPuntosAtencion, String> {


    @Query(value = "SELECT * FROM TIPO_PUNTO_ATENCION", nativeQuery = true)
    Collection<TiposPuntosAtencion> darTiposPuntosAtencion();

    @Query(value = "SELECT * FROM TIPO_PUNTO_ATENCION WHERE TIPO_PUNTO_ATENCION = (:TIPO_PUNTO_ATENCION)", nativeQuery = true)
    Optional<TiposPuntosAtencion> darTipoPuntosAtencion(@Param("TIPO_PUNTO_ATENCION") Integer TIPO_PUNTO_ATENCION);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TIPO_PUNTO_ATENCION (TIPO_PUNTO_ATENCION) VALUES (:TIPO_PUNTO_ATENCION)", nativeQuery = true)
    void insertarTiposPuntosAtencion(@Param("TIPO_PUNTO_ATENCION") String TIPO_PUNTO_ATENCION);    


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM TIPO_PUNTO_ATENCION WHERE TIPO_PUNTO_ATENCION =:TIPO_PUNTO_ATENCION", nativeQuery = true)
    void eliminarTiposPuntosAtencion(@Param("TIPO_PUNTO_ATENCION") String TIPO_PUNTO_ATENCION);

}