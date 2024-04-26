package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CuentaOrigenTransaccionCuenta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCuentaOrigenTransaccionCuenta;

    @ManyToOne
    @JoinColumn(name ="cuenta", referencedColumnName = "idCuenta")
    private Cuenta cuenta;
}
