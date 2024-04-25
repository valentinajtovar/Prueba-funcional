package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;

@Entity
@Table(name = "CREDENCIALES_CUENTA")
public class CredencialesCuenta {
    @EmbeddedId

    private CredencialesCuentaPK pk;

    public CredencialesCuenta(){;}

    public CredencialesCuenta(Usuario cliente, Usuario gerente, Cuenta cuenta){
        super();
        this.pk = new CredencialesCuentaPK(cliente,gerente,cuenta);
    }

    public void setPk(CredencialesCuentaPK pk) {
        this.pk = pk;
    }

}
