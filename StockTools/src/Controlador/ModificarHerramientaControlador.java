package Controlador;

import Modelo.*;
import Vista.*;

public class ModificarHerramientaControlador {
	
	public void modificarHerramientaControlador(Herramienta herramientaSeleccionada, Herramienta datosNuevos) {
		
		ModificarHerramientaModelo modificar = new ModificarHerramientaModelo();
		modificar.modificarHerramientaModelo(herramientaSeleccionada, datosNuevos);
		
	}

}
