import javax.swing.JButton;
import javax.swing.JFrame;

public class EjemploLayout {

    public static void main(String args[]) {
        
        // creamos una ventana
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 300);
        // creamos un botón
        JButton boton = new JButton("Presionar");
        // agrega el botón a la ventana
        ventana.getContentPane().add(boton);
        
    }

}
