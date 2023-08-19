package aulaenlanube.tema9.ejemplos;

import javax.swing.*;
import java.awt.*;

public class EjemploFigurasBordes extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // dibuja una línea en rojo con un ancho de 5
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(20, 30, 200, 30);

        // dibuja un rectángulo en verde con un ancho de 3
        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(3));
        g2d.rotate(Math.toRadians(5));
        g2d.scale(2,2);
        g2d.fillRect(50, 50, 150, 100);
        g2d.setColor(Color.BLACK);        
        g2d.drawRect(50, 50, 150, 100);
        
        // dibujar un óvalo en azul con un ancho de 4
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(4));
        g2d.drawOval(220, 50, 150, 100);

        // dibujar un triángulo en magenta con un ancho de 5
        g2d.setColor(Color.MAGENTA);
        g2d.setStroke(new BasicStroke(5));
        Polygon triangulo = new Polygon();
        triangulo.addPoint(50, 200);
        triangulo.addPoint(100, 250);
        triangulo.addPoint(150, 200);
        g2d.drawPolygon(triangulo);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Figuras con bordes");
        frame.add(new EjemploFigurasBordes());
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}