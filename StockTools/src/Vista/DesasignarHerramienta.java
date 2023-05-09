package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Modelo.*;
import Controlador.*;

public class DesasignarHerramienta extends JFrame{
	
	private JPanel panel;
	private ObtenerHerramientasAsignadas listaHerramientas = new ObtenerHerramientasAsignadas();
	private List<Herramienta> herramientas = listaHerramientas.obtenerHerramientasAsignadas();
	private Herramienta seleccionada = new Herramienta();
	
	public DesasignarHerramienta() {
	
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
	setTitle("StockTools / Desasignar herramienta");
	setIconImage(Toolkit.getDefaultToolkit().getImage("./imagenes/icono.png"));
	getContentPane().setLayout(null);
	
	//Panel de insercion
	panel = new JPanel();
	panel.setLayout(null);
	panel.setOpaque(false);
	setContentPane(panel);
	
	//Componentes
	JLabel Tools = new JLabel("HERRAMIENTAS ASIGNADAS");
	Tools.setForeground(new Color(255, 255, 255));
	Tools.setHorizontalAlignment(SwingConstants.CENTER);
	Tools.setFont(new Font("Arial", Font.BOLD, 24));
	Tools.setBounds(300, 35, 363, 43);
	panel.add(Tools);
	
	JButton desasignarHerramienta = new JButton("ASIGNAR HERRAMIENTA");
	desasignarHerramienta.setVerticalTextPosition(SwingConstants.CENTER);
	desasignarHerramienta.setHorizontalTextPosition(SwingConstants.CENTER);
	desasignarHerramienta.setIcon(new ImageIcon("./imagenes/boton.png"));
	desasignarHerramienta.setFont(new Font("Arial", Font.BOLD, 12));
	desasignarHerramienta.setForeground(new Color(255, 255, 255));
	desasignarHerramienta.setBounds(392, 425, 182, 43);
	panel.add(desasignarHerramienta);
	
	//Insercion de herramientas y trabajador que la tiene asignada de forma dinamica
			JPanel checkHerramientas = new JPanel();
			checkHerramientas.setLayout(new BoxLayout (checkHerramientas, BoxLayout.Y_AXIS));
			
			for(Herramienta herramienta : herramientas) {
				
				JCheckBox checkBox = new JCheckBox("Trabajador con identificador numero " + herramienta.getId_trabajador() +
						" dispone de la herramienta " + herramienta.getNombre() + " , " + herramienta.getMarca() + " y " +
						herramienta.getAnotaciones() );
				
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
			checkTools.setBounds(178, 89, 588, 280);
			panel.add(checkTools);
			
			JLabel lblNewLabel = new JLabel("Por favor seleccione solo una opcion");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(300, 387, 363, 27);
			panel.add(lblNewLabel);
			
			JLabel fondo = new JLabel("");
			fondo.setIcon(new ImageIcon("./imagenes/fondo.jpg"));
			fondo.setBounds(0, 0, 944, 501);
			panel.add(fondo);
		
		//Acciones
			desasignarHerramienta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DesasignarControlador desasignar = new DesasignarControlador();
					desasignar.desasignarControlador(seleccionada);
					dispose();
					
				}
			});
	}
}
