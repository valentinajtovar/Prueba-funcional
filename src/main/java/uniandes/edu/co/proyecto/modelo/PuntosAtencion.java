package uniandes.edu.co.proyecto.modelo;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PUNTO_ATENCION")
public class PuntosAtencion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idPuntoAtencion;

    private String nombre;

    @ManyToOne
    @JoinColumn(name ="tipo_punto_atencion", referencedColumnName = "tipoPuntoAtencion")
    private TiposPuntosAtencion tiposPuntosAtencion;
    
    private String locacion;

    private String horarioApertura;

    private String horarioCierre;

    @ManyToOne
    @JoinColumn(name ="id_Oficina", referencedColumnName = "idOficina")
    private Oficina idOficina;

    public PuntosAtencion(){;}

    public PuntosAtencion(String nombre,TiposPuntosAtencion tiposPuntosAtencion,String locacion,String horarioApertura,String horarioCierre, Oficina idOficina)
    {
        this.nombre = nombre;
        this.tiposPuntosAtencion = tiposPuntosAtencion;
        this.locacion = locacion;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.idOficina = idOficina;
    }

    public Integer getIdPuntoAtencion(){
        return idPuntoAtencion;
    }

    public String getNombre(){
        return nombre;
    } 

    public TiposPuntosAtencion getTipo(){
        return tiposPuntosAtencion;
    } 

    public String getLocacion(){
        return locacion;
    } 

    public String getHorarioApertura(){
        return horarioApertura;
    }

    public String getHorarioCierre(){
        return horarioCierre;
    }

    public Oficina getIdOficina(){
        return idOficina;
    }

    public void setIdPuntosAtencion(Integer idPuntosAtencion){
        this.idPuntoAtencion = idPuntosAtencion;
    }


    public void setNombre(String nombre){
        this.nombre = nombre;
    } 

    public void setTipo(TiposPuntosAtencion tiposPuntosAtencion){
        this.tiposPuntosAtencion = tiposPuntosAtencion;
    } 

    public void setLocacion(String locacion){
        this.locacion = locacion;
    }

    public void setHorarioApertura(String horarioApertura){
        this.horarioApertura = horarioApertura;
    }

    public void setHorarioCierre(String horarioCierre){
        this.horarioCierre = horarioCierre;
    }

    public void setIdOficina(Oficina idOficina) {
        this.idOficina = idOficina;
    } 


}
