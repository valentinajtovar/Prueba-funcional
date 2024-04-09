package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_OPERACION")
public class TipoOperacion {
    @Id
    private String tipoOperacion;

    public TipoOperacion(){;}

    public TipoOperacion(String tipoOperacion)
    {
        this.tipoOperacion = tipoOperacion;
    }

    public String getTipoOperacion(){
        return tipoOperacion;
    } 

    public void setTipoOperacion(String tipoOperacion){
        this.tipoOperacion = tipoOperacion;
    } 
}
