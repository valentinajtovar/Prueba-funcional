package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Oficina;

public interface OficinaRepository extends JpaRepository<Oficina, Integer> {


    @Query(value = "SELECT * FROM OFICINA", nativeQuery = true)
    Collection<Oficina> darOficinas();

    @Query(value = "SELECT * FROM OFICINA WHERE id_Oficina = :id_Oficina", nativeQuery = true)
    Oficina buscarOficinaPorId(@Param("id_Oficina") Integer idOficina);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OFICINA (NOMBRE, DIRECCION, NUMERO_PUNTOS_DISPONIBLES, GERENTE) VALUES (:nombre, :direccion, :numeroPunto, :gerente)", nativeQuery = true)
    void insertarOficina(@Param("nombre") String nombre, @Param("direccion") String direccion, @Param("numeroPunto") Integer numeroPunto, @Param("gerente") Integer gerente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OFICINA SET NOMBRE = :nombre, DIRECCION = :direccion, NUMERO_PUNTOS_DISPONIBLES =:numeroPunto WHERE id_Oficina = :id_Oficina", nativeQuery = true)
    void actualizarOficina(@Param("id_Oficina") Integer idOficina, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("numeroPunto") Integer numeroPunto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OFICINA WHERE id_Oficina = :id_Oficina", nativeQuery = true)
    void eliminarOficina(@Param("id_Oficina") Integer idOficina);
}