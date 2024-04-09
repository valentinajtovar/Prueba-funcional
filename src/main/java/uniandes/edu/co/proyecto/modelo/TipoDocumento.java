package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_DOCUMENTO")
public class TipoDocumento {
    @Id
    private String tipoDocumento;

    public TipoDocumento(){;}

    public TipoDocumento(String tipoDocumento){
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoDocumento(){
        return tipoDocumento;
    } 

    public void setTipoDocumento(String tipoDocumento){
        this.tipoDocumento = tipoDocumento;
    }
}