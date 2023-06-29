package aulaenlanube.tema9.ejemplos;

import javax.swing.JFrame;

public class EjemploLayout {

    public static void main(String args[]) {

        // creamos ventana
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setVisible(true);
        ventana.setSize(500, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
