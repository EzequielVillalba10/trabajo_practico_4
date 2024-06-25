package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;

@Component
public class CollectionCarrera {
	
	private static List<Carrera> carreras = new ArrayList<Carrera>();
	
	/**
	 * Esto Devuelve un arraylist de objetos de la clase Carrera
	 * @return
	 */
	
	public static List<Carrera> getCarreras(){
	if(carreras.isEmpty()) {
		carreras.add(new Carrera(1, "A.P.U", 3, true));
		carreras.add(new Carrera(2,"Ingenieria Informatica",5,true));
		carreras.add(new Carrera(3, "Ingieneria Quimica", 7, false));
	
	}
	return carreras;
	}
	
	
	
	/**
	 * Agrega un objeto Carrera al arraylist de carreras
	 * @param carrera
	 */
	
	public static boolean agregarCarrera(Carrera carrera) {
		return carreras.add(carrera) ? true : false;
		
	}
	
	/**
	 * Elimina un objeto carrera del arrayList de carreras
	 * @param codigoCarrera
	 */
	
	public static void eliminarCarrera(int codigoCarrera) {
		Iterator<Carrera> iterator = carreras.iterator();
		while (iterator.hasNext())
		{
			if (iterator.next().getCodigo()==codigoCarrera)
			{
			iterator.remove();
			}
			}
	}
	
	/**
	 * Modifica un objeto carrera con los nuevos valores enviado en 
	 * @param carrera objeto con los valores de atributos modificados!!!!!
	 */
	public static void modificarCarrera(Carrera carrera) 
	{
		for(Carrera carre : carreras)
		{
			if (carre.getCodigo() == carrera.getCodigo())
			{
				carre.setNombre(carrera.getNombre());
				carre.setCantidadAnios(carrera.getCantidadAnios());
				carre.setEstado(carrera.getEstado());
			}
			else {
				System.out.println("No se encuentra el codigo carrera");
			}
		}
	}
	
	
	/**
	 * Busca un objeto carrera dentro del arrayList, el criterio es por
	 * @param codigo el codigo a buscar en el arrayList carrreras
	 * @return
	 */
	
	public static Carrera buscarCarrera(int codigo) {
		Predicate<Carrera> filterCodigo = c -> c.getCodigo() == codigo;
		Optional<Carrera> carrera = carreras.stream().filter(filterCodigo).findFirst();
		if (carrera.isPresent())
		{
			return carrera.get();
		} else {
			return null;
		}
	}
}
