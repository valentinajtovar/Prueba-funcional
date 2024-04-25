package uniandes.edu.co.proyecto.modelo;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;


@Entity
@Table(name = "CUENTAS")
public class Cuenta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCuenta;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="TIPO_CUENTA")
    private TipoCuenta tipoCuenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ESTADO_CUENTA")
    private EstadoCuenta estadoCuenta;

    private double saldo;

    private Date fechaUltimaTransaccion;

    public Cuenta() {;
    }

    public Cuenta(TipoCuenta tipoCuenta, EstadoCuenta estadoCuenta, double saldo, Date fechaUltimaTransaccion) {
        this.tipoCuenta = tipoCuenta;
        this.estadoCuenta = estadoCuenta;
        this.saldo = saldo;
        this.fechaUltimaTransaccion = fechaUltimaTransaccion;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public EstadoCuenta getEstadoCuenta(){
        return estadoCuenta;
    }

    public double getSaldo(){
        return saldo;
    }

    public Date getFechaUltimaTransaccion(){
        return fechaUltimaTransaccion;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta){
        this.tipoCuenta = tipoCuenta;
    }

    public void setEstadoCuenta(EstadoCuenta estadoCuenta){
        this.estadoCuenta=estadoCuenta;
    }

    public void setSaldo(double saldo){
        this.saldo=saldo;
    }

    public void setFechaUltimaTransaccion(Date fechaUltimaTransaccion){
        this.fechaUltimaTransaccion = fechaUltimaTransaccion;
    }
}
