package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class NuevoTrabajadorModelo {
	
	public void nuevoTrabajadorModelo(Trabajador trabajador) {
		
		String nombre = trabajador.getNombre();
		String apellido = trabajador.getApellido1();
		String categoria = trabajador.getCategoria();
		Connection conexion;
		
		try {
			
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktools", "root", "");
			Statement stmt = conexion.createStatement();
			
			String sql = "INSERT INTO TRABAJADOR (ID_TRABAJADOR, NOMBRE, APELLIDO1, CATEGORIA)" +
					     "VALUES (NULL, '" + nombre + "', '" + apellido + "', '" + categoria +"')";
			
			stmt.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null,"Nuevo trabajador añadido con exito");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al agregar a un nuevo trabajador \n asegurese de rellenar todos los campos");
		}
		
	}

}
