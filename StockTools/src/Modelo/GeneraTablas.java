package Modelo;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class GeneraTablas {
	
	//########################################## 	GENERA TABLA DE VISTA DE HERRAMIENTAS	##########################################
	public JTable tablaHerramienta() {
		
		JTable tools = new JTable();
		DefaultTableModel model = new DefaultTableModel();
	  try {
          // Conectar a la base de datos
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktools", "root", "");
          Statement stmt = conn.createStatement();
          
          // Ejecutar una consulta para obtener un ResultSet
          ResultSet rs = stmt.executeQuery("SELECT * FROM herramienta;");
          
          // Obtener los metadatos del ResultSet
          ResultSetMetaData metaData = rs.getMetaData();
          
          // Crear un array para almacenar los nombres de las columnas
          int columnCount = metaData.getColumnCount();
          String[] columnNames = new String[columnCount];
          for (int i = 0; i < columnCount; i++) {
              columnNames[i] = metaData.getColumnName(i + 1);
          }
          
          // Crear un DefaultTableModel con los datos del ResultSet
          model = new DefaultTableModel(columnNames, 0);
          while (rs.next()) {
              Object[] rowData = new Object[columnCount];
              for (int i = 0; i < columnCount; i++) {
                  rowData[i] = rs.getObject(i + 1);
              }
              model.addRow(rowData);
          }
      } catch (SQLException ex) {
          ex.printStackTrace();
      }
	  return tools = new JTable(model);
	}
	
	//########################################## 	GENERA TABLA DE VISTA DE TRABAJADORES	##########################################
	
	public JTable tablaTrabajadores() {
		
		JTable tools = new JTable();
		DefaultTableModel model = new DefaultTableModel();
	  try {
          // Conectar a la base de datos
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktools", "root", "");
          Statement stmt = conn.createStatement();
          
          // Ejecutar una consulta para obtener un ResultSet
          ResultSet rs = stmt.executeQuery("SELECT * FROM trabajador;");
          
          // Obtener los metadatos del ResultSet
          ResultSetMetaData metaData = rs.getMetaData();
          
          // Crear un array para almacenar los nombres de las columnas
          int columnCount = metaData.getColumnCount();
          String[] columnNames = new String[columnCount];
          for (int i = 0; i < columnCount; i++) {
              columnNames[i] = metaData.getColumnName(i + 1);
          }
          
          // Crear un DefaultTableModel con los datos del ResultSet
          model = new DefaultTableModel(columnNames, 0);
          while (rs.next()) {
              Object[] rowData = new Object[columnCount];
              for (int i = 0; i < columnCount; i++) {
                  rowData[i] = rs.getObject(i + 1);
              }
              model.addRow(rowData);
          }
      } catch (SQLException ex) {
          ex.printStackTrace();
      }
	  return tools = new JTable(model);
	}
	
	//########################################## 	GENERA TABLA DE VISTA DE HERRAMIENTAS DISPONIBLES	##########################################
	
	public JTable tablaHerramientasDisponibles() {
		
		JTable tools = new JTable();
		DefaultTableModel model = new DefaultTableModel();
	  try {
          // Conectar a la base de datos
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktools", "root", "");
          Statement stmt = conn.createStatement();
          
          // Ejecutar una consulta para obtener un ResultSet
          ResultSet rs = stmt.executeQuery("SELECT id_herramienta, nombre, marca, electrica, peso FROM herramienta WHERE id_trabajador IS NULL;");
          
          // Obtener los metadatos del ResultSet
          ResultSetMetaData metaData = rs.getMetaData();
          
          // Crear un array para almacenar los nombres de las columnas
          int columnCount = metaData.getColumnCount();
          String[] columnNames = new String[columnCount];
          for (int i = 0; i < columnCount; i++) {
              columnNames[i] = metaData.getColumnName(i + 1);
          }
          
          // Crear un DefaultTableModel con los datos del ResultSet
          model = new DefaultTableModel(columnNames, 0);
          while (rs.next()) {
              Object[] rowData = new Object[columnCount];
              for (int i = 0; i < columnCount; i++) {
                  rowData[i] = rs.getObject(i + 1);
              }
              model.addRow(rowData);
          }
      } catch (SQLException ex) {
          ex.printStackTrace();
      }
	  return tools = new JTable(model);
	}

	//########################################## 	GENERA TABLA DE VISTA DE HERRAMIENTAS ASIGNADAS	##########################################
	
	public JTable tablaHerramientasAsignadas() {
		
		JTable tools = new JTable();
		DefaultTableModel model = new DefaultTableModel();
	  try {
          // Conectar a la base de datos
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktools", "root", "");
          Statement stmt = conn.createStatement();
          
          // Ejecutar una consulta para obtener un ResultSet
          ResultSet rs = stmt.executeQuery("SELECT Herramienta.ID_HERRAMIENTA, Herramienta.NOMBRE, Herramienta.MARCA, Trabajador.NOMBRE, Trabajador.APELLIDO1 FROM Trabajador INNER JOIN herramienta ON trabajador.ID_TRABAJADOR = herramienta.ID_TRABAJADOR WHERE herramienta.id_trabajador IS NOT NULL;");
          
          // Obtener los metadatos del ResultSet
          ResultSetMetaData metaData = rs.getMetaData();
          
          // Crear un array para almacenar los nombres de las columnas
          int columnCount = metaData.getColumnCount();
          String[] columnNames = new String[columnCount];
          for (int i = 0; i < columnCount; i++) {
              columnNames[i] = metaData.getColumnName(i + 1);
          }
          
          // Crear un DefaultTableModel con los datos del ResultSet
          model = new DefaultTableModel(columnNames, 0);
          while (rs.next()) {
              Object[] rowData = new Object[columnCount];
              for (int i = 0; i < columnCount; i++) {
                  rowData[i] = rs.getObject(i + 1);
              }
              model.addRow(rowData);
          }
      } catch (SQLException ex) {
          ex.printStackTrace();
      }
	  return tools = new JTable(model);
	}
}
