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
	
	public Herramienta( String nombre, String marca, String electrica, int potencia, double peso, String annotation, String rutaImagen) {
		Nombre = nombre;
		Marca = marca;
		Electrica = electrica;
		this.potencia = potencia;
		Peso = peso;
		this.anotaciones = annotation;
		this.rutaImagen = rutaImagen;
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
