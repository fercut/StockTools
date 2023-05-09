package Controlador;

import Modelo.*;

public class EliminarHerramientaControlador {
	
	public void eliminarHerramientaControlador(Herramienta herramienta) {
		
		EliminarHerramientaModelo eliminar = new EliminarHerramientaModelo(); 
		eliminar.eliminarHerramientaModelo(herramienta);
		
	}

}
