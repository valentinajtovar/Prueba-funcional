package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NACIONALIDAD")
public class Nacionalidad {
    @Id
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
}
