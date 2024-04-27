package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CREDENCIALES_CUENTA")
public class CredencialesCuenta {
    @EmbeddedId

    private CredencialesCuentaPK pk;

    @ManyToOne
    @JoinColumn(name = "idGerente", referencedColumnName = "idUsuario")
    private Usuario idGerente;

    public CredencialesCuenta(){;}

    public CredencialesCuenta(Usuario cliente, Usuario gerente, Cuenta cuenta){
        super();
        this.pk = new CredencialesCuentaPK(cliente,cuenta);
        this.idGerente = gerente;
    }

    public CredencialesCuentaPK getPk() {
        return pk;
    }

    public void setPk(CredencialesCuentaPK pk) {
        this.pk = pk;
    }

    public Usuario getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Usuario idGerente) {
        this.idGerente = idGerente;
    }

}
