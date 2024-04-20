package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.*;

//TODO FUNCIONA, NO SE PORQUE MARCAERROR
public interface CredencialesPrestamoRepository extends JpaRepository<CredencialesPrestamo, String > {


    @Query(value = "SELECT * FROM CREDENCIALES_PRESTAMO", nativeQuery = true)
    Collection<CredencialesPrestamo> darCredencialesPrestamo();

    @Query(value = "SELECT * FROM CREDENCIALES_PRESTAMO WHERE id_prestamo =:id_prestamo" , nativeQuery = true)
    CredencialesPrestamo buscarCredencialesPrestamoPorId(@Param("id_prestamo") Integer id_prestamo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CREDENCIALES_PRESTAMO (id_cliente, id_gerente, id_prestamo) VALUES (:id_cliente, :id_gerente, :id_prestamo)", nativeQuery = true)
    void insertarCredencialesPrestamo(@Param("id_cliente") String id_cliente, @Param("id_gerente") String id_gerente, @Param("id_prestamo") Integer id_prestamo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CREDENCIALES_PRESTAMO SET id_cliente = :id_cliente_actualizado, id_gerente = :id_gerente_actualizado, id_prestamo = :id_prestamo_actualizado WHERE id_cliente = :id_cliente AND id_gerente = :id_gerente AND id_prestamo = :id_prestamo", nativeQuery = true)
    void actualizarCredencialesPrestamo(@Param("id_cliente") String id_cliente,@Param("id_gerente") String id_gerente, @Param("id_prestamo") Integer id_prestamo,@Param("id_cliente_actualizado") String id_cliente_actualizado,@Param("id_gerente_actualizado") String id_gerente_actualizado, @Param("id_prestamo_actualizado") Integer id_prestamo_actualizado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CREDENCIALES_PRESTAMO WHERE id_cliente = :id_cliente AND id_gerente =:id_gerente AND id_prestamo =:id_prestamo", nativeQuery = true)
    void eliminarCredencialesPrestamo(@Param("id_cliente") String id_cliente, @Param("id_gerente") String id_gerente, @Param("id_prestamo") Integer id_prestamo);

}