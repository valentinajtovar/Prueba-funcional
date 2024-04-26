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
@Table(name = "TRANSACCION_CUENTA")
public class TransaccionCuenta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idTransaccionCuenta;

    @ManyToOne
    @JoinColumn(name = "idCajero", referencedColumnName = "idUsuario")
    private Usuario idCajero;

    @ManyToOne
    @JoinColumn(name = "idPuntosAtencion", referencedColumnName = "idPuntosAtencion")
    private PuntosAtencion idPuntosAtencion;

    @ManyToOne
    @JoinColumn(name = "tipoOperacionCuenta", referencedColumnName = "tipoOperacionCuenta")
    private TipoOperacionCuenta tipoOperacionCuenta;

    @ManyToOne
    @JoinColumn(name = "idCuentaOriginal", referencedColumnName = "idUsuario")
    private Usuario idCuentaOriginal;

    @ManyToOne
    @JoinColumn(name = "idCuentaDestino", referencedColumnName = "idUsuario")
    private Usuario idCuentaDestino;

    @ManyToOne
    @JoinColumn(name = "cuentaOrigenTransaccionCuenta", referencedColumnName = "idCuentaOrigenTransaccionCuenta")
    private CuentaOrigenTransaccionCuenta cuentaOrigenTransaccionCuenta;
 
    @ManyToOne
    @JoinColumn(name = "cuentaDestinoTransaccionCuenta", referencedColumnName = "idCuentaDestinoTransaccionCuenta")
    private CuentaDestinoTransaccionCuenta cuentaDestinoTransaccionCuenta;

    @ManyToOne
    @JoinColumn(name = "idPuntoAtencion", referencedColumnName = "idPuntosAtencion")
    private PuntosAtencion idPuntoAtencion;

    private double monto;

    private Date fecha;

    public TransaccionCuenta(){;}

    public TransaccionCuenta(Usuario idCajero,PuntosAtencion idPuntosAtencion,TipoOperacionCuenta tipoOperacionCuenta,Usuario idCuentaOriginal,Usuario idCuentaDestino,double monto,Date fecha){
        this.idCajero= idCajero;
        this.idPuntosAtencion= idPuntosAtencion;
        this.tipoOperacionCuenta = tipoOperacionCuenta;
        this.idCuentaOriginal = idCuentaOriginal;
        this.idCuentaDestino = idCuentaDestino;
        this.monto = monto;
        this.fecha = fecha;
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

    public Usuario getIdCuentaDestino() {
        return idCuentaDestino;
    }
    
    public void setIdCuentaDestino(Usuario idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    public Usuario getIdCuentaOriginal() {
        return idCuentaOriginal;
    }

    public void setIdCuentaOriginal(Usuario idCuentaOriginal) {
        this.idCuentaOriginal = idCuentaOriginal;
    }

    public PuntosAtencion getIdPuntosAtencion() {
        return idPuntosAtencion;
    }

    public void setIdPuntosAtencion(PuntosAtencion idPuntosAtencion) {
        this.idPuntosAtencion = idPuntosAtencion;
    }

    public Integer getIdTransaccionCuenta() {
        return idTransaccionCuenta;
    }

    public void setIdTransaccionCuenta(Integer idTransaccionCuenta) {
        this.idTransaccionCuenta = idTransaccionCuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public TipoOperacionCuenta getTipoOperacionCuenta() {
        return tipoOperacionCuenta;
    }

    public void setTipoOperacionCuenta(TipoOperacionCuenta tipoOperacionCuenta) {
        this.tipoOperacionCuenta = tipoOperacionCuenta;
    }

}
