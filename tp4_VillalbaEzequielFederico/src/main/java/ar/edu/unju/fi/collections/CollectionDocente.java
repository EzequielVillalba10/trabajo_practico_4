package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;



@Component
public class CollectionDocente {

private static List<Docente> docentes = new ArrayList<Docente>();
	
	/**
	 * Esto Devuelve un arraylist de objetos de la clase Docente
	 * @return
	 */
	
	public static List<Docente> getDocentes(){
	if(docentes.isEmpty()) {
		docentes.add(new Docente(123, "Ariel", "Vega", "vegaariel@gmail.com", 38812312));
		docentes.add(new Docente(124, "Perez", "Marcelo", "perezgod123@gmail.com", 38812532));
		docentes.add(new Docente(125, "Liberatori", "Hector", "liberatorih@gmail.com", 388144302));
	}
	return docentes;
	}
	
	
	
	/**
	 * Agrega un objeto Docente al arraylist de docentes
	 * @param docente
	 */
	
	public static boolean agregarDocente(Docente docente) {
		return docentes.add(docente) ? true : false;
		
	}
	
	/**
	 * Elimina un objeto docente del arrayList de docente
	 * @param legajoDocente
	 */
	
	public static void eliminarDocente(int legajoDocente) {
		Iterator<Docente> iterator = docentes.iterator();
		while (iterator.hasNext())
		{
			if (iterator.next().getLegajo()==legajoDocente)
			{
			iterator.remove();
			}
			}
	}
	
	/**
	 * Modifica un objeto docente con los nuevos valores enviado en 
	 * @param carrera objeto con los valores de atributos modificados!!!!!
	 */
	public static void modificarDOcente(Docente docente) 
	{
		for(Docente doce : docentes)
		{
			if (doce.getLegajo() == docente.getLegajo())
			{
				doce.setNombre(docente.getNombre());
				doce.setApellido(docente.getApellido());
				doce.setEmail(docente.getEmail());
				doce.setTelefono(docente.getTelefono());
			}
			else {
				System.out.println("No se encuentra el legajo de docente");
			}
		}
	}
	
	
	/**
	 * Busca un objeto docente dentro del arrayList, el criterio es por
	 * @param el legajo a buscar en el arrayList docentes
	 * @return
	 */
	
	public static Docente buscarDocente(int legajo) {
		Predicate<Docente> filterLegajo = c -> c.getLegajo() == legajo;
		Optional<Docente> docente = docentes.stream().filter(filterLegajo).findFirst();
		if (docente.isPresent())
		{
			
			return docente.get();
			
		} else {
			
			return null;
			
		}
	}
	
}
