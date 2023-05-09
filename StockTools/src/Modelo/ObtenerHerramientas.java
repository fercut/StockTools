package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ObtenerHerramientas {

	public List<Herramienta> obtenerHerramientas() {
		
		List<Herramienta> herramientas = new ArrayList<>();
		
		try {
			//Conectamos
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktools", "root", "");
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM herramienta WHERE ID_TRABAJADOR IS NULL");
			
			while (rs.next()) {
				int id_herramienta = rs.getInt("id_herramienta");
				String nombre = rs.getString("nombre");
				String marca = rs.getString("marca");
				String anotacion = rs.getString("anotaciones");
				String electrica = rs.getString("electrica");
				int id_trabajador = rs.getInt("id_trabajador");
				Herramienta herramienta = new Herramienta(id_herramienta, nombre, marca, electrica, anotacion, id_trabajador);
				herramientas.add(herramienta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return herramientas;
	}
}
