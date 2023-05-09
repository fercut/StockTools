package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ModificarHerramientaModelo {
	
	public void modificarHerramientaModelo(Herramienta herramientaSeleccionada, Herramienta datosNuevos) {
		
		
		String nombre = datosNuevos.getNombre();
		String marca = datosNuevos.getMarca();
		String electrica = datosNuevos.getElectrica();
		int potencia = datosNuevos.getPotencia();
		double peso = datosNuevos.getPeso();
		String anotacion = datosNuevos.getAnotaciones();
		String imagen = datosNuevos.getRutaImagen();
		if(imagen.equals("")) {
			imagen=null;
		Connection conexion;
		
		try {
			
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktools", "root", "");
			Statement stmt = conexion.createStatement();
			
			String sql = "UPDATE herramienta SET nombre = '" + nombre + "', marca= '" + marca + "', electrica= '" + electrica + 
					"', potencia=" + potencia + ", peso=" + peso + ", anotaciones='" + anotacion + "', imagen='" + imagen + 
					"' WHERE id_herramienta=" + herramientaSeleccionada.getId_herramienta() + ";";  
			stmt.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null, "Herramienta modificada con exito");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al modificar la herramienta, asegurese de completar \n todos los campos del formulario y seleccionar solo una herramienta");
		}
	}

	}
}