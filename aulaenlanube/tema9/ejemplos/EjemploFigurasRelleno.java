package aulaenlanube.tema9.ejemplos;

import javax.swing.*;
import java.awt.*;

public class EjemploFigurasRelleno extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // rellena un rectángulo en verde
        g.setColor(Color.GREEN);
        g.fillRect(50, 50, 150, 100);

        // rellena un óvalo en azul
        g.setColor(Color.BLUE);
        g.fillOval(220, 50, 150, 100);

        // rellena un triángulo en magenta
        g.setColor(Color.MAGENTA);
        Polygon triangulo = new Polygon();
        triangulo.addPoint(50, 200);
        triangulo.addPoint(100, 250);
        triangulo.addPoint(150, 200);
        g.fillPolygon(triangulo);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Figuras con relleno");
        frame.add(new EjemploFigurasRelleno());
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}