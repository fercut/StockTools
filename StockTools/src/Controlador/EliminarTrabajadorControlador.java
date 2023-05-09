package Controlador;

import Modelo.*;

public class EliminarTrabajadorControlador {
	
	public void eliminarTrabajadorControlador(Trabajador trabajador) {
		
		EliminarTrabajadorModelo eliminar = new EliminarTrabajadorModelo();
		eliminar.eliminarTrabajadorModelo(trabajador);
	}

}
