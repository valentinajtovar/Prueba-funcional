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
@Table(name = "PUNTOS_ATENCION")
public class PuntosAtencion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idPuntosAtencion;
/*
    @OneToMany(mappedBy = "puntosAtencion", cascade = CascadeType.ALL,orphanRemoval=true)
    private List<Transaccion> transacciones;*/


    private String nombre;

    @ManyToOne
    @JoinColumn(name ="tipo", referencedColumnName = "nombre")
    private TiposPuntosAtencion tipo;
    
    private String locacion;

    private String horarioApertura;

    private String horarioCierre;

    @ManyToOne
    @JoinColumn(name ="idOficina", referencedColumnName = "idOficina")
    private Oficina idOficina;

    public PuntosAtencion(){;}

    public PuntosAtencion(String nombre,TiposPuntosAtencion tipo,String locacion,String horarioApertura,String horarioCierre, Oficina idOficina)
    {
        this.nombre = nombre;
        this.tipo = tipo;
        this.locacion = locacion;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.idOficina = idOficina;
    }

    public Integer getIdPuntosAtencion(){
        return idPuntosAtencion;
    }

    public String getNombre(){
        return nombre;
    } 

    public TiposPuntosAtencion getTipo(){
        return tipo;
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
        this.idPuntosAtencion = idPuntosAtencion;
    }


    public void setNombre(String nombre){
        this.nombre = nombre;
    } 

    public void setTipo(TiposPuntosAtencion tipo){
        this.tipo = tipo;
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
