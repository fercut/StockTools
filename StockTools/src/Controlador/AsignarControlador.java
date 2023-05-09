package Controlador;

import Modelo.*;
import Vista.*;

public class AsignarControlador {
	
	AsignarModelo asignar = new AsignarModelo();
	
	public void asignarControlador(Trabajador trabajador, Herramienta herramienta) {
		
		asignar.asignarModelo(trabajador, herramienta);
	}

}
