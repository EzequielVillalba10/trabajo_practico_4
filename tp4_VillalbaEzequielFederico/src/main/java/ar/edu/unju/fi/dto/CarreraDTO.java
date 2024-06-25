package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor 
@AllArgsConstructor
@Data 
@Component
public class CarreraDTO {
	private int codigo;
	private String nombre;
	private int cantidadAnios;
	private boolean estado;
}
