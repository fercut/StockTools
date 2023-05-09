package Modelo;

import java.util.ArrayList;

public class Trabajador {
	
	
	private int id_trabajador;
	private String Nombre;
	private String Apellido1;
	private String Categoria;
	private ArrayList<Herramienta> herramientasAsignadas;
	public Trabajador(String nombre, String apellido1, String categoria) {
		Nombre = nombre;
		Apellido1 = apellido1;
		Categoria = categoria;
	}
	public Trabajador() {
		
	}
	
	public Trabajador(int id_trabajador, String nombre, String apellido1, String categoria) {
		this.id_trabajador = id_trabajador;
		Nombre = nombre;
		Apellido1 = apellido1;
		Categoria = categoria;
	}
	public int getId_trabajador() {
		return id_trabajador;
	}
	public void setId_trabajador(int id_trabajador) {
		this.id_trabajador = id_trabajador;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido1() {
		return Apellido1;
	}
	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public ArrayList<Herramienta> getHerramientasAsignadas() {
		return herramientasAsignadas;
	}
	public void setHerramientasAsignadas(ArrayList<Herramienta> herramientasAsignadas) {
		this.herramientasAsignadas = herramientasAsignadas;
	} 
	
	@Override
	public String toString() {
		return "Trabajador [id_trabajador=" + id_trabajador + ", Nombre=" + Nombre + ", Apellido1=" + Apellido1
				+ ", herramientasAsignadas=" + herramientasAsignadas + "]";
	}
}
