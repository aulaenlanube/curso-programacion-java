package aulaenlanube.tema9.ejemplos;

import javax.swing.*;
import java.awt.*;

public class EjemploFigurasColores extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // dibuja una línea en rojo
        g.setColor(Color.RED);
        g.drawLine(20, 30, 200, 30);

        // dibuja un rectángulo en verde
        g.setColor(Color.GREEN);
        g.drawRect(50, 50, 150, 100);

        // dibuja un óvalo en azul
        g.setColor(Color.BLUE);
        g.drawOval(220, 50, 150, 100);

        // dibuja un triángulo en magenta
        g.setColor(Color.MAGENTA);
        Polygon triangulo = new Polygon();
        triangulo.addPoint(50, 200);
        triangulo.addPoint(100, 250);
        triangulo.addPoint(150, 200);
        g.drawPolygon(triangulo);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Figuras de colores");
        frame.add(new EjemploFigurasColores());
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}