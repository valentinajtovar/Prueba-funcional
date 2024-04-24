package uniandes.edu.co.proyecto.modelo;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "OFICINA")
public class Oficina {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idOficina;

    @OneToMany
    private Collection<PuntosAtencion> puntosAtencion;

    private String nombre;

    private String direccion;
    
    private Integer numeroPuntosDisponibles;
    
    public Oficina(){;}

    public Oficina( String nombre, String direccion, Integer numeroPuntosDisponibles) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroPuntosDisponibles = numeroPuntosDisponibles;
    }

    public Integer getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Integer idPuntosAtencion) {
        this.idOficina = idPuntosAtencion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNumeroPuntosDisponibles() {
        return numeroPuntosDisponibles;
    }

    public void setGerente(Integer numeroPuntosDisponibles) {
        this.numeroPuntosDisponibles = numeroPuntosDisponibles;
    }
}
