package Controlador;

import Modelo.*;

public class DesasignarControlador {
	
	DesasignarModelo desasignar = new DesasignarModelo();
	
	public void desasignarControlador(Herramienta herramienta) {
		
		desasignar.desasignarModelo(herramienta);
	}
}
