package Modelo;

import java.sql.*;

import javax.swing.JOptionPane;

public class Creacion_BBDD {
    
    private Connection conexion;
    private Statement stmt;
    private String url = "jdbc:mysql://localhost:3306/";
    private String usuario = "root";
    private String contrasena = "";
    private ResultSet rs;
    private String nombreBBDD = "StockTools"; 
    
    public void crearBBDD() {
        
        try {
            
            // Conectamos con mysql local
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            JOptionPane.showMessageDialog(null, "Conectado correctamente a su BBDD");
            
            // Verificacion de BBDD
            DatabaseMetaData mD = conexion.getMetaData();
            rs = mD.getCatalogs();
            boolean existeBBDD = false;
            
            while (rs.next()) {
                String nombre = rs.getString(1);
                if (nombre.equalsIgnoreCase(nombreBBDD)) {
                    existeBBDD = true;
                    return;
                }
            }
            
            if (!existeBBDD) {
                // Crear BBDD si no existe
                stmt = conexion.createStatement();
                String sql = "CREATE DATABASE " + nombreBBDD;
                stmt.executeUpdate(sql);
                
                sql = "USE " + nombreBBDD;
                stmt.executeUpdate(sql);
                
                // Creamos la tabla trabajadores (principal)
                sql = "CREATE TABLE IF NOT EXISTS Trabajador " +
                      "(ID_TRABAJADOR INT AUTO_INCREMENT PRIMARY KEY, " +
                      "NOMBRE VARCHAR(20), " +
                      "APELLIDO1 VARCHAR(20), " +
                      "CATEGORIA VARCHAR(10))";
                stmt.executeUpdate(sql);
                
                // Creamos la tabla Herramientas
                sql = "CREATE TABLE IF NOT EXISTS Herramienta " +
                      "(ID_HERRAMIENTA INT AUTO_INCREMENT PRIMARY KEY, " +
                      "NOMBRE VARCHAR(20), " +
                      "MARCA VARCHAR(20), " +
                      "ELECTRICA VARCHAR(5), " +
                      "POTENCIA INT, " +
                      "PESO DOUBLE, " +
                      "ANOTACIONES VARCHAR(100), " +
                      "IMAGEN BLOB, " +
                      "ID_TRABAJADOR INT, " +
                      "FOREIGN KEY (ID_TRABAJADOR) " +
                      "REFERENCES Trabajador(ID_TRABAJADOR))";
                stmt.executeUpdate(sql); 
                
             // Conectar a la base de datos
                
                JOptionPane.showMessageDialog(null, "Se ha conctado por primera vez y se ha creado una BBDD \n para poder usar la aplicacion correctamente");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al conectar con la base de datos");
            e.printStackTrace();
        } finally {
            
            // Cerrar la conexion
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
    
}
