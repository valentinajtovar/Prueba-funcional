package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @OneToOne
    @JoinColumn(name="ID_USUARIO")
    private DatosUsuario idUsuario;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="TIPO_DOCUMENTO")
    private TipoDocumento tipoDocumento;

    private Integer numeroDocumento;

    private String nombre;

    private String nacionalidad;

    private String direccionFisica;

    private String direccionDigital;

    private Integer telefono;

    private Integer codigoPostal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="TIPO_USUARIO")
    private TipoUsuario tipoUsuario;


    public Usuario(){;}

    
    public Usuario(DatosUsuario id, TipoDocumento tipoDocumento, Integer numeroDocumento, String nombre,
            String nacionalidad, String direccionFisica, String direccionDigital, Integer telefono,
            Integer codigoPostal, TipoUsuario tipoUsuario) {
        this.idUsuario = id;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.direccionFisica = direccionFisica;
        this.direccionDigital = direccionDigital;
        this.telefono = telefono;
        this.codigoPostal = codigoPostal;
        this.tipoUsuario = tipoUsuario;
    }

    public DatosUsuario getId() {
        return idUsuario;
    }

    public void setId(DatosUsuario id) {
        this.idUsuario = id;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccionFisica() {
        return direccionFisica;
    }

    public void setDireccionFisica(String direccionFisica) {
        this.direccionFisica = direccionFisica;
    }

    public String getDireccionDigital() {
        return direccionDigital;
    }

    public void setDireccionDigital(String direccionDigital) {
        this.direccionDigital = direccionDigital;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    


    



}
