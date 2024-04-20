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


@Entity
@Table(name = "PRESTAMO")
    public class Prestamo {

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer idPrestamo;

        private Date fecha;

        private Integer pagado;

        private double valor;


    @ManyToOne
    @JoinColumn(name ="estado", referencedColumnName = "estadoPrestamo")
    private EstadoPrestamo estado;

    @ManyToOne
    @JoinColumn(name ="tipoPrestamo", referencedColumnName = "tipoPrestamo")
    private TipoPrestamo tipoPrestamo;

    public Prestamo(){;}

    public Prestamo( Date fecha, Integer pagado, double valor, EstadoPrestamo estado,
            TipoPrestamo tipoPrestamo) {
  
        this.fecha = fecha;
        this.pagado = pagado;
        this.valor = valor;
        this.estado = estado;
        this.tipoPrestamo = tipoPrestamo;
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getPagado() {
        return pagado;
    }

    public void setPagado(Integer pagado) {
        this.pagado = pagado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }

    public TipoPrestamo getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(TipoPrestamo tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    

    







    




    



}
