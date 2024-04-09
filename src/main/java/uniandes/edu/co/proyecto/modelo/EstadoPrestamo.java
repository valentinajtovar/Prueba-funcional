package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESTADO_PRESTAMO")
public class EstadoPrestamo {
    @Id
    private String estadoPrestamo;

    public EstadoPrestamo(){;}

    public EstadoPrestamo(String estadoPrestamo)
    {
        this.estadoPrestamo = estadoPrestamo;
    }

    public String getEstadoPrestamo(){
        return estadoPrestamo;
    } 

    public void setEstadoPrestamo(String estadoPrestamo){
        this.estadoPrestamo = estadoPrestamo;
    } 
}