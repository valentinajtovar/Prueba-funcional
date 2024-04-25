package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Collection;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "TIPO_CUENTA")
public class TipoCuenta {
    @Id
    private String tipoCuenta;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tipoCuenta", cascade = CascadeType.ALL)
    Collection<Cuenta> cuentas;

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
