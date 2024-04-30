package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, String>{
        @Query(value = "SELECT * FROM TIPO_DOCUMENTO", nativeQuery = true)
        Collection<TipoDocumento> darTipoDocumentos();

        @Query(value = "SELECT * FROM TIPO_DOCUMENTO WHERE TIPO_DOCUMENTO = :tipoDocumento", nativeQuery = true)
        Optional<TipoDocumento> darTipoDocumento(@Param("tipoDocumento") String tipoDocumento);


        @Modifying
        @Transactional
        @Query(value = "INSERT INTO TIPO_DOCUMENTO (tipoDocumento) VALUES (:tipoDocumento)", nativeQuery = true)
        void insertarTipoDocumento(@Param("tipoDocumento") String tipoDocumento);

        @Modifying
        @Transactional
        @Query(value = "UPDATE TIPO_DOCUMENTO SET TIPO_DOCUMENTO = :tipoDocumento WHERE TIPO_DOCUMENTO = :tipoDocumento", nativeQuery = true)
        void actualizarTipoDocumento(@Param("tipoDocumento") String tipoDocumento);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM TIPO_DOCUMENTO WHERE TIPO_DOCUMENTO = :tipoDocumento", nativeQuery = true)
        void eliminarTipoDocumento(@Param("tipoDocumento") String tipoDocumento);
}