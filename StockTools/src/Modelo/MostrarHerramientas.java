package Modelo;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MostrarHerramientas {
	
	private Connection conexion;
	private String url = "jdbc:mysql://localhost:3306/stocktools";
	private String usuario = "root";
	private String contrasena = "";
	private Statement stmt;
	private ResultSet rs;
	
	public void MostrarHerramientas() {
		
		//Conectar a la base de datos 
	
        try {
			conexion = DriverManager.getConnection(url, usuario, contrasena);
			
			// Consoltar la lista de herramientas
			DatabaseMetaData mD = conexion.getMetaData();
            rs = mD.getCatalogs();
            stmt = conexion.createStatement();
            String sql = "SELECT * FROM Herramienta;";
            stmt.executeUpdate(sql);
		
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, "Ha ocurrido un error al conectar con la base de datos");
        	e.printStackTrace();
		}
        
       
	}

}
