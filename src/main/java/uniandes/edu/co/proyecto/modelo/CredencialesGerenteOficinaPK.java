package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CredencialesGerenteOficinaPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "idGerente", referencedColumnName = "idUsuario")
    private Usuario idGerente;

    @ManyToOne
    @JoinColumn(name = "idOficina", referencedColumnName = "idOficina")
    private Oficina idOficina;

    public CredencialesGerenteOficinaPK(){;}

    public CredencialesGerenteOficinaPK(Usuario idGerente,Oficina idOficina){
        this.idGerente = idGerente;
        this.idOficina = idOficina;
    }

    public Usuario getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Usuario idGerente) {
        this.idGerente = idGerente;
    }

    public Oficina getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Oficina idOficina) {
        this.idOficina = idOficina;
    }
    
    
}
