package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_OPERACION_PRESTAMO")
public class TipoOperacionPrestamo {
    @Id
    private String tipoOperacionPrestamo;

    public TipoOperacionPrestamo(){;}

    public TipoOperacionPrestamo(String tipoOperacionPrestamo)
    {
        this.tipoOperacionPrestamo = tipoOperacionPrestamo;
    }

    public String getTipoCuenta(){
        return tipoOperacionPrestamo;
    }  

    public void setTipoCuenta(String tipoOperacionPrestamo){
        this.tipoOperacionPrestamo = tipoOperacionPrestamo;
    }
}
