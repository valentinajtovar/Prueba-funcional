package uniandes.edu.co.proyecto.modelo;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "TIPO_PUNTO_ATENCION")
public class TiposPuntosAtencion {

    @Id
    private String tipoPuntosAtencion;

    public TiposPuntosAtencion(){;}

    

    public TiposPuntosAtencion(String tipoPuntosAtencion) {
        this.tipoPuntosAtencion = tipoPuntosAtencion;
    }

    public String getTipoPuntosAtencion() {
        return tipoPuntosAtencion;
    }

    public void setTipoPuntosAtencion(String tipoPuntosAtencion) {
        this.tipoPuntosAtencion = tipoPuntosAtencion;
    }
}
