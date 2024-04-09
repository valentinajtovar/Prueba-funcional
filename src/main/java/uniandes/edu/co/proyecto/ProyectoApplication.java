package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.EstadoCuenta;
import uniandes.edu.co.proyecto.modelo.EstadoPrestamo;
import uniandes.edu.co.proyecto.modelo.Nacionalidad;
import uniandes.edu.co.proyecto.modelo.PuntosAtencion;
import uniandes.edu.co.proyecto.modelo.TipoCuenta;
import uniandes.edu.co.proyecto.modelo.TipoDocumento;
import uniandes.edu.co.proyecto.modelo.TipoOperacion;
import uniandes.edu.co.proyecto.modelo.TipoPrestamo;
import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.repositorio.EstadoCuentaRepository;
import uniandes.edu.co.proyecto.repositorio.EstadoPrestamoRepository;
import uniandes.edu.co.proyecto.repositorio.PuntosAtencionRepository;
import uniandes.edu.co.proyecto.repositorio.TipoCuentaRepository;
import uniandes.edu.co.proyecto.repositorio.TipoDocumentoRepository;
import uniandes.edu.co.proyecto.repositorio.TipoOperacionRepository;
import uniandes.edu.co.proyecto.repositorio.TipoPrestamoRepository;
import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;
import uniandes.edu.co.proyecto.repositorio.NacionalidadRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {
	@Autowired
	private PuntosAtencionRepository puntosAtencionRepository;

	@Autowired
	private EstadoPrestamoRepository estadoPrestamoRepository;
	
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;

	@Autowired
	private TipoCuentaRepository tipoCuentaRepository;

	@Autowired
	private EstadoCuentaRepository estadoCuentaRepository;

	@Autowired
	private TipoOperacionRepository tipoOperacionRepository;

	@Autowired
	private TipoPrestamoRepository tipoPrestamoRepository;

	@Autowired
	private NacionalidadRepository nacionalidadRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args)  {
		/* 
		System.out.println(puntosAtencionRepository.testConnection());
		*/
		
		Collection<PuntosAtencion> puntosAtencion = puntosAtencionRepository.darPuntosAtencion();
		Collection<EstadoPrestamo>  estadosPrestamos = estadoPrestamoRepository.darEstadosPrestamo();
		Collection<TipoUsuario>  tiposUsuarios = tipoUsuarioRepository.darTipoUsuarios();
		Collection<TipoDocumento>  tiposDocumentos = tipoDocumentoRepository.darTipoDocumentos();
		Collection<TipoCuenta>  tipoCuentas = tipoCuentaRepository.darTiposCuenta();
		Collection<EstadoCuenta>  estadoCuentas = estadoCuentaRepository.darEstadosCuenta();
		Collection<TipoOperacion>  tipoOperacions = tipoOperacionRepository.darTiposOperacion();
		Collection<TipoPrestamo>  tipoPrestamos = tipoPrestamoRepository.darTiposPrestamo();
		Collection<Nacionalidad>  nacionalidads = nacionalidadRepository.darNacionalidades();
		 
		/*
		for (PuntosAtencion e: puntosAtencion)
		{
			System.out.println(e.getNombre());
		}
		 */
		/* 
		for (EstadoPrestamo e: estadosPrestamos)
		{
			System.out.println(e.getEstadoPrestamo());
		}
		*/
		/*
		for (TipoUsuario e: tiposUsuarios)
		{
			System.out.println(e.getTipoUsuario());
		}
		*/
		/* 
		for (TipoDocumento e: tiposDocumentos)
		{
			System.out.println(e.getTipoDocumento());
		}
		*/
		/* 
		for (TipoCuenta e: tipoCuentas)
		{
			System.out.println(e.getTipoCuenta());
		}
		*/
		/* 
		for (EstadoCuenta e: estadoCuentas)
		{
			System.out.println(e.getEstadoCuenta());
		}
		*/
		/* 
		for (TipoOperacion e: tipoOperacions)
		{
			System.out.println(e.getTipoOperacion());
		}
		*/
		/* 
		for (TipoPrestamo e: tipoPrestamos)
		{
			System.out.println(e.getPrestamo());
		}
		*/
		/* 
		for (Nacionalidad e: nacionalidads)
		{
			System.out.println(e.getNombre());
		}
		 */
	}
}
