import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.*;

public class EjemploVentanaCentrada {

    public static void main(String[] args) {
        

        //Resolución utilizando Toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int dpi = toolkit.getScreenResolution();
        System.out.println("Resolución en dpi: " + dpi);
        Dimension screenSize = toolkit.getScreenSize();
        System.out.println("Resolución en pixels: " + screenSize.width + " x " + screenSize.height);
  

        // Obtener la configuración de la pantalla
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        
        // Obtener las dimensiones de la pantalla
        Rectangle screenBounds = gc.getBounds();
        
        // Crear una nueva ventana
        JFrame ventana = new JFrame(gc);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Establecer el tamaño de la ventana al 50% de la pantalla
        int windowWidth = (int)(screenBounds.width * 0.5);
        int windowHeight = (int)(screenBounds.height * 0.5);
        System.out.println("Resolución desde GraphicsConfiguration: "+screenBounds.width+" x "+screenBounds.height);
        ventana.setSize(windowWidth, windowHeight);
        
        // Centrar la ventana en la pantalla
        int windowX = (screenBounds.width - windowWidth) / 2;
        int windowY = (screenBounds.height - windowHeight) / 2;
        ventana.setLocation(windowX, windowY);


        // Agregamos texto y lo centramos
        ventana.setLayout(new BorderLayout());
        JLabel label = new JLabel("Esto es un texto centrado", SwingConstants.CENTER);
        ventana.add(label, BorderLayout.CENTER);      

        // botón cerrar
        JButton boton = new JButton("Cerrar");
        ventana.add(boton, BorderLayout.PAGE_END);
        
        ventana.setLocationRelativeTo(null);
        
        // Mostrar la ventana
        ventana.setVisible(true);
    }
    
}
