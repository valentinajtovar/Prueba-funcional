package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Nacionalidad;

public interface NacionalidadRepository extends JpaRepository<Nacionalidad, Integer> {

    @Query(value = "SELECT * FROM NACIONALIDAD", nativeQuery = true)
    Collection<Nacionalidad> darNacionalidades();

    @Query(value = "SELECT * FROM NACIONALIDAD WHERE id_nacionalidad = :id_nacionalidad", nativeQuery = true)
    Nacionalidad darNacionalidadPorId(@Param("id_nacionalidad") Integer id_nacionalidad);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO NACIONALIDAD (nombre) VALUES (:nombre)", nativeQuery = true)
    void insertarNacionalidad(@Param("nombre") String nombre);


    @Modifying
    @Transactional
    @Query(value = "UPDATE NACIONALIDAD SET nombre = :nombre WHERE id_nacionalidad = :id_nacionalidad", nativeQuery = true)
    void actualizarNacionalidad(@Param("id_nacionalidad") Integer id_nacionalidad, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM NACIONALIDAD WHERE id_nacionalidad = :id_nacionalidad", nativeQuery = true)
    void eliminarNacionalidad(@Param("id_nacionalidad") Integer id_nacionalidad);
}
