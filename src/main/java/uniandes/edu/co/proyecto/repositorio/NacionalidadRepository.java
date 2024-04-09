package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Nacionalidad;

public interface NacionalidadRepository extends JpaRepository<Nacionalidad, String> {

    @Query(value = "SELECT * FROM NACIONALIDAD", nativeQuery = true)
    Collection<Nacionalidad> darNacionalidades();

    @Query(value = "SELECT * FROM NACIONALIDAD WHERE nombre = :nombre", nativeQuery = true)
    Optional<Nacionalidad> darNacionalidadPorNombre(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO NACIONALIDAD (nombre) VALUES (:nombre)", nativeQuery = true)
    void insertarNacionalidad(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE NACIONALIDAD SET nombre = :nuevoNombre WHERE nombre = :nombre", nativeQuery = true)
    void actualizarNacionalidad(@Param("nombre") String nombre, @Param("nuevoNombre") String nuevoNombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM NACIONALIDAD WHERE nombre = :nombre", nativeQuery = true)
    void eliminarNacionalidad(@Param("nombre") String nombre);
}
