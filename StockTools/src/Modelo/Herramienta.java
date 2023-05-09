package Modelo;

public class Herramienta {
	
	private int id_herramienta;
	private String Nombre;
	private String Electrica;
	private String Marca;
	private double Peso; 
	private int potencia;
	private String anotaciones;
	private String rutaImagen;
	private int id_trabajador;
	
	public Herramienta( String nombre, String marca, String electrica, int potencia, double peso, String annotation, String rutaImagen) {
		Nombre = nombre;
		Marca = marca;
		Electrica = electrica;
		this.potencia = potencia;
		Peso = peso;
		this.anotaciones = annotation;
		this.rutaImagen = rutaImagen;
	}
	//Constructor para modificar herramienta
	public Herramienta(int id_herramienta, String nombre, String marca,  String electrica, int potencia, double peso,
			String anotaciones, String rutaImagen, int id_trabajador) {
		this.id_herramienta = id_herramienta;
		Nombre = nombre;
		Electrica = electrica;
		Marca = marca;
		Peso = peso;
		this.potencia = potencia;
		this.anotaciones = anotaciones;
		this.rutaImagen = rutaImagen;
		if(id_trabajador == 0) {
			this.id_trabajador=0;
		}else {
			this.id_trabajador = id_trabajador;
		}
	}

	public Herramienta( String nombre, String marca, String electrica, double peso, String rutaImagen) {
		Nombre = nombre;
		Marca = marca;
		Electrica = electrica;
		this.potencia = 0;
		Peso = peso;
		this.anotaciones = "";
		this.rutaImagen = rutaImagen;
	}
	//Constructor para la asignacion de herramientas
	public Herramienta(int id_herramienta, String nombre, String marca, String electrica, String anotaciones, int id_trabajador) {
		this.id_herramienta = id_herramienta;
		Nombre = nombre;
		Marca = marca;
		this.Electrica = electrica;
		this.anotaciones = anotaciones;
		this.id_trabajador = id_trabajador;
	}
	
	public Herramienta() {
		
	}
	
	public int getId_trabajador() {
		return id_trabajador;
	}
	public void setId_trabajador(int id_trabajador) {
		this.id_trabajador = id_trabajador;
	}
	public int getId_herramienta() {
		return id_herramienta;
	}
	public void setId_herramienta(int id_herramienta) {
		this.id_herramienta = id_herramienta;
	}
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getElectrica() {
		return Electrica;
	}

	public void setElectrica(String electrica) {
		Electrica = electrica;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public double getPeso() {
		return Peso;
	}

	public void setPeso(double peso) {
		Peso = peso;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public String getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	@Override
	public String toString() {
		return "Herramineta [Nombre=" + Nombre + ", Electrica=" + Electrica + ", Marca=" + Marca + ", Peso=" + Peso
				+ ", potencia=" + potencia + ", anotaciones=" + anotaciones + ", rutaImagen=" + rutaImagen + "]";
	}
	
	
}
