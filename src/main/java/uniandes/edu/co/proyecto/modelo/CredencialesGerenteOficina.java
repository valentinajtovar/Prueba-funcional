package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;


@Entity
@Table(name = "CREDENCIALES_GERENTE_OFICINA")
public class CredencialesGerenteOficina {
    @EmbeddedId

    private CredencialesGerenteOficinaPK pk;

    public CredencialesGerenteOficina(){;}

    public CredencialesGerenteOficina(Usuario gerente,Oficina oficina){
        super();
        this.pk = new CredencialesGerenteOficinaPK(gerente,oficina);
    }

    public CredencialesGerenteOficinaPK getPk() {
        return pk;
    }

    public void setPk(CredencialesGerenteOficinaPK pk) {
        this.pk = pk;
    }
}
