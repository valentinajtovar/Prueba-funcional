package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;


    @ManyToOne
    @JoinColumn(name ="tipoDocumento", referencedColumnName = "tipoDocumento")
    private TipoDocumento tipoDocumento;

    private Integer numeroDocumento;

    private String nombre;

    private String nacionalidad;

    private String direccionFisica;

    private String direccionDigital;

    private Long telefono;

    private Integer codigoPostal;


    @ManyToOne
    @JoinColumn(name ="tipoUsuario", referencedColumnName = "tipoUsuario")
    private TipoUsuario tipoUsuario;

    

    public Usuario(){;}

    

    public Usuario( TipoDocumento tipoDocumento, Integer numeroDocumento, String nombre,
            String nacionalidad, String direccionFisica, String direccionDigital, Long telefono, Integer codigoPostal,
            TipoUsuario tipoUsuario) {

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



    public Long getTelefono() {
        return telefono;
    }



    public void setTelefono(Long telefono) {
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



    public Integer getIdUsuario() {
        return idUsuario;
    }



    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }





    
   

}
