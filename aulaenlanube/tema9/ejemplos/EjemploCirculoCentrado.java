package aulaenlanube.tema9.ejemplos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class EjemploCirculoCentrado {

    public static void main(String[] args) {

        // creamos el ventana
        JFrame ventana = new JFrame();
        ventana.setSize(600, 600);        
        ventana.setLocationRelativeTo(null);  // centramos el ventana en la pantalla

        // creamos panel personalizado para dibujar el círculo
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                int centroX = dimension.width / 2;
                int centroY = dimension.height / 2;

                Point posVentana = ventana.getLocationOnScreen();
                int x = centroX - posVentana.x - 50;  // 50 es el radio
                int y = centroY - posVentana.y - 50;  // 50 es el radio

                g.drawOval(x, y, 300, 300);  // 100 es el diámetro
            }
        };        
        ventana.add(panel);

        // listener para cuando el ventana se mueva
        ventana.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                panel.repaint();
            }
        });

        // visibilidad y cierre
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
    
}
