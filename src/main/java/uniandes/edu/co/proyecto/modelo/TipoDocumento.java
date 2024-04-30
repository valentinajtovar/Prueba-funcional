package uniandes.edu.co.proyecto.modelo;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_DOCUMENTO")
public class TipoDocumento {
    @Id
    private String tipoDocumento;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tipoDocumento", cascade = CascadeType.ALL)
    Collection<Usuario> usuarios;

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