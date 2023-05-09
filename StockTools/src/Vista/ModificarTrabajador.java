package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Modelo.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import Controlador.*;

public class ModificarTrabajador extends JFrame {
	
	private JPanel panel = new JPanel();
	private ObtenerTrabajadores listaTrabajadores = new ObtenerTrabajadores();
	private List<Trabajador> trabajadores = listaTrabajadores.obtenerTrabajadores();
	private Trabajador seleccionado = new Trabajador();
	private JCheckBox checkOficial = new JCheckBox("");
	private JCheckBox checkTecnic = new JCheckBox("");
	private JTextField inName;
	private JTextField inLastName;
	
public Trabajador modificarTrabajador(){
		
		String nombre = inName.getText();
		String apellido = inLastName.getText();
		String categoria;
		if(checkOficial.isSelected()) {
			categoria= "Oficial";
		}else {
			categoria= "Tecnico";
		}
		Trabajador trabajador = new Trabajador(nombre, apellido, categoria);
		return trabajador;
	}
	
	public ModificarTrabajador() {
		
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
		setTitle("StockTools / Modificar trabajador");
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
		Workers.setBounds(125, 37, 197, 43);
		panel.add(Workers);
		
		JButton modificarTrabajador = new JButton("MODIFICAR TRABAJADOR");
		modificarTrabajador.setVerticalTextPosition(SwingConstants.CENTER);
		modificarTrabajador.setHorizontalTextPosition(SwingConstants.CENTER);
		modificarTrabajador.setIcon(new ImageIcon("./imagenes/boton.png"));
		modificarTrabajador.setFont(new Font("Arial", Font.BOLD, 12));
		modificarTrabajador.setForeground(new Color(255, 255, 255));
		modificarTrabajador.setBounds(391, 447, 182, 43);
		panel.add(modificarTrabajador);
		
		JLabel aviso = new JLabel("Por favor seleccione solo una opcion ");
		aviso.setFont(new Font("Arial", Font.BOLD, 12));
		aviso.setForeground(new Color(255, 255, 255));
		aviso.setHorizontalAlignment(SwingConstants.CENTER);
		aviso.setBounds(41, 382, 363, 23);
		panel.add(aviso);
		
		JLabel datos = new JLabel("Datos a modificar");
        datos.setHorizontalAlignment(SwingConstants.CENTER);
        datos.setForeground(Color.WHITE);
        datos.setFont(new Font("Arial", Font.BOLD, 24));
        datos.setBounds(522, 37, 340, 43);
        panel.add(datos);
        
        JLabel aviso2 = new JLabel("Por favor rellene todos los campos");
        aviso2.setHorizontalAlignment(SwingConstants.CENTER);
        aviso2.setForeground(new Color(255, 255, 255));
        aviso2.setFont(new Font("Arial", Font.BOLD, 12));
        aviso2.setBounds(533, 382, 311, 23);
        panel.add(aviso2);
        
        JLabel Name = new JLabel("Nombre");
		Name.setHorizontalAlignment(SwingConstants.RIGHT);
		Name.setForeground(new Color(255, 255, 255));
		Name.setFont(new Font("Arial", Font.BOLD, 12));
		Name.setBounds(511, 103, 62, 20);
		panel.add(Name);
		
		JLabel lastName = new JLabel("Primer Apellido");
		lastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lastName.setForeground(Color.WHITE);
		lastName.setFont(new Font("Arial", Font.BOLD, 12));
		lastName.setBounds(470, 190, 103, 20);
		panel.add(lastName);
		
		JLabel category = new JLabel("Categoria");
		category.setHorizontalAlignment(SwingConstants.RIGHT);
		category.setForeground(Color.WHITE);
		category.setFont(new Font("Arial", Font.BOLD, 12));
		category.setBounds(470, 294, 103, 20);
		panel.add(category);
		
		inName = new JTextField();
		inName.setBounds(610, 103, 252, 20);
		panel.add(inName);
		inName.setColumns(10);
		
		inLastName = new JTextField();
		inLastName.setColumns(10);
		inLastName.setBounds(610, 190, 252, 20);
		panel.add(inLastName);
		
		
		checkOficial.setBounds(610, 291, 21, 23);
		panel.add(checkOficial);
		
		
		checkTecnic.setBounds(708, 291, 21, 23);
		panel.add(checkTecnic);
		
		JLabel oficial = new JLabel("Oficial");
		oficial.setHorizontalAlignment(SwingConstants.LEFT);
		oficial.setForeground(Color.WHITE);
		oficial.setFont(new Font("Arial", Font.BOLD, 12));
		oficial.setBounds(637, 294, 62, 20);
		panel.add(oficial);
		
		JLabel tecnico = new JLabel("Tecnico");
		tecnico.setHorizontalAlignment(SwingConstants.LEFT);
		tecnico.setForeground(Color.WHITE);
		tecnico.setFont(new Font("Arial", Font.BOLD, 12));
		tecnico.setBounds(735, 294, 103, 20);
		panel.add(tecnico);
		
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
		checkWorkers.setBounds(41, 91, 363, 280);
		panel.add(checkWorkers);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("./imagenes/fondo.jpg"));
		fondo.setBounds(0, 0, 944, 501);
		panel.add(fondo);
		
		
		
		//Acciones
		checkOficial.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(checkOficial.isSelected()) {
					checkTecnic.setSelected(false);
				}
			}
		});
				
		checkTecnic.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(checkTecnic.isSelected()) {
					checkOficial.setSelected(false);
				}
			}
		});
		
		inName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(inName.getText().length()>20) {
					inName.setText("");
					JOptionPane.showMessageDialog(null,"El nombre del trabajador solo puede tener 20 caracteres");
				}
			}
		});
		
		inLastName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(inLastName.getText().length()>20) {
					inLastName.setText("");
					JOptionPane.showMessageDialog(null,"El apellido del trabajador solo puede tener 20 caracteres");
				}
			}
		});
		
		modificarTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trabajador modificado = modificarTrabajador();
				ModificarTrabajadorControlador modificar = new ModificarTrabajadorControlador();
				modificar.modificarTrabajadorControlador(seleccionado, modificado);
				dispose();
			}
		});
				
	}
}