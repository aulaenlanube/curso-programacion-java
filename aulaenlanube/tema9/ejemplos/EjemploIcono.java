package aulaenlanube.tema9.ejemplos;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EjemploIcono {

    public static void main(String[] args) {

        JFrame ventana = new JFrame();
        ventana.setSize(500, 500);
        ventana.setLayout(new FlowLayout());        

        ImageIcon icono = new ImageIcon("aulaenlanube/tema9/imagenes/icono-aulaenlanube.png");
        JButton boton = new JButton("Pulsa", icono);
        boton.setFocusable(false); //evitar el foco automático
        boton.addActionListener(e -> System.out.println("Has pulsado el botón con el icono"));        
        
        ventana.add(boton);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
    
}
