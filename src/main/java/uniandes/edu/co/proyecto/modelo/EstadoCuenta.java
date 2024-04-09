package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESTADO_CUENTA")
public class EstadoCuenta {
    @Id
    private String estadoCuenta;

    public EstadoCuenta(){;}

    public EstadoCuenta(String estadoCuenta)
    {
        this.estadoCuenta = estadoCuenta;
    }

    public String getEstadoCuenta(){
        return estadoCuenta;
    }  

    public void setEstadoCuenta(String estadoCuenta){
        this.estadoCuenta = estadoCuenta;
    }
}