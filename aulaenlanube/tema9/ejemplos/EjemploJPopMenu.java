package aulaenlanube.tema9.ejemplos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;


public class EjemploJPopMenu {
    
    private static Color colorActual = Color.BLACK;
    private static int diametro = 200;
    
    public static void main(String[] args) {
        JFrame ventana = new JFrame("JPopMenu colores");
        ventana.setSize(500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null); //centramos JFrame en la pantalla

        // crear el JPopupMenu y las opciones de color
        JPopupMenu colorMenu = new JPopupMenu();

        JMenuItem rojo = new JMenuItem("Rojo");
        rojo.addActionListener(e -> {
            colorActual = Color.RED;
            ventana.repaint();
        });

        JMenuItem verde = new JMenuItem("Verde");
        verde.addActionListener(e -> {
            colorActual = Color.GREEN;
            ventana.repaint();
        });

        JMenuItem azul  = new JMenuItem("Azul");
        azul.addActionListener(e -> {
            colorActual = Color.BLUE;
            ventana.repaint();
        });

        colorMenu.add(rojo);
        colorMenu.add(verde);
        colorMenu.add(azul);

        // añadimos el MouseListener para mostrar el menú emergente
        ventana.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    colorMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        // dibujamos el círculo
        ventana.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(colorActual);
                g.fillOval((getWidth() - diametro) / 2, (getHeight() - diametro) / 2, diametro, diametro);  //centramos
            }
        });

        ventana.setVisible(true);
    }
}
