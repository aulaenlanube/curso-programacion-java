package aulaenlanube.tema9.ejemplos;

import javax.swing.JFrame;

public class EjemplosJFrame {

    public static void main(String[] args) {        

        JFrame ventana1 = new JFrame("Ventana 1");
        ventana1.setVisible(true);
        ventana1.setSize(500, 200);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame ventana2 = new JFrame("Ventana 2");
        ventana2.setVisible(true);
        ventana2.setSize(500, 200);
        ventana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
