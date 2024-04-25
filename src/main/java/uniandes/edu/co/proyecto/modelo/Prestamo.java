package uniandes.edu.co.proyecto.modelo;


import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder.In;


@Entity
@Table(name = "PRESTAMO")
public class Prestamo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idPrestamo;

    private Date fechaCreacion;

    private Float monto;

    @ManyToOne
    @JoinColumn(name ="estado", referencedColumnName = "estadoPrestamo")
    private EstadoPrestamo estadoPrestamo;

    @ManyToOne
    @JoinColumn(name ="tipoPrestamo", referencedColumnName = "tipoPrestamo")
    private TipoPrestamo tipoPrestamo;

    private Float interes;

    private Integer cuotas;

    private Integer diaMesCuota;

    private float valorCuota;

    public Prestamo(){;}

    public Prestamo( Date fechaCreacion, Float monto, double valor, EstadoPrestamo estadoPrestamo,
            TipoPrestamo tipoPrestamo,Float interes,Integer cuotas, Integer diaMesCuota,Float valorCuota) {
  
        this.fechaCreacion = fechaCreacion;
        this.monto = monto;
        this.estadoPrestamo = estadoPrestamo;
        this.tipoPrestamo = tipoPrestamo;
        this.interes = interes;
        this.cuotas = cuotas;
        this.diaMesCuota = diaMesCuota;
        this.valorCuota= valorCuota;
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public EstadoPrestamo getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(EstadoPrestamo estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    public TipoPrestamo getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(TipoPrestamo tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    public Float getInteres() {
        return interes;
    }

    public void setInteres(Float interes) {
        this.interes = interes;
    }

    public Integer getCuotas(){
        return cuotas;
    }

    public void serCuotas(Integer cuotas){
        this.cuotas = cuotas;
    }

    public Integer getDiaMesCuota(Integer diaMesCuota){
        return diaMesCuota;
    }

    public void setDiaMesCuota(Integer diaMesCuota){
        this.diaMesCuota = diaMesCuota;
    }

    public float getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(float valorCuota) {
        this.valorCuota = valorCuota;
    }
}
