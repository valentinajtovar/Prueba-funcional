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
@Table(name = "TIPOS_PUNTOS_ATENCION")
public class TiposPuntosAtencion {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idTiposPuntosAtencion;

    private String nombre;

    public TiposPuntosAtencion(){;}

    

    public TiposPuntosAtencion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public Integer getIdTiposPuntosAtencion() {
        return idTiposPuntosAtencion;
    }


    public void setIdTiposPuntosAtencion(Integer idTiposPuntosAtencion) {
        this.idTiposPuntosAtencion = idTiposPuntosAtencion;
    }

    


    



}
