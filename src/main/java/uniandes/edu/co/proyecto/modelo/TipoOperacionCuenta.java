package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_OPERACION_CUENTA")
public class TipoOperacionCuenta {
    @Id
    private String tipoOperacionCuenta;

    public TipoOperacionCuenta(){;}

    public TipoOperacionCuenta(String tipoOperacionCuenta){
        this.tipoOperacionCuenta= tipoOperacionCuenta;
    }

    public String getTipoOperacionCuenta() {
        return tipoOperacionCuenta;
    }

    public void setTipoOperacionCuenta(String tipoOperacionCuenta) {
        this.tipoOperacionCuenta = tipoOperacionCuenta;
    }
    
}
