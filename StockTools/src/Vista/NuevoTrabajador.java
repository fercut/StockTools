package Vista;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class NuevoTrabajador extends JFrame {

	private JTextField inName;
	private JTextField inLastName;
	
	public NuevoTrabajador() {
		
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
		
		//Panel de insercion
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 944, 501);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		//Formulario
		JButton aceptar = new JButton("Aceptar");
		aceptar.setForeground(new Color(255, 255, 255));
		aceptar.setIcon(new ImageIcon("./imagenes/boton.png"));
		aceptar.setVerticalTextPosition(SwingConstants.CENTER);
		aceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		aceptar.setFont(new Font("Arial", Font.BOLD, 12));
		aceptar.setBounds(414, 389, 113, 28);
		panel.add(aceptar);
		
		JLabel Name = new JLabel("Nombre");
		Name.setHorizontalAlignment(SwingConstants.RIGHT);
		Name.setForeground(new Color(255, 255, 255));
		Name.setFont(new Font("Arial", Font.BOLD, 12));
		Name.setBounds(268, 126, 62, 20);
		panel.add(Name);
		
		JLabel lastName = new JLabel("Primer Apellido");
		lastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lastName.setForeground(Color.WHITE);
		lastName.setFont(new Font("Arial", Font.BOLD, 12));
		lastName.setBounds(227, 180, 103, 20);
		panel.add(lastName);
		
		JLabel category = new JLabel("Primer Apellido");
		category.setHorizontalAlignment(SwingConstants.RIGHT);
		category.setForeground(Color.WHITE);
		category.setFont(new Font("Arial", Font.BOLD, 12));
		category.setBounds(227, 245, 103, 20);
		panel.add(category);
		
		inName = new JTextField();
		inName.setBounds(390, 126, 252, 20);
		panel.add(inName);
		inName.setColumns(10);
		
		inLastName = new JTextField();
		inLastName.setColumns(10);
		inLastName.setBounds(390, 180, 252, 20);
		panel.add(inLastName);
		
		JCheckBox checkOficial = new JCheckBox("");
		checkOficial.setBounds(390, 244, 21, 23);
		panel.add(checkOficial);
		
		JCheckBox checkTecnic = new JCheckBox("");
		checkTecnic.setBounds(518, 244, 21, 23);
		panel.add(checkTecnic);
		
		JLabel oficial = new JLabel("Oficial");
		oficial.setHorizontalAlignment(SwingConstants.LEFT);
		oficial.setForeground(Color.WHITE);
		oficial.setFont(new Font("Arial", Font.BOLD, 12));
		oficial.setBounds(414, 245, 62, 20);
		panel.add(oficial);
		
		JLabel tecnico = new JLabel("Tecnico");
		tecnico.setHorizontalAlignment(SwingConstants.LEFT);
		tecnico.setForeground(Color.WHITE);
		tecnico.setFont(new Font("Arial", Font.BOLD, 12));
		tecnico.setBounds(545, 245, 103, 20);
		panel.add(tecnico);
		
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
		
   }
}