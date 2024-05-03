package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CREDENCIALES_CUENTA")
public class CredencialesCuenta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCredencialesCuenta;

    @ManyToOne
    @JoinColumn(name ="ID_USUARIO", referencedColumnName = "idUsuario")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name ="ID_GERENTE", referencedColumnName = "idUsuario")
    private Usuario gerente;

    @OneToOne
    @JoinColumn(name ="ID_CUENTA", referencedColumnName = "idCuenta")
    private Cuenta cuenta;

    public CredencialesCuenta(){;}


    public CredencialesCuenta(Usuario cliente, Usuario gerente) {
        this.cliente = cliente;
        this.gerente = gerente;
    }


    public Integer getIdCredencialesCuenta() {
        return idCredencialesCuenta;
    }


    public void setIdCredencialesCuenta(Integer idCredencialesCuenta) {
        this.idCredencialesCuenta = idCredencialesCuenta;
    }


    public Usuario getCliente() {
        return cliente;
    }


    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }


    public Usuario getGerente() {
        return gerente;
    }


    public void setGerente(Usuario gerente) {
        this.gerente = gerente;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
