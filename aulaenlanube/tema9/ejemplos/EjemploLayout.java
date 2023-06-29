package aulaenlanube.tema9.ejemplos;

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
        ventana.setLayout(null);

        // creamos boton, posición x:100, y:200 - botón de 200px de ancho y 40px de alto
        JButton boton = new JButton("Pulsa");
        ventana.add(boton);
        boton.setBounds(100, 200, 200, 40);
    }

}
