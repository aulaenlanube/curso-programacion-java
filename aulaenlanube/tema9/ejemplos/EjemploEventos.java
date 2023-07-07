package aulaenlanube.tema9.ejemplos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EjemploEventos {

    public static void main(String[] args) {

        // creamos la ventana
        JFrame ventana = new JFrame("Ventana con componentes");
        ventana.setLayout(new FlowLayout());
        ventana.setSize(700, 500);

        // creamos un botón
        JButton boton = new JButton("Pulsa");
        ventana.add(boton);

        // asociamos instancia de una clase que implementa ActionListener
        boton.addActionListener(e -> saludar(e));

        // mostrarmos ventana y configuramos el cierre
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void saludar(ActionEvent infoEvento) {
        System.out.println("Hola mundo desde un método con una lambda");
        System.out.println(infoEvento.getSource());
    }
}
