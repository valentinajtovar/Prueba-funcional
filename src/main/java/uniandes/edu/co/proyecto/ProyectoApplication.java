package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.EstadoPrestamo;
import uniandes.edu.co.proyecto.modelo.PuntosAtencion;
import uniandes.edu.co.proyecto.repositorio.EstadoPrestamoRepository;
import uniandes.edu.co.proyecto.repositorio.PuntosAtencionRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {
	@Autowired
	private PuntosAtencionRepository puntosAtencionRepository;

	@Autowired
	private EstadoPrestamoRepository estadoPrestamoRepository; 

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
		 /*
		for (PuntosAtencion e: puntosAtencion)
		{
			System.out.println("hola");
			System.out.println(e.getNombre());
		}
		 */
		System.out.println(estadosPrestamos);
		/* 
		for (EstadoPrestamo e: estadosPrestamos)
		{
			System.out.println("entro");
			System.out.println(e.getEstadoPrestamo());
		}
		*/
	}
}
