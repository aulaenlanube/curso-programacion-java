package aulaenlanube.tema9.ejemplos;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.*;

public class EjemploVentanaCentrada {

    public static void main(String[] args) {

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
        
        // Agregamos texto y lo centramos
        ventana.setLayout(new BorderLayout());
        JLabel label = new JLabel("Esto es un texto centrado", SwingConstants.CENTER);
        ventana.add(label, BorderLayout.CENTER);      

        // botón cerrar
        JButton boton = new JButton("Cerrar");
        ventana.add(boton, BorderLayout.PAGE_END);
        
        // Centrar la ventana en la pantalla, por defecto se pone al centro
       ventana.setLocationRelativeTo(null);
        
        // Mostrar la ventana
        ventana.setVisible(true);
    }
    
}
