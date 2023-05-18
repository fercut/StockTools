package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import Controlador.*;

public class ModificarHerramienta extends JFrame {
	
	private JPanel panel;
	private JTextField inName;
	private JTextField inBrand;
	private JTextField inPower;
	private JTextField inWeigth;
	private JTextField inAnnotation;
	private JTextField inImage;
	private JCheckBox checkYes = new JCheckBox("");
	private JCheckBox checkNo = new JCheckBox("");
	private ObtenerHerramientasModificarModelo listaHerramientas = new ObtenerHerramientasModificarModelo();
	private List<Herramienta> herramientas = listaHerramientas.obtenerHerramientasModificarModelo();
	private Herramienta seleccionada = new Herramienta();
	
public Herramienta modificarHerramienta() {
		
		String nombre = inName.getText();
		String marca = inBrand.getText();
		int potencia;
		double peso = Double.parseDouble(inWeigth.getText());
		String anotacion = inAnnotation.getText();
		String foto = inImage.getText();
		String electrica;
		
		if(checkYes.isSelected()) {
			electrica = "Si";
		}else {
			electrica = "No";
		}
		
		if(inPower.getText().equals("")) {
			potencia = 0;
		}else {
			potencia = Integer.parseInt(inPower.getText());
		}
		
		
		Herramienta tools = new Herramienta(nombre, marca, electrica, potencia, peso, anotacion, foto);
		return tools;
	}
	
	public ModificarHerramienta() {
			
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
			setTitle("StockTools / Modificar herramienta");
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
			Tools.setBounds(74, 35, 193, 43);
			panel.add(Tools);
			
			JButton modificarHerramienta = new JButton("MODIFICAR HERRAMIENTA");
			modificarHerramienta.setVerticalTextPosition(SwingConstants.CENTER);
			modificarHerramienta.setHorizontalTextPosition(SwingConstants.CENTER);
			modificarHerramienta.setIcon(new ImageIcon("./imagenes/boton.png"));
			modificarHerramienta.setFont(new Font("Arial", Font.BOLD, 12));
			modificarHerramienta.setForeground(new Color(255, 255, 255));
			modificarHerramienta.setBounds(374, 447, 182, 43);
			panel.add(modificarHerramienta);
			
			JLabel aviso = new JLabel("Por favor seleccione solo una opcion ");
			aviso.setFont(new Font("Arial", Font.BOLD, 12));
			aviso.setForeground(new Color(255, 255, 255));
			aviso.setHorizontalAlignment(SwingConstants.CENTER);
			aviso.setBounds(28, 399, 293, 20);
			panel.add(aviso);
			
			JLabel Name = new JLabel("Nombre");
			Name.setForeground(new Color(255, 255, 255));
			Name.setBounds(460, 98, 45, 20);
			Name.setHorizontalAlignment(SwingConstants.RIGHT);
			Name.setFont(new Font("Arial", Font.BOLD, 12));
			panel.add(Name);
		
			JLabel brand = new JLabel("Marca");
			brand.setForeground(new Color(255, 255, 255));
			brand.setBounds(469, 140, 36, 20);
			brand.setHorizontalAlignment(SwingConstants.RIGHT);
			brand.setFont(new Font("Arial", Font.BOLD, 12));
			panel.add(brand);
			
			JLabel electric = new JLabel("Electrica");
			electric.setForeground(new Color(255, 255, 255));
			electric.setBounds(455, 183, 50, 20);
			electric.setHorizontalAlignment(SwingConstants.RIGHT);
			electric.setFont(new Font("Arial", Font.BOLD, 12));
			panel.add(electric);
			
			JLabel power = new JLabel("Potencia en W");
			power.setForeground(new Color(255, 255, 255));
			power.setBounds(423, 225, 82, 20);
			power.setHorizontalAlignment(SwingConstants.RIGHT);
			power.setFont(new Font("Arial", Font.BOLD, 12));
			panel.add(power);
			
			JLabel weight = new JLabel("Peso en kg");
			weight.setForeground(new Color(255, 255, 255));
			weight.setBounds(442, 268, 63, 20);
			weight.setHorizontalAlignment(SwingConstants.RIGHT);
			weight.setFont(new Font("Arial", Font.BOLD, 12));
			panel.add(weight);
			
			JLabel annotation = new JLabel("Anotaciones");
			annotation.setForeground(new Color(255, 255, 255));
			annotation.setBounds(434, 311, 71, 20);
			annotation.setHorizontalAlignment(SwingConstants.RIGHT);
			annotation.setFont(new Font("Arial", Font.BOLD, 12));
			panel.add(annotation);
			
			JLabel imagen = new JLabel("Ruta de la imagen");
			imagen.setForeground(new Color(255, 255, 255));
			imagen.setBounds(404, 352, 101, 20);
			imagen.setHorizontalAlignment(SwingConstants.RIGHT);
			imagen.setFont(new Font("Arial", Font.BOLD, 12));
			panel.add(imagen);
			
			checkYes.setBounds(561, 181, 21, 22);
			checkYes.setSelected(true);
			panel.add(checkYes);
			
			checkNo.setBounds(648, 180, 21, 23);
			panel.add(checkNo);
			
			inName = new JTextField();
			inName.setBounds(561, 98, 239, 20);
			inName.setColumns(10);
			panel.add(inName);
			
			inBrand = new JTextField();
			inBrand.setColumns(10);
			inBrand.setBounds(561, 140, 239, 20);
			panel.add(inBrand);
			
			inPower = new JTextField();
			inPower.setColumns(10);
			inPower.setBounds(561, 225, 239, 20);
			panel.add(inPower);
			
			inWeigth = new JTextField();
			inWeigth.setColumns(10);
			inWeigth.setBounds(561, 268, 239, 20);
			panel.add(inWeigth);
			
			inAnnotation = new JTextField();
			inAnnotation.setColumns(10);
			inAnnotation.setBounds(561, 311, 239, 20);
			panel.add(inAnnotation);
			
			inImage = new JTextField();
			inImage.setColumns(10);
			inImage.setBounds(561, 352, 239, 20);
			panel.add(inImage);
	        
	        JLabel si = new JLabel("Si");
	        si.setForeground(new Color(255, 255, 255));
	        si.setBounds(588, 186, 21, 14);
	        panel.add(si);
	        
	        JLabel no = new JLabel("No");
	        no.setForeground(Color.WHITE);
	        no.setBounds(675, 186, 21, 14);
	        panel.add(no);
	        
	        JLabel datos = new JLabel("Datos nuevos");
	        datos.setHorizontalAlignment(SwingConstants.CENTER);
	        datos.setForeground(Color.WHITE);
	        datos.setFont(new Font("Arial", Font.BOLD, 24));
	        datos.setBounds(442, 35, 340, 43);
	        panel.add(datos);
	        
	    	//Insercion de herramientas de forma dinamica
			JPanel checkHerramientas = new JPanel();
			checkHerramientas.setLayout(new BoxLayout (checkHerramientas, BoxLayout.Y_AXIS));
			
			for(Herramienta herramienta : herramientas) {
				
				JCheckBox checkBox = new JCheckBox(herramienta.getNombre() + ", " + herramienta.getMarca() +
						", " + herramienta.getPotencia() + "W, " + herramienta.getPeso() + "Kg, " + herramienta.getAnotaciones());
				checkBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(checkBox.isSelected()) {
							seleccionada = herramienta;
							inName.setText(seleccionada.getNombre());
							inBrand.setText(seleccionada.getMarca());
							if(seleccionada.getElectrica().equals("Si")) {
								checkYes.setSelected(true);
							}else {
								checkNo.setSelected(true);
							}
							inPower.setText(String.valueOf(seleccionada.getPotencia()));
							inWeigth.setText(String.valueOf(seleccionada.getPeso()));
							inAnnotation.setText(seleccionada.getAnotaciones());
						}
					}
				});
				checkHerramientas.add(checkBox);
			}
			
			JScrollPane checkTools = new JScrollPane(checkHerramientas);
			checkTools.setBounds(28, 89, 293, 296);
			panel.add(checkTools);
			
			JButton examine = new JButton("Examinar");
	        examine.setForeground(new Color(255, 255, 255));
	        examine.setIcon(new ImageIcon("./imagenes/boton.png"));
	        examine.setVerticalTextPosition(SwingConstants.CENTER);
	        examine.setHorizontalTextPosition(SwingConstants.CENTER);
	        examine.setFont(new Font("Arial", Font.BOLD, 11));
	        examine.setBounds(810, 351, 89, 23);
	        panel.add(examine);
	        
	        JLabel fondo = new JLabel("");
	        fondo.setIcon(new ImageIcon("./imagenes/fondo.jpg"));
	        fondo.setBounds(0, 0, 944, 501);
	        panel.add(fondo);
	        
	        //Acciones
	        checkYes.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e) {
					if(checkYes.isSelected()) {
						checkNo.setSelected(false);
					}
				}
			});
			
			checkNo.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e) {
					if(checkNo.isSelected()) {
						checkYes.setSelected(false);
					}
				}
			});
			
	        inName.addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent e) {
					if(inName.getText().length() > 20){
						inName.setText("");
						JOptionPane.showMessageDialog(null,"El nombre de la herramienta solo puede \n tener hasta 20 caracteres");
					}
				}
			});
			inBrand.addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent e) {
					if(inBrand.getText().length() > 20) {
						inBrand.setText("");
						JOptionPane.showMessageDialog(null,"La Marca de la herramienta solo puede \n tener hasta 20 caracteres");
					}
				}
			});
			
			inPower.addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent e) {
					try {
						if(inPower.getText().length()>0) {
							 int value = Integer.parseInt(inPower.getText());
						}
					} catch (NumberFormatException e1) {
				    	  inPower.setText("");
				    	  JOptionPane.showMessageDialog(null,"La potencia debe ser un numero \n entero sin puntos ni comas ni letras");
				      }
				}
			});
			
			inWeigth.addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent e) {
					try {
						if(inWeigth.getText().length()>0) {
							 double value = Double.parseDouble(inWeigth.getText());
						}
					} catch (NumberFormatException e1) {
						inWeigth.setText("");
				    	  JOptionPane.showMessageDialog(null,"La parte decimal del peso debe estar separada \n  por un punto y no debe de tener letras");
				      }
				}
			});
			inAnnotation.addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent e) {
					if(inAnnotation.getText().length()>100) {
						inAnnotation.setText("");
						JOptionPane.showMessageDialog(null,"La anotacion no puede tener mas de 100 caracteres");
					}
				}
			});
			
			modificarHerramienta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ModificarHerramientaControlador modificar = new ModificarHerramientaControlador();
					Herramienta modificada = modificarHerramienta();
					modificar.modificarHerramientaControlador(seleccionada, modificada);
					dispose();
				}
			});
			
			examine.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BuscarImagen ruta = new BuscarImagen();
					inImage.setText(ruta.buscarImagen());
					
				}
			});
	        
	}
}
