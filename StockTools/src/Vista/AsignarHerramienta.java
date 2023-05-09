package Vista;

import java.awt.Dimension;
import Modelo.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import Controlador.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AsignarHerramienta extends JFrame {
	
	private JPanel panel;
	private ObtenerTrabajadores listaTrabajadores = new ObtenerTrabajadores();
	private ObtenerHerramientas listaHerramientas = new ObtenerHerramientas();
	private List<Trabajador> trabajadores = listaTrabajadores.obtenerTrabajadores();
	private List<Herramienta> herramientas = listaHerramientas.obtenerHerramientas();
	private Herramienta seleccionada = new Herramienta();
	private Trabajador seleccionado = new Trabajador();

	
	
	public AsignarHerramienta() {
		
		//Propiedades de la ventana
		setVisible(true);
		setResizable(false);
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize(); 
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setLocation(anchoPantalla/4, alturaPantalla/4);
		setSize(anchoPantalla/2, alturaPantalla/2);
		setDefaultCloseOperation(2);
		
		//Icono y nombre
		setTitle("StockTools / Asignar herramienta");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagenes/icono.png"));
		getContentPane().setLayout(null);
		
		//Panel de insercion
		panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		setContentPane(panel);
		
		//Componentes 
		JLabel Workers = new JLabel("TRABAJADORES");
		Workers.setForeground(new Color(255, 255, 255));
		Workers.setFont(new Font("Arial", Font.BOLD, 24));
		Workers.setHorizontalAlignment(SwingConstants.CENTER);
		Workers.setBounds(594, 35, 197, 43);
		panel.add(Workers);
		
		JLabel Tools = new JLabel("HERRAMIENTAS");
		Tools.setForeground(new Color(255, 255, 255));
		Tools.setHorizontalAlignment(SwingConstants.CENTER);
		Tools.setFont(new Font("Arial", Font.BOLD, 24));
		Tools.setBounds(150, 35, 193, 43);
		panel.add(Tools);
		
		JButton asignarHerramienta = new JButton("ASIGNAR HERRAMIENTA");
		asignarHerramienta.setVerticalTextPosition(SwingConstants.CENTER);
		asignarHerramienta.setHorizontalTextPosition(SwingConstants.CENTER);
		asignarHerramienta.setIcon(new ImageIcon("./imagenes/boton.png"));
		asignarHerramienta.setFont(new Font("Arial", Font.BOLD, 12));
		asignarHerramienta.setForeground(new Color(255, 255, 255));
		asignarHerramienta.setBounds(383, 447, 182, 43);
		panel.add(asignarHerramienta);
		
		
		
		//Insercion de trabajadores de forma dinamica
		JPanel checkTrabajadores = new JPanel();
		checkTrabajadores.setLayout(new BoxLayout (checkTrabajadores, BoxLayout.Y_AXIS));
		
		for(Trabajador trabajador : trabajadores) {
			
			JCheckBox checkBox = new JCheckBox(trabajador.getCategoria() + ", " + trabajador.getNombre() + " " + trabajador.getApellido1());
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (checkBox.isSelected()) {
						seleccionado = trabajador;
					}
				}
			});
			checkTrabajadores.add(checkBox);
			
		}
		JScrollPane checkWorkers = new JScrollPane(checkTrabajadores);
		checkWorkers.setBounds(516, 89, 363, 280);
		panel.add(checkWorkers);
		
		//Insercion de herramientas de forma dinamica
		JPanel checkHerramientas = new JPanel();
		checkHerramientas.setLayout(new BoxLayout (checkHerramientas, BoxLayout.Y_AXIS));
		
		for(Herramienta herramienta : herramientas) {
			
			JCheckBox checkBox = new JCheckBox(herramienta.getNombre() + " , " + herramienta.getMarca() + " y " + herramienta.getAnotaciones());
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(checkBox.isSelected()) {
						seleccionada = herramienta;
					}
				}
			});
			checkHerramientas.add(checkBox);
		}
		
		JScrollPane checkTools = new JScrollPane(checkHerramientas);
		checkTools.setBounds(59, 89, 363, 280);
		panel.add(checkTools);
		
		JLabel error = new JLabel("");
		error.setHorizontalAlignment(SwingConstants.CENTER);
		error.setBounds(60, 380, 819, 23);
		error.setForeground(new Color(255, 255, 255));
		panel.add(error);
		
		JLabel aviso = new JLabel("Por favor seleccione solo una opcion de cada tabla");
		aviso.setFont(new Font("Arial", Font.BOLD, 12));
		aviso.setForeground(new Color(255, 255, 255));
		aviso.setHorizontalAlignment(SwingConstants.CENTER);
		aviso.setBounds(59, 414, 819, 23);
		panel.add(aviso);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("./imagenes/fondo.jpg"));
		fondo.setBounds(0, 0, 944, 501);
		panel.add(fondo);
		
		//Acciones
		asignarHerramienta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AsignarControlador asignar = new AsignarControlador();
				
				if(seleccionado.getCategoria().equals("Tecnico") && seleccionada.getElectrica().equals("Si")) {
					error.setText("A un tecnico no se le puede asignar herramientas electricas");
				}else {
					asignar.asignarControlador(seleccionado, seleccionada);
					dispose();
				}
			}
		});
		
	}
	
}