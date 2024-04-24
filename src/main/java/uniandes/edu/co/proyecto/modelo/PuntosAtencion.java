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

   
    @ManyToOne
    @JoinColumn(name ="tipo", referencedColumnName = "tipoPuntosAtencion")
    private TiposPuntosAtencion tipo;

    private String nombre;
    
    private String locacion;

    @ManyToOne
    @JoinColumn(name ="fk_oficina_id")
    private Oficina oficina; 

    public PuntosAtencion(){;}

    public PuntosAtencion(String nombre,TiposPuntosAtencion tipo,String locacion)
    {
        this.nombre = nombre;
        this.tipo = tipo;
        this.locacion = locacion;
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

    public Oficina getIdOficina() {
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

    public void setIdOficina(Oficina idOficina) {
        this.idOficina = idOficina;
    }

}
