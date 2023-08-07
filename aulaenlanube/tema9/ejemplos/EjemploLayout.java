package aulaenlanube.tema9.ejemplos;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EjemploLayout {

    public static void main(String args[]) {

        // creamos ventana
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // características ventana
        ventana.setSize(500, 500);
        ventana.setVisible(true);
        ventana.setLayout(new BorderLayout());

        // creamos boton, posición x:100, y:200 - botón de 200px de ancho y 40px de alto
        JButton boton1 = new JButton("Pulsa1");
        JButton boton2 = new JButton("Pulsa2");
        JButton boton3 = new JButton("Pulsa3");

        ventana.add(boton1, BorderLayout.WEST);
        ventana.add(boton2, BorderLayout.CENTER);
        ventana.add(boton3, BorderLayout.EAST);
        //boton.setBounds(100, 200, 200, 40);
    }

}
