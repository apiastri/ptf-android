package com.example.polideportivo;

/**
 * Esta clase representa a cada Deporte de la logica
 */
public class Deporte {

	private int codigo;
	private String nombre;
	private String descripcion;
	private String nombreImagen;

	public Deporte(int codigo, String nombre, String descripcion, String nombreImagen) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nombreImagen = nombreImagen;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getNombreImagen() {
		return nombreImagen;
	}
}
