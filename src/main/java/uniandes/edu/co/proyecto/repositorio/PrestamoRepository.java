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

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRESTAMO SET  ESTADO_PRESTAMO ='CERRADO' WHERE ID_PRESTAMO  = :id_prestamo", nativeQuery = true)
    void estadoPrestamoCerrado(@Param("id_prestamo") Integer id_prestamo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PRESTAMO ( FECHA_CREACION, MONTO,ESTADO_PRESTAMO,TIPO_PRESTAMO,INTERES,CUOTAS,DIA_MES_CUOTA,VALOR_CUOTA) VALUES ( :fecha, :monto, :estado_prestamo, :tipo_prestamo, :interes, :cuota, :dia_Mes_Cuota, :valor_Cuota)", nativeQuery = true)
    void insertarPrestamo(@Param("fecha") Date fecha, @Param("monto") Float monto,@Param("estado_prestamo") String estado_prestamo,  @Param("tipo_prestamo") String tipo_prestamo, @Param("interes") Float interes, @Param("cuota") Integer cuota, @Param("dia_Mes_Cuota") Integer dia_Mes_Cuota, @Param("valor_Cuota") Float valor_Cuota);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRESTAMO SET fecha =:fecha, pagado =:pagado, valor =:valor, estado =:estado, tipo_prestamo =:tipo_prestamo  WHERE id_prestamo =:id_prestamo", nativeQuery = true)
    void actutalizarPrestamo(@Param("id_prestamo") Integer id_prestamo, @Param("fecha") Date fecha, @Param("pagado") Integer pagado,@Param("valor") double valor,  @Param("estado") String estado, @Param("tipo_prestamo") String tipo_prestamo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PRESTAMO WHERE id_prestamo = :id_prestamo", nativeQuery = true)
    void eliminarPrestamo(@Param("id_prestamo") Integer id_prestamo);

    @Query(value = "SELECT * FROM PRESTAMO WHERE ID_PRESTAMO = :id_prestamo", nativeQuery = true)
    Prestamo buscarPrestamoId(@Param("id_prestamo") Integer id_prestamo);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE PRESTAMO SET MONTO =:monto  WHERE ID_PRESTAMO =:id_prestamo", nativeQuery = true)
    void actutalizarMontoPrestamo(@Param("id_prestamo") Integer id_prestamo, @Param("monto") Float monto);

}