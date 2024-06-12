package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

public class CollectionMateria {

	private static List<Materia> materias = new ArrayList<Materia>();
	
	
	/**
	 * devuelve un arrayList de objetos de la clase Materia
	 * @return
	 */
	public static List<Materia> getMaterias() {
		if (materias.isEmpty()) 
			{
				Docente docente = CollectionDocente.buscarDocente(123);
				Carrera carrera = CollectionCarrera.buscarCarrera(1);
				materias.add(new Materia(1, "Programacion Visual", "Segundo", 6, "Virtual", docente, carrera));
				
			}
			System.out.println(materias);
			return materias;
		}
	
	/**
	 * Agrega un objeto Materia al arraylist de materias
	 * @param docente
	 */
	
	public static boolean agregarMateria(Materia materia) {
		return materias.add(materia) ? true : false;
		
	}
	

	/**
	 * Elimina un objeto materia del arrayList de materias
	 * @param codigoMateria
	 */
	
	public static void eliminarMateria(int codigoMateria) {
		Iterator<Materia> iterator = materias.iterator();
		while (iterator.hasNext())
		{
			if (iterator.next().getCodigo()==codigoMateria)
			{
			iterator.remove();
			}
			}
	}
	
	
	/**
	 * Modifica un objeto docente con los nuevos valores enviado en 
	 * @param carrera objeto con los valores de atributos modificados!!!!!
	 */
	public static void modificarMateria(Materia materia) 
	{
		for(Materia mate : materias)
		{
			if (mate.getCodigo() == materia.getCodigo())
			{
				mate.setNombre(materia.getNombre());
				mate.setCurso(materia.getCurso());
				mate.setCantidadHoras(materia.getCantidadHoras());
				mate.setModalidad(materia.getModalidad());
				mate.setDocente(materia.getDocente());
				mate.setCarrera(materia.getCarrera());
			}
			else {
				System.out.println("No se encuentra el codigo de la materia");
			}
		}
	}
	

	/**
	 * Busca un objeto docente dentro del arrayList, el criterio es por
	 * @param el legajo a buscar en el arrayList docentes
	 * @return
	 */
	
	public static Materia buscarMateria(int codigo) {
		Predicate<Materia> filterCodigo = c -> c.getCodigo() == codigo;
		Optional<Materia> materia = materias.stream().filter(filterCodigo).findFirst();
		if (materia.isPresent())
		{
			return materia.get();
		} else {
			return null;
		}
	}
	
	
}
