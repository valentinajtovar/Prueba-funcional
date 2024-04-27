package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Embeddable
public class CredencialesCuentaPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "idUsuario")
    private Usuario idCliente;

    @OneToOne
    @JoinColumn(name = "ID_CUENTA", referencedColumnName = "idCuenta")
    private Cuenta idCuenta;

    

    public CredencialesCuentaPK(){;}

    public CredencialesCuentaPK(Usuario idCliente,Cuenta idCuenta){
        this.idCliente = idCliente;
        this.idCuenta = idCuenta;
    }
    
    public Usuario getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Usuario idCliente) {
        this.idCliente = idCliente;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }
}
