package uniandes.edu.co.proyecto;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.repositorio.TiposPuntosAtencionRepository;
import uniandes.edu.co.proyecto.modelo.Oficina;
/*
import uniandes.edu.co.proyecto.repositorio.PuntosAtencionRepository;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.modelo.PuntosAtencion;
*/
import uniandes.edu.co.proyecto.modelo.TiposPuntosAtencion;


@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {
	/*@Autowired
	private PuntosAtencionRepository puntosAtencionRepository;
	*/
	@Autowired
	private OficinaRepository oficinaRepository; 

	@Autowired
	private TiposPuntosAtencionRepository tiposPuntosAtencionRepository;
	 

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args)  {
		
		
		
		Collection<Oficina> oficinas = oficinaRepository.darOficinas();
		System.out.println(oficinas);
		for (Oficina u: oficinas)
		{
			System.out.println("------------------------");
			System.out.println(u.getIdOficina());
			System.out.println(u.getNombre());
			System.out.println(u.getLocacion());
			System.out.println(u.getGerente());
			System.out.println("------------------------");
		}
		
/*
		System.out.println("HOLAAA");
		Optional<Oficina> buscarOficina = oficinaRepository.buscarOficinaPorId(2);
		if (buscarOficina.isPresent()) {
			System.out.println(buscarOficina.get().getNombre());
		} else {
			System.out.println("La oficina no fue encontrada.");
		}

		oficinaRepository.actualizarOficina(2, "OFICINA update","LOCACION MOD", 2);
		//oficinaRepository.insertarOficina("nuevaof","locacion 4", 2);

		Collection<Oficina> oficinas1 = oficinaRepository.darOficinas();
		for (Oficina u: oficinas1)
		{
			System.out.println(u.getIdOficina());
			System.out.println(u.getNombre());
			
		}
		oficinaRepository.eliminarOficina(4);

		Collection<Oficina> oficinas2 = oficinaRepository.darOficinas();
		for (Oficina u: oficinas2)
		{
			System.out.println(u.getIdOficina());
			System.out.println(u.getNombre());
			
		}
		*/
		



		/* FUNCIONAL DE TIPOS PUNTOS ATENCION
		Collection<TiposPuntosAtencion> puntosAtencion = tiposPuntosAtencionRepository.darTiposPuntosAtencion();
		for (TiposPuntosAtencion u: puntosAtencion)
		{
			System.out.println(u.getNombre());
			
		}

		System.out.println("HOLAAA");
		Optional<TiposPuntosAtencion> uno = tiposPuntosAtencionRepository.darTipoPuntosAtencion(4);
		if (uno.isPresent()) {
			System.out.println(uno.get().getNombre());
		} else {
			System.out.println("El TiposPuntosAtencion no fue encontrado.");
		}
		
		System.out.println("HOLAAA");

		tiposPuntosAtencionRepository.actualizarTiposPuntosAtencion(4, "nuevo update");
		
		
		for (TiposPuntosAtencion u: puntosAtencion)
		{
			System.out.println(u.getNombre());
			
		}
		tiposPuntosAtencionRepository.eliminarTiposPuntosAtencion(4);

		for (TiposPuntosAtencion u: puntosAtencion)
		{
			System.out.println(u.getNombre());
			
		}
		*/
	

	}
}
