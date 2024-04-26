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

    @OneToOne
    @JoinColumn(name = "idCuenta", referencedColumnName = "idCuenta")
    private Cuenta idCuenta;

    public CredencialesCuenta(){;}

    public CredencialesCuenta(Usuario cliente, Usuario gerente, Cuenta cuenta){
        super();
        this.pk = new CredencialesCuentaPK(cliente,gerente);
        this.idCuenta = cuenta;
    }

    public CredencialesCuentaPK getPk() {
        return pk;
    }

    public void setPk(CredencialesCuentaPK pk) {
        this.pk = pk;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

}
