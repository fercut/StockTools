package Vista;

	import java.awt.*;
	import java.awt.event.*;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Scanner;
	import javax.imageio.ImageIO;
	import javax.swing.*;
	import Modelo.*;
	import Controlador.*;
	
	public class Login extends JFrame {
		
		//Componentes
		private JPanel panel;
		private ImageIcon boton = new ImageIcon("./imagenes/boton.png");
		private JTextField inUser;
		private JPasswordField inPass;
		
		public JPanel getPanel() {
			return panel;
		}

		public void setPanel(JPanel panel) {
			this.panel = panel;
		}

		public ImageIcon getBoton() {
			return boton;
		}

		public void setBoton(ImageIcon boton) {
			this.boton = boton;
		}

		public JTextField getInUser() {
			return inUser;
		}

		public void setInUser(JTextField inUser) {
			this.inUser = inUser;
		}

		public JPasswordField getInPass() {
			return inPass;
		}

		public void setInPass(JPasswordField inPass) {
			this.inPass = inPass;
		}

		public Login() {
			
			//Propiedades de la ventana
			setVisible(true);
			setResizable(false);
			Toolkit miPantalla = Toolkit.getDefaultToolkit();
			Dimension tamanoPantalla = miPantalla.getScreenSize(); 
			int alturaPantalla = tamanoPantalla.height;
			int anchoPantalla = tamanoPantalla.width;
			setLocation(anchoPantalla/4, alturaPantalla/4);
			setSize(anchoPantalla/2, alturaPantalla/2);
			setDefaultCloseOperation(3);
			
			//Icono, nombre
			setTitle("StockTools");
			setIconImage(Toolkit.getDefaultToolkit().getImage("./imagenes/icono.png"));
			getContentPane().setLayout(null);
			
			//Panel de insercion
			panel = new JPanel();
			panel.setLayout(null);
			panel.setOpaque(false);
			setContentPane(panel);
			
			//Formulario
			JButton entrar = new JButton("ENTRAR");
			entrar.setIcon(new ImageIcon("./imagenes/boton.png"));
			entrar.setVerticalTextPosition(SwingConstants.CENTER);
			entrar.setHorizontalTextPosition(SwingConstants.CENTER);
			entrar.setForeground(Color.WHITE);
			entrar.setFont(new Font("Arial", Font.BOLD, 12));
			entrar.setBounds(295, 328, 119, 36);
			panel.add(entrar);
			
			JButton jefeNuevo = new JButton("NUEVO RESPONSABLE");
			jefeNuevo.setIcon(new ImageIcon("./imagenes/boton.png"));
			jefeNuevo.setVerticalTextPosition(SwingConstants.CENTER);
			jefeNuevo.setHorizontalTextPosition(SwingConstants.CENTER);
			jefeNuevo.setForeground(Color.WHITE);
			jefeNuevo.setFont(new Font("Arial", Font.BOLD, 12));
			jefeNuevo.setBounds(445, 328, 180, 36);
			panel.add(jefeNuevo);
			
			
			inUser = new JTextField();
			inUser.setBounds(394, 137, 231, 29);
			panel.add(inUser);
			inUser.setColumns(10);
			
			inPass = new JPasswordField();
			inPass.setBounds(394, 222, 231, 29);
			panel.add(inPass);
			
			JLabel User = new JLabel("Usuario");
			User.setForeground(new Color(255, 255, 255));
			User.setFont(new Font("Arial", Font.BOLD, 12));
			User.setBounds(317, 140, 44, 22);
			panel.add(User);
			
			JLabel Password = new JLabel("Contraseña");
			Password.setForeground(new Color(255, 255, 255));
			Password.setFont(new Font("Arial", Font.BOLD, 12));
			Password.setBounds(295, 229, 66, 14);
			panel.add(Password);
			
			JLabel error = new JLabel("");
			error.setFont(new Font("Arial",Font.CENTER_BASELINE, 12));
			error.setHorizontalAlignment(SwingConstants.CENTER);
			error.setBounds(214, 281, 530, 29);
			error.setForeground(new Color(255, 255, 255));
			panel.add(error);
			
			JLabel fondo = new JLabel("");
			fondo.setIcon(new ImageIcon("./imagenes/fondo.jpg"));
			fondo.setBounds(0, 0, 944, 501);
			panel.add(fondo);
			
			//Acciones
			entrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//Entrar
						File users = new File("./txt/Usuarios");
						Scanner lector = new Scanner(users);
						lector.nextLine();
						while(lector.hasNextLine()) {
							String [] usuarios = lector.nextLine().split(" / ");
							String nombre = usuarios[0];
							String contrasena = usuarios[1];
							char [] pass = getInPass().getPassword();
							String password = new String(pass);
							if(nombre.equals(getInUser().getText()) && contrasena.equals(password)) {
								App app = new App();
								app.setVisible(true);
								Creacion_BBDD conecta = new Creacion_BBDD();
								conecta.crearBBDD();
								dispose();
								
							}else {
								error.setText("Contraseña o usuario incorrecto, si no puede iniciar secion hable con un responsable");
							}
							
						}
					}catch (FileNotFoundException e1) {
						e1.getMessage();
					}
				}
			});
			
			jefeNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//Añadir nuevo responsable
						File users = new File("./txt/Usuarios");
						Scanner lector = new Scanner(users);
						lector.nextLine();
						while(lector.hasNextLine()) {
							String [] usuarios = lector.nextLine().split(" / ");
							String nombre = usuarios[0];
							String contrasena = usuarios[1];
							char [] pass = getInPass().getPassword();
							String password = new String(pass);
							if(nombre.equals(getInUser().getText()) && contrasena.equals(password)) {
								
								NuevoResponsable responsable = new NuevoResponsable();
								responsable.setVisible(true);
								
							}else {
								error.setText("Introduce Usuario y contraseña correctamente para poder añadir un nuevo responsable");
							}
						}
					}catch (FileNotFoundException e1) {
						e1.getMessage();
					}
				}
			});
			
			revalidate();
			repaint();
		}
	}