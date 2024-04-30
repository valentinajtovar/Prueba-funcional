package uniandes.edu.co.proyecto.modelo;

import java.util.Collection;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "ESTADO_CUENTA")
public class EstadoCuenta {

    @Id
    private String estadoCuenta;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "estadoCuenta", cascade = CascadeType.ALL)
    Collection<Cuenta> cuentas;

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