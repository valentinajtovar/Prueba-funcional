package uniandes.edu.co.proyecto;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {

	 

	public static void main(String[] args) 
	{
		SpringApplication.run(ProyectoApplication.class, args);
	}

	
	
	@Override
	public void run(String... args)  {

/**
		Integer idMaximo = usuarioRepository.encontrarIdMaximo()+1;
		usuarioRepository.crearUsuario(idMaximo,"CC",123456778,"pepe ruiz","Canadiense","unicentro","pepe@hotmail.com",3058155499L,67890,"CLIENTE NATURAL",13);
		
<<<<<<< HEAD
	 
		System.out.println("----------------------------------");
		System.out.println("error");
		System.out.println("----------------------------------");
=======
	 */
>>>>>>> 103500953955b29b6843a944031d113d0c4fefe5
		Collection<Prestamo> prestamos= prestamoRepository.darPrestamos();

		for (Prestamo u: prestamos)
		{
			System.out.println("------------------------");
			System.out.println(u.getValorCuota());
			System.out.println(u.getMonto());
			System.out.println("------------------------");
		}

/* 
		Collection<Cuenta> cuentas = cuentaRepository.darCuentas();
		System.out.println(cuentas);
		for (Cuenta u: cuentas)
		{
			System.out.println("------------------------");
			System.out.println(u.getIdCuenta());
			System.out.println(u.getEstadoCuenta().getEstadoCuenta());
			System.out.println("------------------------");
		}*/
 
/*
		Integer idPuntoAtencion = 0;
		Collection<PuntosAtencion> puntosAtencions = puntosAtencionRepository.darPuntosAtencion();
		/*puntosAtencionRepository.insertarPuntosAtencion("cajero sote", "PERSONALIZADA", "Calle Principal 123", "09:00", "15:00", 2);
		*/

/*		
		for (PuntosAtencion u: puntosAtencions)
		{	
			System.out.println("------------------------");
			System.out.println(u.getNombre());
			System.out.println(u.getIdPuntoAtencion());
			
			System.out.println("------------------------");
		}
		/*puntosAtencionRepository.eliminarPuntosAtencion(idPuntoAtencion);
		*//* 
		System.out.println(idPuntoAtencion);
		System.out.println("se elimino");
		*/
		
		/*

		Collection<Usuario> usuarios = usuarioRepository.darUsuarios();
		System.out.println(usuarios);
		for (Usuario u: usuarios)
		{
			System.out.println("------------------------");
			System.out.println(u.getNombre());
			System.out.println(u.getDireccionFisica());
			System.out.println(u.getNacionalidad());
			System.out.println(u.getNumeroDocumento());
			System.out.println("------------------------");
		}

		

*/

		/* 
		Collection<Usuario> usuarios = usuarioRepository.darUsuarios();
		System.out.println(usuarios);
		*/


 /*		
		Collection<Oficina> oficinas = oficinaRepository.darOficinas();
		System.out.println(oficinas);
		for (Oficina u: oficinas)
		{
			System.out.println("------------------------");
			System.out.println(u.getIdOficina());
			System.out.println(u.getNombre());
			System.out.println(u.getDireccion());
			System.out.println(u.getNumeroPuntosDisponibles());
			System.out.println("------------------------");
		}
  */
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
