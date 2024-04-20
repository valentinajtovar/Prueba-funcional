package uniandes.edu.co.proyecto.modelo;



import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;


@Entity
@Table(name = "CREDENCIALES_PRESTAMO")
    public class CredencialesPrestamo {

        @EmbeddedId

        private CredencialesPrestamoPK pk;


    public CredencialesPrestamo(){;}


    public CredencialesPrestamo(Usuario cliente, Usuario Gerente, Prestamo prestamo) {
        super();
        this.pk = new CredencialesPrestamoPK(cliente, Gerente, prestamo);
    }


    public CredencialesPrestamoPK getPk() {
        return pk;
    }


    public void setPk(CredencialesPrestamoPK pk) {
        this.pk = pk;
    }

    



}
