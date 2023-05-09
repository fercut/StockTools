package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import Modelo.*;
import Controlador.*;

public class NuevoResponsable extends JFrame{
	
	//Componentes
	private JPanel panel;
	private ImageIcon boton = new ImageIcon("./imagenes/boton.png");
	private JTextField inUser;
	private JPasswordField inPass;

	public NuevoResponsable() {
		
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
		
		//Icono, nombre
		setTitle("StockTools / Nuevo responsable");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagenes/icono.png"));
		getContentPane().setLayout(null);
		
		//Panel de insercion
		panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		setContentPane(panel);
		
		//Formulario
		inUser = new JTextField();
		inUser.setBounds(394, 137, 231, 29);
		panel.add(inUser);
		inUser.setColumns(10);
		
		inPass = new JPasswordField();
		inPass.setBounds(394, 229, 231, 29);
		panel.add(inPass);
		
		JLabel User = new JLabel("Nombre");
		User.setHorizontalAlignment(SwingConstants.RIGHT);
		User.setForeground(new Color(255, 255, 255));
		User.setFont(new Font("Arial", Font.BOLD, 12));
		User.setBounds(248, 140, 113, 22);
		panel.add(User);
		
		JLabel Password = new JLabel("Contraseña");
		Password.setForeground(new Color(255, 255, 255));
		Password.setFont(new Font("Arial", Font.BOLD, 12));
		Password.setBounds(295, 236, 66, 14);
		panel.add(Password);
		
		JButton Registrar = new JButton("NUEVO RESPONSABLE");
		Registrar.setIcon(new ImageIcon("./imagenes/boton.png"));
		Registrar.setVerticalTextPosition(SwingConstants.CENTER);
		Registrar.setHorizontalTextPosition(SwingConstants.CENTER);
		Registrar.setForeground(Color.WHITE);
		Registrar.setFont(new Font("Arial", Font.BOLD, 12));
		Registrar.setBounds(374, 328, 196, 36);
		panel.add(Registrar);
		
		JLabel lblNewLabel = new JLabel("NUEVO RESPONSABLE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 42, 924, 58);
		panel.add(lblNewLabel);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("./imagenes/fondo.jpg"));
		fondo.setBounds(0, 0, 944, 501);
		panel.add(fondo);
		
		//Acciones
		Registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Escribir nuevo responsable sin borrar los anteriores
				try {
				    FileWriter escribe = new FileWriter("./txt/Usuarios", true); 
				    char [] pass = inPass.getPassword();
					String password = new String(pass);
					escribe.write("\n" + inUser.getText() + " / " + password); 
				    JOptionPane.showMessageDialog(null,"Nuevo responsable añadido con exito");
				    escribe.close();
				    dispose();
				} catch (IOException e3) {
				    System.out.println("Ha ocurrido un error al escribir en el archivo.");
				    e3.printStackTrace();
				}
			}
		});
		
	}
}
