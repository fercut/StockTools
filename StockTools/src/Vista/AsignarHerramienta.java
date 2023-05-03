package Vista;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class AsignarHerramienta extends JFrame {
	
	private JPanel panel;
	
	public AsignarHerramienta() {
		
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
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(122, 94, 97, 23);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_1.setBounds(641, 94, 97, 23);
		panel.add(chckbxNewCheckBox_1);
	}
}