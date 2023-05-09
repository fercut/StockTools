package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DesasignarModelo {
	
	public void desasignarModelo(Herramienta herramienta) {
		
		int id_herramienta = herramienta.getId_herramienta();
		
		Connection conexion;
		
		try {
			
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktools", "root", "");
			Statement stmt = conexion.createStatement();
			
			String sql = "UPDATE Herramienta SET ID_TRABAJADOR = NULL WHERE ID_HERRAMIENTA = " + id_herramienta + ";";
			
			stmt.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null,"Herramienta desasignada con exito");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al desasignar la herramienta \n asegurese de que solo selecciona una opcion");
		}
	}

}
