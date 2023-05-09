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


public class EliminarTrabajador extends JFrame{
	
	private JPanel panel;
	private ObtenerTrabajadores listaTrabajadores = new ObtenerTrabajadores();
	private List<Trabajador> trabajadores = listaTrabajadores.obtenerTrabajadores();
	private Trabajador seleccionado = new Trabajador();
	
	public EliminarTrabajador() {
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
				setTitle("StockTools / Eliminar trabajador");
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
				Workers.setHorizontalAlignment(SwingConstants.CENTER);
				Workers.setFont(new Font("Arial", Font.BOLD, 24));
				Workers.setBounds(390, 37, 193, 43);
				panel.add(Workers);
				
				JButton eliminarTrabajador = new JButton("ELIMINAR TRABAJADOR");
				eliminarTrabajador.setVerticalTextPosition(SwingConstants.CENTER);
				eliminarTrabajador.setHorizontalTextPosition(SwingConstants.CENTER);
				eliminarTrabajador.setIcon(new ImageIcon("./imagenes/boton.png"));
				eliminarTrabajador.setFont(new Font("Arial", Font.BOLD, 12));
				eliminarTrabajador.setForeground(new Color(255, 255, 255));
				eliminarTrabajador.setBounds(390, 421, 182, 43);
				panel.add(eliminarTrabajador);
				
				//Insercion de herramientas de forma dinamica
				JPanel checkTrabajadores = new JPanel();
				checkTrabajadores.setLayout(new BoxLayout (checkTrabajadores, BoxLayout.Y_AXIS));
				
				for(Trabajador trabajador : trabajadores) {
					
					JCheckBox checkBox = new JCheckBox(trabajador.getNombre() + " " + trabajador.getApellido1());
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
				checkWorkers.setBounds(302, 91, 363, 280);
				panel.add(checkWorkers);
				
				JLabel lblNewLabel = new JLabel("Por favor seleccione solo un trabajador");
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
				lblNewLabel.setBounds(302, 382, 363, 25);
				panel.add(lblNewLabel);
				
				JLabel fondo = new JLabel("");
				fondo.setIcon(new ImageIcon("./imagenes/fondo.jpg"));
				fondo.setBounds(0, 0, 944, 501);
				panel.add(fondo);
				
				//Acciones
				eliminarTrabajador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						EliminarTrabajadorControlador eliminar = new EliminarTrabajadorControlador();
						eliminar.eliminarTrabajadorControlador(seleccionado);
						dispose();
					}
				});
			
	}
}
