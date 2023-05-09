package Modelo;

import Vista.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Controlador.*;

public class NuevaHerramientaModelo {
		
	
	
	public void nuevaHerramientaModelo(Herramienta herramienta) {

		String nombre = herramienta.getNombre();
		String marca = herramienta.getMarca();
		String electrica = herramienta.getElectrica();
		int potencia = herramienta.getPotencia();
		double peso = herramienta.getPeso();
		String anotacion = herramienta.getAnotaciones();
		String imagen = herramienta.getRutaImagen();
		Connection conexion;
		
		try {
			
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktools", "root", "");
			Statement stmt = conexion.createStatement();
			
			String sql = "INSERT INTO Herramienta (NOMBRE, MARCA, ELECTRICA, POTENCIA, PESO, ANOTACIONES, IMAGEN, ID_TRABAJADOR)" +
					     "VALUES ('" + nombre + "', '" + marca + "', '" + electrica + "', " + potencia + ", " + peso + ", '" + 
					     anotacion + "', cargar_imagen('" + imagen + "'), null)";
			
			stmt.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null,"Nueva herramienta añadida con exito");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al inventariar una herramienta \n compruebe que los campos esten rellenos correctamente");
		}
        
	}


}
