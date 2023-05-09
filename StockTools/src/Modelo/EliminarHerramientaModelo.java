package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class EliminarHerramientaModelo {
	
	public void eliminarHerramientaModelo(Herramienta herramienta) {
		
		int id_herramienta = herramienta.getId_herramienta();
		Connection conexion;
		
		try {
			
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktools", "root", "");
			Statement stmt = conexion.createStatement();
			
			String sql = "DELETE FROM herramienta WHERE id_herramienta = " + id_herramienta + ";";  
			stmt.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null,"Herramienta eliminada con exito");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al eliminar la herramienta \n asegurese de seleccionar solo una herramienta");
		}
		
	}

}
