package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;


@Entity
@Table(name = "CUENTA")
public class Cuenta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCuenta;

    private Usuario cliente;

    private TipoCuenta tipoCuenta;

    private EstadoCuenta estadoCuenta;

    private double valor;

    public Cuenta() {;
    }

    public Cuenta(Integer idCuenta, Usuario cliente, TipoCuenta tipoCuenta, EstadoCuenta estadoCuenta, double valor) {
        this.idCuenta = idCuenta;
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
        this.estadoCuenta = estadoCuenta;
        this.valor = valor;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
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
