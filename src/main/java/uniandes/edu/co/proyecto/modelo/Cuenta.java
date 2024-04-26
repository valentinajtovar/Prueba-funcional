package uniandes.edu.co.proyecto.modelo;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "CUENTAS")
public class Cuenta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCuenta;

    @OneToOne
    private CredencialesCuenta credencialesCuenta;
    
    @ManyToOne
    @JoinColumn(name ="tipoCuenta", referencedColumnName = "tipoCuenta")
    private TipoCuenta tipoCuenta;

    @ManyToOne
    @JoinColumn(name ="estadoCuenta", referencedColumnName = "estadoCuenta")
    private EstadoCuenta estadoCuenta;

    private double saldo;

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

    public CredencialesCuenta getCredencialesCuenta() {
        return credencialesCuenta;
    }
    
    public void setCredencialesCuenta(CredencialesCuenta credencialesCuenta) {
        this.credencialesCuenta = credencialesCuenta;
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
