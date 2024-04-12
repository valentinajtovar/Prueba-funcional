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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idOficina;

    private String nombre;

    
    private String locacion;
    
    private Integer gerente;
    
    public Oficina(){;}

    //CAMBIAR TIPO GERENTE
    public Oficina( String nombre, String locacion, Integer gerente) {
        this.nombre = nombre;
        this.locacion = locacion;
        this.gerente = gerente;
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


    public String getLocacion() {
        return locacion;
    }


    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }


    public Integer getGerente() {
        return gerente;
    }


    public void setGerente(Integer gerente) {
        this.gerente = gerente;
    }




    



}
