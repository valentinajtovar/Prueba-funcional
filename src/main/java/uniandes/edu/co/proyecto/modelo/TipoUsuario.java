package uniandes.edu.co.proyecto.modelo;

import java.util.Collection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_USUARIO")
public class TipoUsuario {
    @Id
    private String tipoUsuario;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tipoUsuario")
    Collection<Usuario> usuarios;

    public TipoUsuario(){;}

    public TipoUsuario(String tipoUsuario)
    {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario(){
        return tipoUsuario;
    } 

    public void setTipoUsuario(String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    } 
}

