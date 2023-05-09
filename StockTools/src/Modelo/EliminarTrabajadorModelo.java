package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class EliminarTrabajadorModelo {

	public void eliminarTrabajadorModelo(Trabajador trabajador) {
		
		int id_trabajador = trabajador.getId_trabajador();
		Connection conexion;
		
		try {
			
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktools", "root", "");
			Statement stmt = conexion.createStatement();
			
			//Para poder eliminar un trabajador primero debemos quitarle las herramientas asignadas si las tubiera
			String sql = "UPDATE herramienta SET id_trabajador = NULL WHERE id_trabajador = " + id_trabajador + ";";
			stmt.executeUpdate(sql);
			
			//Elimina al trabajador sin herramientas asignadas
			sql = "DELETE FROM trabajador WHERE trabajador.id_trabajador = " + id_trabajador + ";";
			stmt.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null,"Trabajador eliminada con exito");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al eliminar el trabajador \n asegurese de seleccionar solo un trabajador");
		}
		
	}
}
