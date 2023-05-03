package Vista;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controlador.*;
import Modelo.*;

public class NuevaHerramienta extends JFrame {
	
	//Componentes
	private JPanel panel;
	private JPanel panelImagen;
	private JTextField inName;
	private JTextField inBrand;
	private JTextField inPower;
	private JTextField inWeigth;
	private JTextField inAnnotation;
	private JTextField inImage;
	private JCheckBox checkYes = new JCheckBox("");
	private JCheckBox checkNo = new JCheckBox("");
	
	//Creacion del objeto que vamos a INSERTAR en la BBDD (si es correcto)
	public Herramienta InsertTools() {
		
		String nombre = inName.getText();
		String marca = inBrand.getText();
		int potencia = Integer.parseInt(inPower.getText());
		double peso = Double.parseDouble(inWeigth.getText());
		String anotacion = inAnnotation.getText();
		String foto = inImage.getText();
		String electrica;
		if(checkYes.isSelected()) {
			electrica = "Si";
		}else {
			electrica = "No";
		}
		Herramienta tools = new Herramienta(nombre, marca, electrica, potencia, peso, anotacion, foto);
		return tools;
	}
	
	//Metodos getter y setter por lo que pueda pasar
	public JPanel getPanel() {
		return panel;
	}


	public JCheckBox getCheckYes() {
		return checkYes;
	}

	public void setCheckYes(JCheckBox checkYes) {
		this.checkYes = checkYes;
	}

	public JCheckBox getCheckNo() {
		return checkNo;
	}

	public void setCheckNo() {
		this.checkNo.isSelected();
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public JPanel getPanelImagen() {
		return panelImagen;
	}


	public void setPanelImagen(JPanel panelImagen) {
		this.panelImagen = panelImagen;
	}


	public JTextField getInName() {
		return inName;
	}


	public void setInName(String inName) {
		this.inName.setText(inName);
	}


	public JTextField getInBrand() {
		return inBrand;
	}


	public void setInBrand(String inBrand) {
		this.inBrand.setText(inBrand);
	}


	public JTextField getInPower() {
		return inPower;
	}


	public void setInPower(String inPower) {
		this.inPower.setText(inPower);
	}


	public JTextField getInWeigth() {
		return inWeigth;
	}


	public void setInWeigth(String inWeigth) {
		this.inWeigth.setText(inWeigth);
	}


	public JTextField getInAnnotation() {
		return inAnnotation;
	}


	public void setInAnnotation(String inAnnotation) {
		this.inAnnotation.setText(inAnnotation);
	}


	public JTextField getInImage() {
		return inImage;
	}


	public void setInImage(JTextField inImage) {
		this.inImage = inImage;
	}

	//Creacion de la pare visual.
	public NuevaHerramienta() {
		
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
		setTitle("StockTools / Nueva herramienta");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagenes/icono.png"));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		//Crear panel para la imagen
        panelImagen = new JPanel();
        panelImagen.setOpaque(false);
        panelImagen.setBounds(0, 0, getWidth(), getHeight());
        panelImagen.setBackground(Color.WHITE);
        panelImagen.setLayout(null);

        // Añadir panel de la imagen al panel principal
        panel.add(panelImagen);
	
		
		//Formulario
		JLabel Name = new JLabel("Nombre");
		Name.setForeground(new Color(255, 255, 255));
		Name.setBounds(287, 80, 45, 20);
		Name.setHorizontalAlignment(SwingConstants.RIGHT);
		Name.setFont(new Font("Arial", Font.BOLD, 12));
	
		JLabel brand = new JLabel("Marca");
		brand.setForeground(new Color(255, 255, 255));
		brand.setBounds(296, 120, 36, 20);
		brand.setHorizontalAlignment(SwingConstants.RIGHT);
		brand.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel electric = new JLabel("Electrica");
		electric.setForeground(new Color(255, 255, 255));
		electric.setBounds(282, 160, 50, 20);
		electric.setHorizontalAlignment(SwingConstants.RIGHT);
		electric.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel power = new JLabel("Potencia en W");
		power.setForeground(new Color(255, 255, 255));
		power.setBounds(250, 200, 82, 20);
		power.setHorizontalAlignment(SwingConstants.RIGHT);
		power.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel weight = new JLabel("Peso en kg");
		weight.setForeground(new Color(255, 255, 255));
		weight.setBounds(269, 240, 63, 20);
		weight.setHorizontalAlignment(SwingConstants.RIGHT);
		weight.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel annotation = new JLabel("Anotaciones");
		annotation.setForeground(new Color(255, 255, 255));
		annotation.setBounds(261, 280, 71, 20);
		annotation.setHorizontalAlignment(SwingConstants.RIGHT);
		annotation.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel imagen = new JLabel("Ruta de la imagen");
		imagen.setForeground(new Color(255, 255, 255));
		imagen.setBounds(231, 320, 101, 20);
		imagen.setHorizontalAlignment(SwingConstants.RIGHT);
		imagen.setFont(new Font("Arial", Font.BOLD, 12));
		
		checkYes.setBounds(392, 158, 21, 22);
		
		checkNo.setBounds(457, 157, 21, 23);
		
		JButton newTool = new JButton("Aceptar");
		newTool.setIcon(new ImageIcon("./imagenes/boton.png"));
		newTool.setBounds(418, 392, 113, 28);
		newTool.setVerticalTextPosition(SwingConstants.CENTER);
		newTool.setHorizontalTextPosition(SwingConstants.CENTER);
		newTool.setForeground(Color.WHITE);
		newTool.setFont(new Font("Arial", Font.BOLD, 12));
		
		inName = new JTextField();
		inName.setBounds(392, 80, 239, 20);
		inName.setColumns(10);
		
		inBrand = new JTextField();
		inBrand.setColumns(10);
		inBrand.setBounds(392, 120, 239, 20);
		
		inPower = new JTextField();
		inPower.setColumns(10);
		inPower.setBounds(392, 200, 239, 20);
		
		inWeigth = new JTextField();
		inWeigth.setColumns(10);
		inWeigth.setBounds(392, 240, 239, 20);
		
		inAnnotation = new JTextField();
		inAnnotation.setColumns(10);
		inAnnotation.setBounds(392, 280, 239, 20);
		
		inImage = new JTextField();
		inImage.setColumns(10);
		inImage.setBounds(392, 320, 239, 20);
		
		panelImagen.add(Name);
        panelImagen.add(brand);
        panelImagen.add(electric);
        panelImagen.add(power);
        panelImagen.add(weight);
        panelImagen.add(annotation);
        panelImagen.add(imagen);
        panelImagen.add(checkYes);
        panelImagen.add(checkNo);
        panelImagen.add(inName);
        panelImagen.add(newTool);
        panelImagen.add(inBrand);
        panelImagen.add(inPower);
        panelImagen.add(inWeigth);
        panelImagen.add(inAnnotation);
        panelImagen.add(inImage);
        
        //Fondo
        JLabel fondo = new JLabel("");
        fondo.setIcon(new ImageIcon("./imagenes/fondo.jpg"));
        fondo.setBounds(0, 0, 950, 508);
        panelImagen.add(fondo);
        setContentPane(panel);
        
        revalidate();
		repaint();
		
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
		
	
		newTool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Evalua toda las casuisticas posibles para que el formulario se rellene con datos validos para la BBDD
				boolean finalizado = true;
				boolean valuePower = true;
				boolean valueWeigth = true;
				
				while(finalizado){
					if(inName.getText().length()>20) {
						JOptionPane.showMessageDialog(null,"El nombre de la herramienta solo puede \n tener hasta 20 caracteres");
						inName.setText("");
						newTool.addActionListener(null);
						
						
					}else if(inBrand.getText().length()>20) {
						inBrand.setText("");;
						JOptionPane.showMessageDialog(null,"La marca de la herramienta solo puede \n tener hasta 20 caracteres");
						
					}else if(!(checkYes.isSelected() || checkNo.isSelected())) {
						checkNo.setSelected(true);
						JOptionPane.showMessageDialog(null,"Por favor marque si es electrica o no");
						newTool.addActionListener(null);
					}else if(valuePower) {
						try {
							
							if(inPower.getText().length()>0 && checkYes.isSelected()) {
								 int value = Integer.parseInt(inPower.getText());
					        	 valuePower = false;
					         }
					      } catch (NumberFormatException e1) {
					    	  new NuevaHerramienta();
					    	  JOptionPane.showMessageDialog(null,"La potencia debe ser un numero \n entero sin puntos ni comas ni letras");
					    	  valuePower = true;
					      }
						
					}else if(valueWeigth) {
						try {
						   
						   if(inWeigth.getText().length()>0) {
							   double value = Double.parseDouble(inWeigth.getText());
							   valueWeigth = false;
						   }
					      } catch (NumberFormatException e2) {
					    	  inWeigth.setText("");
					    	  JOptionPane.showMessageDialog(null,"La parte decimal del peso debe \n estar separada por un punto");
					    	  valueWeigth = true;
					      }
					}else if(inAnnotation.getText().length()>100) {
						inAnnotation.setText("");
						JOptionPane.showMessageDialog(null,"La anotacion no puede tener mas de 100 caracteres");
					
					}else {
						finalizado = false;
					}
				}
				System.out.println("he salido");
				revalidate();
				repaint();
			}
		});
		
		revalidate();
		repaint();
	}
}
	
