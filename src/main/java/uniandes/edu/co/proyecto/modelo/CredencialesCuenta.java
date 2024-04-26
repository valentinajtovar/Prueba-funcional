package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CREDENCIALES_CUENTA")
public class CredencialesCuenta {
    @EmbeddedId
/*
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="idCuenta", referencedColumnName = "idCuenta")
    private Cuenta idCuenta;
 */

    private CredencialesCuentaPK pk;

    public CredencialesCuenta(){;}

    public CredencialesCuenta(Usuario cliente, Usuario gerente, Cuenta cuenta){
        super();
        this.pk = new CredencialesCuentaPK(cliente,gerente,cuenta);
    }

    public CredencialesCuentaPK getPk() {
        return pk;
    }

    public void setPk(CredencialesCuentaPK pk) {
        this.pk = pk;
    }

}
