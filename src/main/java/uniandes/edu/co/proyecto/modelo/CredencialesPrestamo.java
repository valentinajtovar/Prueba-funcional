package uniandes.edu.co.proyecto.modelo;



import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "CREDENCIALES_PRESTAMO")
    public class CredencialesPrestamo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCredencialesCuenta;

    @ManyToOne
    @JoinColumn(name ="ID_USUARIO", referencedColumnName = "idUsuario")
    private Usuario cliente;

    @OneToOne
    @JoinColumn(name ="ID_PRESTAMO", referencedColumnName = "idPrestamo")
    private Prestamo prestamo;

    @ManyToOne
    @JoinColumn(name ="ID_GERENTE", referencedColumnName = "idUsuario")
    private Usuario gerente;

    


    public CredencialesPrestamo(){;}




    public CredencialesPrestamo(Usuario cliente, Prestamo prestamo, Usuario gerente) {
        this.cliente = cliente;
        this.prestamo = prestamo;
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




    public Prestamo getPrestamo() {
        return prestamo;
    }




    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }




    public Usuario getGerente() {
        return gerente;
    }




    public void setGerente(Usuario gerente) {
        this.gerente = gerente;
    }
       

}
