package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_CUENTA")
public class TipoCuenta {
    @Id
    private String tipoCuenta;

    public TipoCuenta(){;}

    public TipoCuenta(String tipoCuenta)
    {
        this.tipoCuenta = tipoCuenta;
    }

    public String getTipoCuenta(){
        return tipoCuenta;
    }  

    public void setTipoCuenta(String tipoCuenta){
        this.tipoCuenta = tipoCuenta;
    }
}
