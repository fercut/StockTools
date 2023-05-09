package Controlador;

import Modelo.*;

public class ModificarTrabajadorControlador {
	
	public void modificarTrabajadorControlador(Trabajador seleccionado, Trabajador datosNuevos) {
		
		ModificarTrabajadorModelo modificar = new ModificarTrabajadorModelo();
		modificar.modificarTrabajadorModelo(seleccionado, datosNuevos);
	}

}
