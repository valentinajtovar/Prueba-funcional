package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUENTA_DESTINO_TRANSACCION_CUENTA")
public class CuentaDestinoTransaccionCuenta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCuentaDestinoTransaccionCuenta;

    @ManyToOne
    @JoinColumn(name ="cuenta", referencedColumnName = "idCuenta")
    private Cuenta cuenta;
}
