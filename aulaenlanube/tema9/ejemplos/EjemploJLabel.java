package aulaenlanube.tema9.ejemplos;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EjemploJLabel {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Ejemplo JLabel");
        ventana.setSize(400, 300);
        ventana.setLayout(new FlowLayout());
        
        // creamos un JLabel
        JLabel label = new JLabel("Intenta pulsar el botón");

        // creamos un JButton
        JButton boton = new JButton("Es aquí");

        // al presionar el botón, modifica el texto del JLabel
        boton.addActionListener(e -> {
            label.setText("Enhorabuena, has pulsado el botón");
        });

        // agregamos el JLabel y JButton al JFrame        
        ventana.add(label);
        ventana.add(boton);

        // mostramos ventana
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
