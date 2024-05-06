package uniandes.edu.co.proyecto.modelo;




import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name = "CUENTA")
public class Cuenta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCuenta;
    
    @ManyToOne
    @JoinColumn(name ="TIPO_CUENTA", referencedColumnName = "tipoCuenta")
    private TipoCuenta tipoCuenta;

    @ManyToOne
    @JoinColumn(name ="ESTADO_CUENTA", referencedColumnName = "estadoCuenta")
    private EstadoCuenta estadoCuenta;

    private Double saldo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaUltimaTransaccion;

    public Cuenta() {;
    }

    public Cuenta(TipoCuenta tipoCuenta, EstadoCuenta estadoCuenta, double saldo,Date fechaUltimaTransaccion) {        
        this.tipoCuenta = tipoCuenta;
        this.estadoCuenta = estadoCuenta;
        this.saldo = saldo;
        this.fechaUltimaTransaccion = fechaUltimaTransaccion;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public EstadoCuenta getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public Date getFechaUltimaTransaccion() {
        return fechaUltimaTransaccion;
    }

    public void setFechaUltimaTransaccion(Date fechaUltimaTransaccion) {
        this.fechaUltimaTransaccion = fechaUltimaTransaccion;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}
