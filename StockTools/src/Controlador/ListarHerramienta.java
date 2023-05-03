package Controlador;

import Vista.*;

import javax.swing.JOptionPane;

import Modelo.*;

public class ListarHerramienta {
	
	
	
	public void viewNewTools() {
		NuevaHerramienta herramienta = new NuevaHerramienta();
		herramienta.setVisible(true);
		
	}
	
	public void ComprobarCampos() {
		NuevaHerramienta herramienta = new NuevaHerramienta();
		Herramienta nueva = herramienta.InsertTools();
		
		
		
		
		herramienta.repaint();
		herramienta.revalidate(); 
		
		
	}
	
}