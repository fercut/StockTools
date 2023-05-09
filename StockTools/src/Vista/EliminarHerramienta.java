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


public class EliminarHerramienta extends JFrame{
	
	private JPanel panel;
	private ObtenerHerramientas listaHerramientas = new ObtenerHerramientas();
	private List<Herramienta> herramientas = listaHerramientas.obtenerHerramientas();
	private Herramienta seleccionada = new Herramienta();
	
	public EliminarHerramienta() {
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
				setTitle("StockTools / Eliminar herramienta");
				setIconImage(Toolkit.getDefaultToolkit().getImage("./imagenes/icono.png"));
				getContentPane().setLayout(null);
				
				//Panel de insercion
				panel = new JPanel();
				panel.setLayout(null);
				panel.setOpaque(false);
				setContentPane(panel);
				
				//Componentes
				JLabel Tools = new JLabel("HERRAMIENTAS");
				Tools.setForeground(new Color(255, 255, 255));
				Tools.setHorizontalAlignment(SwingConstants.CENTER);
				Tools.setFont(new Font("Arial", Font.BOLD, 24));
				Tools.setBounds(390, 37, 193, 43);
				panel.add(Tools);
				
				JButton asignarHerramienta = new JButton("ELIMINAR HERRAMIENTA");
				asignarHerramienta.setVerticalTextPosition(SwingConstants.CENTER);
				asignarHerramienta.setHorizontalTextPosition(SwingConstants.CENTER);
				asignarHerramienta.setIcon(new ImageIcon("./imagenes/boton.png"));
				asignarHerramienta.setFont(new Font("Arial", Font.BOLD, 12));
				asignarHerramienta.setForeground(new Color(255, 255, 255));
				asignarHerramienta.setBounds(390, 421, 182, 43);
				panel.add(asignarHerramienta);
				
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
				checkTools.setBounds(302, 91, 363, 280);
				panel.add(checkTools);
				
				JLabel lblNewLabel = new JLabel("Por favor seleccione solo una herramienta");
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
				asignarHerramienta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						EliminarHerramientaControlador eliminar = new EliminarHerramientaControlador();
						eliminar.eliminarHerramientaControlador(seleccionada);
						dispose();
					}
				});
			
	}
}
