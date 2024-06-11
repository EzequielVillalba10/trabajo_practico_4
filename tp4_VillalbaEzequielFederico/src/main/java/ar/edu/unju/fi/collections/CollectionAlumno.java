package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;


@Component
public class CollectionAlumno {
private static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	/**
	 * Esto Devuelve un arraylist de objetos de la clase Alumno
	 * @return
	 */
	
	public static List<Alumno> getAlumnos(){
	if(alumnos.isEmpty()) {
		
		// Crear un objeto LocalDate con la fecha de nacimiento deseada
        LocalDate fechaNacimiento = LocalDate.of(2000, 5, 20);
        LocalDate fechaNacimiento2 = LocalDate.of(2004, 1, 26);
		LocalDate fechaNacimiento3 = LocalDate.of(1999, 4, 10);
		alumnos.add(new Alumno(43215661, "Martinez", "Gonzalo", "martinezgonzalo10RP@hotmail.com", 38812313, fechaNacimiento, "Velez Sarfield 309", 4401));
		alumnos.add(new Alumno(44611869, "Alario", "Lucas", "LucasAlario2014@hotmail.com", 38812349, fechaNacimiento2, "Av Italia 1902", 4450));
		alumnos.add(new Alumno(39598440, "Aymar", "Leandro", "LeanAymaZZZ@hotmail.com", 381948123, fechaNacimiento3, "Nueva nevada", 4652));
	}
	return alumnos;
	}
	
	
	
	/**
	 * Agrega un objeto Alumno al arraylist de alumnos
	 * @param carrera
	 */
	
	public static boolean agregarAlumno(Alumno alumno) {
		return alumnos.add(alumno) ? true : false;
		
	}
	
	/**
	 * Elimina un objeto alumno del arrayList de alumnos
	 * @param dniAlumno
	 */
	
	public static void eliminarAlumno(int dniAlumno) {
		Iterator<Alumno> iterator = alumnos.iterator();
		while (iterator.hasNext())
		{
			if (iterator.next().getDni()==dniAlumno)
			{
			iterator.remove();
			}
			}
	}
	
	/**
	 * Modifica un objeto alumno con los nuevos valores enviado en 
	 * @param alumno objeto con los valores de atributos modificados!!!!!
	 */
	public static void modificarAlumno(Alumno alumno) 
	{
		for(Alumno alum : alumnos)
		{
			if (alum.getDni() == alumno.getDni())
			{
				alum.setNombre(alum.getNombre());
				alum.setApellido(alum.getApellido());
				alum.setEmail(alum.getEmail());
				alum.setTelefono(alum.getTelefono());
				alum.setFechaDeNacimiento(alum.getFechaDeNacimiento());
				alum.setDomicilio(alum.getDomicilio());
				alum.setLU(alum.getLU());
			}
			else {
				System.out.println("No se encuentra el dni alumno");
			}
		}
	}
	
	
	/**
	 * Busca un objeto alumno dentro del arrayList, el criterio es por
	 * @param el dni a buscar en el arrayList alumnos
	 * @return
	 */
	
	public static Alumno buscarAlumno(int dni) {
		Predicate<Alumno> filterdni = c -> c.getDni() == dni;
		Optional<Alumno> alumno = alumnos.stream().filter(filterdni).findFirst();
		if (alumno.isPresent())
		{
			return alumno.get();
		} else {
			return null;
		}
	}
	
}
