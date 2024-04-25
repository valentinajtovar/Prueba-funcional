package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CredencialesCuentaPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idUsuario")
    private Usuario idCliente;

    @ManyToOne
    @JoinColumn(name = "idGerente", referencedColumnName = "idUsuario")
    private Usuario idGerente;

    @ManyToOne
    @JoinColumn(name = "idCuenta", referencedColumnName = "idCuenta")
    private Cuenta idCuenta;

    public CredencialesCuentaPK(){;}

    public CredencialesCuentaPK(Usuario idCliente,Usuario idGerente,Cuenta idCuenta){
        this.idCliente = idCliente;
        this.idGerente = idGerente;
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

    public Usuario getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Usuario idGerente) {
        this.idGerente = idGerente;
    }
}
