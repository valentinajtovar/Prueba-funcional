/*package uniandes.edu.co.proyecto.repositorio;

 
import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoOperacion;

public interface TipoOperacionRepository extends JpaRepository<TipoOperacion, String> {

    @Query(value = "SELECT * FROM TIPO_OPERACION", nativeQuery = true)
    Collection<TipoOperacion> darTiposOperacion();

    @Query(value = "SELECT * FROM TIPO_OPERACION WHERE tipoOperacion = :tipoOperacion", nativeQuery = true)
    Optional<TipoOperacion> buscarTipoOperacionPorNombre(@Param("tipoOperacion") String tipoOperacion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TIPO_OPERACION (tipoOperacion) VALUES (:tipoOperacion)", nativeQuery = true)
    void insertarTipoOperacion(@Param("tipoOperacion") String tipoOperacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TIPO_OPERACION SET tipoOperacion = :tipoOperacion WHERE tipoOperacion = :tipoOperacion", nativeQuery = true)
    void actualizarTipoOperacion(@Param("tipoOperacion") String tipoOperacion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM TIPO_OPERACION WHERE tipoOperacion = :tipoOperacion", nativeQuery = true)
    void eliminarTipoOperacion(@Param("tipoOperacion") String tipoOperacion);
}*/