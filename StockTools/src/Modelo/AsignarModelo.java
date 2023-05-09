package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AsignarModelo {

	public void asignarModelo(Trabajador trabajador, Herramienta herramienta) {
		
		int id_trabajador = trabajador.getId_trabajador();
		int id_herramienta = herramienta.getId_herramienta();
		Connection conexion;
		
		try {
			
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktools", "root", "");
			Statement stmt = conexion.createStatement();
			
			String sql = "UPDATE Herramienta SET ID_TRABAJADOR = " + id_trabajador + " WHERE ID_HERRAMIENTA = " + id_herramienta + ";";
			
			stmt.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null,"Herramienta asignada con exito a " + trabajador.getNombre());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al asignar la herramienta, asegurese \n de que solo selecciona una opcion de cada");
		}
		
	}
}
