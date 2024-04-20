package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "NACIONALIDAD")
public class Nacionalidad {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idNacionalidad;

    private String nombre;

    public Nacionalidad(){;}

    public Nacionalidad(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    } 

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Integer getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(Integer idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    } 

    
}
