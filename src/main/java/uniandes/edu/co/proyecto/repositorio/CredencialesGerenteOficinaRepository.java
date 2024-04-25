package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.*;

public interface CredencialesGerenteOficinaRepository extends JpaRepository<CredencialesGerenteOficina, String>{
    @Query(value = "SELECT * FROM CREDENCIALES_GERENTE_OFICINA", nativeQuery = true)
    Collection<CredencialesGerenteOficina> darCredencialesGerenteOficina();

    @Query(value = "SELECT * FROM CREDENCIALES_GERENTE_OFICINA WHERE ID_GERENTE =:id_gerente" , nativeQuery = true)
    CredencialesPrestamo buscarCredencialesGerenteOficinaPorIdGerente(@Param("id_gerente") Integer id_gerente);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CREDENCIALES_GERENTE_OFICINA (id_gerente, id_oficina) VALUES (:id_gerente, :id_oficina)", nativeQuery = true)
    void insertarCredencialesGerenteOficina( @Param("id_gerente") Integer id_gerente, @Param("id_oficina") Integer id_oficina);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CREDENCIALES_GERENTE_OFICINA SET ID_GERENTE = :id_gerente, ID_OFICINA = :id_oficina WHERE ID_GERENTE = :id_gerente AND ID_OFICINA = :id_oficina", nativeQuery = true)
    void actualizarCredencialesGerenteOficina(@Param("id_gerente") Integer id_gerente, @Param("id_oficina") Integer id_oficina);
 
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CREDENCIALES_GERENTE_OFICINA WHERE ID_USUARIO = :id_usuario AND ID_GERENTE =:id_gerente AND ID_OFICINA =:id_oficina", nativeQuery = true)
    void eliminarCredencialesGerenteOficina( @Param("id_gerente") Integer id_gerente, @Param("id_oficina") Integer id_oficina);

}
