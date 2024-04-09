package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.PuntosAtencion;
import uniandes.edu.co.proyecto.repositorio.PuntosAtencionRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {
	@Autowired
	private PuntosAtencionRepository puntosAtencionRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args)  {
		/* 
		System.out.println(puntosAtencionRepository.testConnection());
		*/
		
		Collection<PuntosAtencion> puntosAtencion = puntosAtencionRepository.darPuntosAtencion();
		for (PuntosAtencion u: puntosAtencion)
		{
			System.out.println(u.getNombre());
			System.out.println(u.getTipo());
			System.out.println(u.getIdPuntosAtencion());
		}
		

		

	}
}
