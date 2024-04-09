package uniandes.edu.co.proyecto.modelo;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "OFICINA")
public class Oficina {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idPuntosAtencion;
/*
    @OneToMany(mappedBy = "puntosAtencion", cascade = CascadeType.ALL,orphanRemoval=true)
    private List<Transaccion> transacciones;*/

    private String nombre;

    
    private String locacion;
    
    private String gerente;

    public Oficina(){;}

    
    public Oficina(Integer idPuntosAtencion, String nombre, String locacion, String gerente) {
        this.idPuntosAtencion = idPuntosAtencion;
        this.nombre = nombre;
        this.locacion = locacion;
        this.gerente = gerente;
    }


    public Integer getIdPuntosAtencion() {
        return idPuntosAtencion;
    }


    public void setIdPuntosAtencion(Integer idPuntosAtencion) {
        this.idPuntosAtencion = idPuntosAtencion;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getLocacion() {
        return locacion;
    }


    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }


    public String getGerente() {
        return gerente;
    }


    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    



}
