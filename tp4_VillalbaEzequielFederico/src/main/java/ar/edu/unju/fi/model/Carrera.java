package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Carrera {
	private int codigo;
	private String nombre;
	private int cantidadAños;
	private boolean estado;
	
	
	
	public Carrera() {
		// TODO Auto-generated constructor stub
	}


	public Carrera(int codigo, String nombre, int cantidadAños, boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadAños = cantidadAños;
		this.estado = estado;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCantidadAños() {
		return cantidadAños;
	}


	public void setCantidadAños(int cantidadAños) {
		this.cantidadAños = cantidadAños;
	}


	public boolean getEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
}
