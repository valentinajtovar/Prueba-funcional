package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_PRESTAMO")
public class TipoPrestamo {
    @Id
    private String tipoPrestamo;

    public TipoPrestamo(){;}

    public TipoPrestamo(String tipoPrestamo)
    {
        this.tipoPrestamo = tipoPrestamo;
    }

    public String getPrestamo(){
        return tipoPrestamo;
    } 

    public void setPrestamo(String tipoPrestamo){
        this.tipoPrestamo = tipoPrestamo;
    } 
}

