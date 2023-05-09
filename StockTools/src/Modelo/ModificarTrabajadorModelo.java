package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ModificarTrabajadorModelo {
	
	public void modificarTrabajadorModelo(Trabajador seleccionado, Trabajador datosNuevos) {
		
		String nombre = datosNuevos.getNombre();
		String apellido = datosNuevos.getApellido1();
		String categoria = datosNuevos.getCategoria();
		Connection conexion;
		
		try {
			
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktools", "root", "");
			Statement stmt = conexion.createStatement();
			
			String sql = "UPDATE trabajador SET nombre = '" + nombre + "', apellido1= '" + apellido + "', categoria= '" + categoria + 
					"' WHERE id_trabajador=" + seleccionado.getId_trabajador() + ";";  
			stmt.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null,"Trabajador con id: " + seleccionado.getId_trabajador() + " modificado con exito");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al modificar el trabajador, asegurese de \n rellenar bien todos los campos y seleccionar un solo trabajador");
		}
	}

}
