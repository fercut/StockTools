package Vista;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


import javax.swing.JFileChooser;

public class BuscarImagen {
	
	public String buscarImagen() {
		
		String ruta="";
		
        //Se crea el JFileChooser. Se le indica que la ventana se abra en el directorio actual                    
        JFileChooser fileChooser = new JFileChooser(".");      
        //Se crea el filtro. El primer parámetro es el mensaje que se muestra,
        //el segundo es la extensión de los ficheros que se van a mostrar      
        FileFilter filtro = new FileNameExtensionFilter("Archivos imagen (.jpg, .png, .gif)", "jpg", "png", "gif"); 
        //Se le asigna al JFileChooser el filtro
        fileChooser.setFileFilter(filtro);
        //se muestra la ventana
        int valor = fileChooser.showOpenDialog(fileChooser);
        if (valor == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getAbsolutePath();
        } else {
        	JOptionPane.showMessageDialog(null,"No se ha encontrado el archivo");
        }
	        
	    return ruta;
	        
	}

}
