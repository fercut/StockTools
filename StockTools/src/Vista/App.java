package Vista;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import Controlador.*;
import Modelo.*;

import java.awt.event.ActionEvent;

public class App extends JFrame{
	
	private JPanel panel;
	private JTable table;
	private JTable tableTools;
	
	public App() {
		
		setVisible(true);
		setResizable(false);
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize(); 
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setLocation(anchoPantalla/4, alturaPantalla/4);
		setSize(anchoPantalla/2, alturaPantalla/2);
		setDefaultCloseOperation(3);
		
		//Icono y nombre
		setTitle("StockTools");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagenes/icono.png"));
		getContentPane().setLayout(null);
		
		//Panel de insercion
		panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		setContentPane(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 944, 501);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton registerTools = new JButton("Herramientas");
		registerTools.setBounds(21, 11, 171, 30);
		panel_1.add(registerTools);
		registerTools.setIcon(new ImageIcon("./imagenes/boton.png"));
		registerTools.setVerticalTextPosition(SwingConstants.CENTER);
		registerTools.setHorizontalTextPosition(SwingConstants.CENTER);
		registerTools.setForeground(Color.WHITE);
		registerTools.setFont(new Font("Arial", Font.BOLD, 11));
		
		JButton workers = new JButton("Trabajadores");
		workers.setBounds(21, 339, 171, 30);
		panel_1.add(workers);
		workers.setIcon(new ImageIcon("./imagenes/boton.png"));
		workers.setVerticalTextPosition(SwingConstants.CENTER);
		workers.setHorizontalTextPosition(SwingConstants.CENTER);
		workers.setForeground(Color.WHITE);
		workers.setFont(new Font("Arial", Font.BOLD, 11));
		
		JButton newTools = new JButton("Nueva Herramienta");
		newTools.setBounds(21, 134, 171, 30);
		panel_1.add(newTools);
		newTools.setIcon(new ImageIcon("./imagenes/boton.png"));
		newTools.setVerticalTextPosition(SwingConstants.CENTER);
		newTools.setHorizontalTextPosition(SwingConstants.CENTER);
		newTools.setForeground(Color.WHITE);
		newTools.setFont(new Font("Arial", Font.BOLD, 11));
		
		//Botones y TextField		
		JButton newWorker = new JButton("Nuevo Trabajador");
		newWorker.setBounds(21, 380, 171, 30);
		panel_1.add(newWorker);
		newWorker.setIcon(new ImageIcon("./imagenes/boton.png"));
		newWorker.setVerticalTextPosition(SwingConstants.CENTER);
		newWorker.setHorizontalTextPosition(SwingConstants.CENTER);
		newWorker.setForeground(Color.WHITE);
		newWorker.setFont(new Font("Arial", Font.BOLD, 11));
		
		JButton assignTools =new JButton("Asignar Herramienta");
		assignTools.setBounds(21, 175, 171, 30);
		panel_1.add(assignTools);
		assignTools.setIcon(new ImageIcon("./imagenes/boton.png"));
		assignTools.setVerticalTextPosition(SwingConstants.CENTER);
		assignTools.setHorizontalTextPosition(SwingConstants.CENTER);
		assignTools.setForeground(Color.WHITE);
		assignTools.setFont(new Font("Arial", Font.BOLD, 11));
		
		JButton available = new JButton("Disponibles");
		available.setBounds(21, 52, 171, 30);
		panel_1.add(available);
		available.setIcon(new ImageIcon("./imagenes/boton.png"));
		available.setVerticalTextPosition(SwingConstants.CENTER);
		available.setHorizontalTextPosition(SwingConstants.CENTER);
		available.setForeground(Color.WHITE);
		available.setFont(new Font("Arial", Font.BOLD, 11));
		
		JButton assigned = new JButton("Asignadas");
		assigned.setBounds(21, 93, 171, 30);
		panel_1.add(assigned);
		assigned.setIcon(new ImageIcon("./imagenes/boton.png"));
		assigned.setVerticalTextPosition(SwingConstants.CENTER);
		assigned.setHorizontalTextPosition(SwingConstants.CENTER);
		assigned.setForeground(Color.WHITE);
		assigned.setFont(new Font("Arial", Font.BOLD, 11));
		
		JButton deleteTools = new JButton("Eliminar Herramienta");
		deleteTools.setBounds(21, 257, 171, 30);
		panel_1.add(deleteTools);
		deleteTools.setIcon(new ImageIcon("./imagenes/boton.png"));
		deleteTools.setVerticalTextPosition(SwingConstants.CENTER);
		deleteTools.setHorizontalTextPosition(SwingConstants.CENTER);
		deleteTools.setForeground(Color.WHITE);
		deleteTools.setFont(new Font("Arial", Font.BOLD, 11));
		
		JButton deleteWork = new JButton("Eliminar Trabajador");
		deleteWork.setBounds(21, 421, 171, 30);
		panel_1.add(deleteWork);
		deleteWork.setIcon(new ImageIcon("./imagenes/boton.png"));
		deleteWork.setVerticalTextPosition(SwingConstants.CENTER);
		deleteWork.setHorizontalTextPosition(SwingConstants.CENTER);
		deleteWork.setForeground(Color.WHITE);
		deleteWork.setFont(new Font("Arial", Font.BOLD, 11));
		
		JButton updateTool = new JButton("Modificar Herramienta");
		updateTool.setIcon(new ImageIcon("./imagenes/boton.png"));
		updateTool.setVerticalTextPosition(SwingConstants.CENTER);
		updateTool.setHorizontalTextPosition(SwingConstants.CENTER);
		updateTool.setForeground(Color.WHITE);
		updateTool.setFont(new Font("Arial", Font.BOLD, 11));
		updateTool.setBounds(21, 298, 171, 30);
		panel_1.add(updateTool);
		
		JButton updateWorker = new JButton("Modificar Trabajador");
		updateWorker.setIcon(new ImageIcon("./imagenes/boton.png"));
		updateWorker.setVerticalTextPosition(SwingConstants.CENTER);
		updateWorker.setHorizontalTextPosition(SwingConstants.CENTER);
		updateWorker.setForeground(Color.WHITE);
		updateWorker.setFont(new Font("Arial", Font.BOLD, 11));
		updateWorker.setBounds(21, 462, 171, 30);
		panel_1.add(updateWorker);
		
		JButton desassingTools = new JButton("Desasignar Herramienta");
		desassingTools.setIcon(new ImageIcon("./imagenes/boton.png"));
		desassingTools.setVerticalTextPosition(SwingConstants.CENTER);
		desassingTools.setHorizontalTextPosition(SwingConstants.CENTER);
		desassingTools.setForeground(Color.WHITE);
		desassingTools.setFont(new Font("Arial", Font.BOLD, 11));
		desassingTools.setBounds(21, 216, 171, 30);
		panel_1.add(desassingTools);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("./imagenes/fondo.jpg"));
		fondo.setBounds(0, 0, 944, 501);
		panel_1.add(fondo);
		
		//Acciones
		newTools.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevaHerramienta newTool = new NuevaHerramienta();
				newTools.setVisible(true);
				
			}
		});
		
		newWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoTrabajador newWork = new NuevoTrabajador();
				newWork.setVisible(true);
			}
		});
		
		//Asignar herramienta
		assignTools.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsignarHerramienta asigner = new AsignarHerramienta();
				asigner.setVisible(true);
			}
		});
		
		//Eliminar herramienta
		deleteTools.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarHerramienta deleteTools = new EliminarHerramienta();
				deleteTools.setVisible(true);
			}
		});
		
		//Eliminar trabajador
		deleteWork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarTrabajador deleteWorker = new EliminarTrabajador();
				deleteWorker.setVisible(true);
			}
		});
		
		//Modificar herramienta
		updateTool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarHerramienta modificar = new ModificarHerramienta();
				modificar.setVisible(true);
			}
		});
		
		//Modificar trabajador
		updateWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarTrabajador modificar = new ModificarTrabajador();
				modificar.setVisible(true);
				
			}
		});
		
		//Mostrar Tablas en la misma APP
		
			//Mostrar herramientas
			registerTools.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GeneraTablas vistaTools = new GeneraTablas();
					JTable table = vistaTools.tablaHerramienta();
					JScrollPane scrolTools = new JScrollPane(table);
					scrolTools.setBounds(241, 27, 659, 439);
					panel_1.add(scrolTools);
					
				}
			});
			
			//Mostrar trabajadores
			workers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GeneraTablas vistaWorkers = new GeneraTablas();
					JTable table  = vistaWorkers.tablaTrabajadores();
					JScrollPane scrolWorkers = new JScrollPane(table);
					scrolWorkers.setBounds(241, 27, 659, 439);
					panel_1.add(scrolWorkers);
				
				}
			});
			
			//Mostrar herramientas disponibles
			available.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GeneraTablas vistaDisponibles = new GeneraTablas();
					JTable table  = vistaDisponibles.tablaHerramientasDisponibles();
					JScrollPane scrolWorkers = new JScrollPane(table);
					scrolWorkers.setBounds(241, 27, 659, 439);
					panel_1.add(scrolWorkers);
				}
			});
			
			//Mostrar herramientas asignadas
			assigned.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GeneraTablas vistaAsignadas = new GeneraTablas();
					JTable table  = vistaAsignadas.tablaHerramientasAsignadas();
					JScrollPane scrolWorkers = new JScrollPane(table);
					scrolWorkers.setBounds(241, 27, 659, 439);
					panel_1.add(scrolWorkers);
				}
			});
			
			//Desasignar herramienta
			desassingTools.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					DesasignarHerramienta desasignar = new DesasignarHerramienta();
					desasignar.setVisible(true);
					
				}
			});
			
	}
}
