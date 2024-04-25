package uniandes.edu.co.proyecto.modelo;


import java.io.Serializable;

import jakarta.persistence.Embeddable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class CredencialesPrestamoPK implements Serializable {


    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idUsuario")
    private Usuario idCliente;

    @ManyToOne
    @JoinColumn(name = "idGerente", referencedColumnName = "idUsuario")
    private Usuario idGerente;

    @ManyToOne
    @JoinColumn(name = "idPrestamo", referencedColumnName = "idPrestamo")
    private Prestamo idPrestamo;
    

    public CredencialesPrestamoPK(){;}


    public CredencialesPrestamoPK(Usuario idCliente, Usuario idGereUsuario, Prestamo idPrestamo) {
        this.idCliente = idCliente;
        this.idGerente = idGereUsuario;
        this.idPrestamo = idPrestamo;
    }


    public Usuario getIdCliente() {
        return idCliente;
    }


    public void setIdCliente(Usuario idCliente) {
        this.idCliente = idCliente;
    }


    public Usuario getIdGerente() {
        return idGerente;
    }


    public void setIdGerente(Usuario idGereUsuario) {
        this.idGerente = idGereUsuario;
    }


    public Prestamo getIdPrestamo() {
        return idPrestamo;
    }


    public void setIdPrestamo(Prestamo idPrestamo) {
        this.idPrestamo = idPrestamo;
    }


}







    




    



