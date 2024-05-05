package uniandes.edu.co.proyecto.modelo;


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
@Table(name = "OFICINA")
public class Oficina {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idOficina;

    private String nombre;

    private String direccion;
    
    private Integer numeroPuntosDisponibles;

    @ManyToOne
    @JoinColumn(name ="gerente", referencedColumnName = "idUsuario")
    private Usuario gerente;
    
    public Oficina(){;}

    
    public Oficina( String nombre, String direccion, Integer numeroPuntosDisponibles) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroPuntosDisponibles = numeroPuntosDisponibles;
    }


    public Integer getIdOficina() {
        return idOficina;
    }


    public void setIdOficina(Integer idOficina) {
        this.idOficina = idOficina;
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


    public void setNumeroPuntosDisponibles(Integer numeroPuntosDisponibles) {
        this.numeroPuntosDisponibles = numeroPuntosDisponibles;
    }


    public Usuario getGerente() {
        return gerente;
    }


    public void setGerente(Usuario gerente) {
        this.gerente = gerente;
    }
}