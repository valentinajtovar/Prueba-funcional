package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRANSACCION_PRESTAMO")
public class TransaccionPrestamo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idTransccionPrestamo;

    private Float monto;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idCajero", referencedColumnName = "idUsuario")
    private Usuario idCajero;

    @ManyToOne
    @JoinColumn(name = "idPuntoAtencion", referencedColumnName = "idPuntosAtencion")
    private PuntosAtencion idPuntoAtencion;

    @ManyToOne
    @JoinColumn(name = "tipoOperacionPrestamo", referencedColumnName="tipoOperacionPrestamo")
    private  TipoOperacionPrestamo tipoOperacionPrestamo;

    @ManyToOne
    @JoinColumn(name = "idPrestamo", referencedColumnName = "idPrestamo")
    private Prestamo idPrestamo;

    public TransaccionPrestamo(){;}

    public TransaccionPrestamo(Float monto,Date fecha, Usuario idcajero,PuntosAtencion puntosAtencion, TipoOperacionPrestamo tipoOperacionPrestamo,Prestamo idPrestamo){
        this.monto = monto;
        this.fecha=fecha;
        
        this.idCajero = idcajero;
        this.idPuntoAtencion = puntosAtencion;
        this.tipoOperacionPrestamo = tipoOperacionPrestamo;
        this.idPrestamo = idPrestamo; 
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(Usuario idCajero) {
        this.idCajero = idCajero;
    }

    public Prestamo getIdPrestamo() {
        return idPrestamo;
    }
 
    public void setIdPrestamo(Prestamo idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public PuntosAtencion getIdPuntoAtencion() {
        return idPuntoAtencion;
    }

    public void setIdPuntoAtencion(PuntosAtencion idPuntoAtencion) {
        this.idPuntoAtencion = idPuntoAtencion;
    }
    
    public Integer getIdTransccionPrestamo() {
        return idTransccionPrestamo;
    }

    public void setIdTransccionPrestamo(Integer idTransccionPrestamo) {
        this.idTransccionPrestamo = idTransccionPrestamo;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public TipoOperacionPrestamo getTipoOperacionPrestamo() {
        return tipoOperacionPrestamo;
    }

    public void setTipoOperacionPrestamo(TipoOperacionPrestamo tipoOperacionPrestamo) {
        this.tipoOperacionPrestamo = tipoOperacionPrestamo;
    }
}
