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
    private String tipoPuntoAtencion;

    public TiposPuntosAtencion(){;}


    public TiposPuntosAtencion(String tipoPuntoAtencion) {
        this.tipoPuntoAtencion = tipoPuntoAtencion;
    }

    public String getTipoPuntoAtencion() {
        return tipoPuntoAtencion;
    }

    public void setTipoPuntoAtencion(String tipoPuntoAtencion) {
        this.tipoPuntoAtencion = tipoPuntoAtencion;
    }
}
