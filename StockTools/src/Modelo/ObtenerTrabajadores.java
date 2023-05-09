package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ObtenerTrabajadores {

	public List<Trabajador> obtenerTrabajadores() {
		
		List<Trabajador> trabajador = new ArrayList<>();
		
		try {
			//Conectamos
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktools", "root", "");
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM trabajador");
			
			while (rs.next()) {
				int id_trabajador = rs.getInt("id_trabajador");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido1");
				String categoria = rs.getString("Categoria");
				Trabajador worker = new Trabajador(id_trabajador, nombre, apellido, categoria);
				trabajador.add(worker);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trabajador;
	}
}
