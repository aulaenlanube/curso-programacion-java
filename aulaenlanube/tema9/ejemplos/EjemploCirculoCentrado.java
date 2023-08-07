package aulaenlanube.tema9.ejemplos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class EjemploCirculoCentrado {

    public static void main(String[] args) {
        // Creamos el frame
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // Centramos el frame en la pantalla

        // Creamos un panel personalizado para dibujar el círculo
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int xCenterScreen = screenSize.width / 2;
                int yCenterScreen = screenSize.height / 2;

                Point frameLocation = frame.getLocationOnScreen();
                int x = xCenterScreen - frameLocation.x - 50;  // 50 es el radio
                int y = yCenterScreen - frameLocation.y - 50;  // 50 es el radio

                g.drawOval(x, y, 100, 100);  // 100 es el diámetro
            }
        };

        // Agregamos el panel al frame
        frame.add(panel);

        // Agregamos un listener para cuando el frame se mueva
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                panel.repaint();
            }
        });

        // Mostramos el frame
        frame.setVisible(true);
    }
    
}
