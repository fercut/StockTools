package Vista;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import Controlador.ListarHerramienta;

import java.awt.event.ActionEvent;

public class App extends JFrame{
	
	private JPanel panel;
	
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
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(257, 32, 632, 427);
		panel_1.add(panel_2);
		
		JButton registerTools = new JButton("Herramientas");
		registerTools.setBounds(21, 27, 171, 30);
		panel_1.add(registerTools);
		registerTools.setIcon(new ImageIcon("./imagenes/boton.png"));
		registerTools.setVerticalTextPosition(SwingConstants.CENTER);
		registerTools.setHorizontalTextPosition(SwingConstants.CENTER);
		registerTools.setForeground(Color.WHITE);
		registerTools.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton workers = new JButton("Trabajadores");
		workers.setBounds(21, 68, 171, 30);
		panel_1.add(workers);
		workers.setIcon(new ImageIcon("./imagenes/boton.png"));
		workers.setVerticalTextPosition(SwingConstants.CENTER);
		workers.setHorizontalTextPosition(SwingConstants.CENTER);
		workers.setForeground(Color.WHITE);
		workers.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton newTools = new JButton("Nueva Herramienta");
		newTools.setBounds(21, 109, 171, 30);
		panel_1.add(newTools);
		newTools.setIcon(new ImageIcon("./imagenes/boton.png"));
		newTools.setVerticalTextPosition(SwingConstants.CENTER);
		newTools.setHorizontalTextPosition(SwingConstants.CENTER);
		newTools.setForeground(Color.WHITE);
		newTools.setFont(new Font("Arial", Font.BOLD, 12));
		
		//Botones y TextField		
		JButton newWorker = new JButton("Nuevo Trabajador");
		newWorker.setBounds(21, 150, 171, 30);
		panel_1.add(newWorker);
		newWorker.setIcon(new ImageIcon("./imagenes/boton.png"));
		newWorker.setVerticalTextPosition(SwingConstants.CENTER);
		newWorker.setHorizontalTextPosition(SwingConstants.CENTER);
		newWorker.setForeground(Color.WHITE);
		newWorker.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton assignTools =new JButton("Asignar Herramienta");
		assignTools.setBounds(21, 191, 171, 30);
		panel_1.add(assignTools);
		assignTools.setIcon(new ImageIcon("./imagenes/boton.png"));
		assignTools.setVerticalTextPosition(SwingConstants.CENTER);
		assignTools.setHorizontalTextPosition(SwingConstants.CENTER);
		assignTools.setForeground(Color.WHITE);
		assignTools.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton available = new JButton("Disponibles");
		available.setBounds(21, 232, 171, 30);
		panel_1.add(available);
		available.setIcon(new ImageIcon("./imagenes/boton.png"));
		available.setVerticalTextPosition(SwingConstants.CENTER);
		available.setHorizontalTextPosition(SwingConstants.CENTER);
		available.setForeground(Color.WHITE);
		available.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton assigned = new JButton("Asignadas");
		assigned.setBounds(21, 273, 171, 30);
		panel_1.add(assigned);
		assigned.setIcon(new ImageIcon("./imagenes/boton.png"));
		assigned.setVerticalTextPosition(SwingConstants.CENTER);
		assigned.setHorizontalTextPosition(SwingConstants.CENTER);
		assigned.setForeground(Color.WHITE);
		assigned.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton deleteTools = new JButton("Eliminar Herramienta");
		deleteTools.setBounds(21, 314, 171, 30);
		panel_1.add(deleteTools);
		deleteTools.setIcon(new ImageIcon("./imagenes/boton.png"));
		deleteTools.setVerticalTextPosition(SwingConstants.CENTER);
		deleteTools.setHorizontalTextPosition(SwingConstants.CENTER);
		deleteTools.setForeground(Color.WHITE);
		deleteTools.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton deleteWork = new JButton("Eliminar Trabajador");
		deleteWork.setBounds(21, 355, 171, 30);
		panel_1.add(deleteWork);
		deleteWork.setIcon(new ImageIcon("./imagenes/boton.png"));
		deleteWork.setVerticalTextPosition(SwingConstants.CENTER);
		deleteWork.setHorizontalTextPosition(SwingConstants.CENTER);
		deleteWork.setForeground(Color.WHITE);
		deleteWork.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton updateTool = new JButton("Modificar Herramienta");
		updateTool.setIcon(new ImageIcon("./imagenes/boton.png"));
		updateTool.setVerticalTextPosition(SwingConstants.CENTER);
		updateTool.setHorizontalTextPosition(SwingConstants.CENTER);
		updateTool.setForeground(Color.WHITE);
		updateTool.setFont(new Font("Arial", Font.BOLD, 12));
		updateTool.setBounds(21, 396, 171, 30);
		panel_1.add(updateTool);
		
		JButton updateWorker = new JButton("Modificar Trabajador");
		updateWorker.setIcon(new ImageIcon("./imagenes/boton.png"));
		updateWorker.setVerticalTextPosition(SwingConstants.CENTER);
		updateWorker.setHorizontalTextPosition(SwingConstants.CENTER);
		updateWorker.setForeground(Color.WHITE);
		updateWorker.setFont(new Font("Arial", Font.BOLD, 12));
		updateWorker.setBounds(21, 437, 171, 30);
		panel_1.add(updateWorker);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./imagenes/fondo.jpg"));
		lblNewLabel.setBounds(0, 2, 944, 499);
		panel_1.add(lblNewLabel);
		
		
		//Acciones
		newTools.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarHerramienta nueva = new ListarHerramienta();
				nueva.viewNewTools();
			}
		});
		
		newWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoTrabajador newWork = new NuevoTrabajador();
				newWork.setVisible(true);
			}
		});
		
	}
}
