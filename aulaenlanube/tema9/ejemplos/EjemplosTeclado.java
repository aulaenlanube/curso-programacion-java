package aulaenlanube.tema9.ejemplos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class EjemplosTeclado {

    public static void main(String[] args) {

        // creamos una ventana
        JFrame ventana = new JFrame();
        ventana.setSize(500, 200);

        // agregamos evento de escucha del teclado
        ventana.addKeyListener(new KeyListener() {

            // cuando se presiona y se sueltas una tecla que resulta en la introducción de
            // un carácter Unicode
            public void keyTyped(KeyEvent e) {
                System.out.println("Has escrito algo: "+e.getKeyChar());
            }

            // cuando se presione una tecla cualquiera
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                    System.out.println("Has pulsado la tecla → ");
                if (e.getKeyCode() == KeyEvent.VK_LEFT)
                    System.out.println("Has pulsado la tecla ← ");
                if (e.getKeyCode() == KeyEvent.VK_DOWN)
                    System.out.println("Has pulsado la tecla ↓ ");
                if (e.getKeyCode() == KeyEvent.VK_UP)
                    System.out.println("Has pulsado la tecla ↑ ");
            }

            // cuando se suelta una tecla
            public void keyReleased(KeyEvent e) {
                
            }
        });

        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
