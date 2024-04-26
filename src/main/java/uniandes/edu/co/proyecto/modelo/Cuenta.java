package uniandes.edu.co.proyecto.modelo;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "CUENTAS")
public class Cuenta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCuenta;
    
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

    public Cuenta(Usuario cliente, TipoCuenta tipoCuenta, EstadoCuenta estadoCuenta, double saldo,Date fechaUltimaTransaccion) {
        this.usuario = cliente;
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

    public Usuario getCliente() {
        return usuario;
    }

    public void setCliente(Usuario cliente) {
        this.usuario = cliente;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
    


    
    
   
    




    



}
