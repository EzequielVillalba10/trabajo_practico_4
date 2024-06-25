package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class MateriaDTO {
	private int codigo;
	private String nombre;
	private String curso;
	private int cantidadHoras;
	private String modalidad;
	private Docente docente;
	private Carrera carrera;
	
}
