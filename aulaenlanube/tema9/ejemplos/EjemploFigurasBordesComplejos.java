package aulaenlanube.tema9.ejemplos;

import javax.swing.*;
import java.awt.*;

public class EjemploFigurasBordesComplejos extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // dibuja una línea en rojo con un ancho de 10, con terminaciones
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(20, 30, 200, 30);


        // dibujar un triángulo en magenta con un ancho de 5
        //BORDES COMPLEJOS CON TERMINACIONES
        g2d.setColor(Color.MAGENTA);
        g2d.setStroke(new BasicStroke(5));
        Polygon triangulo = new Polygon();
        triangulo.addPoint(50, 200);
        triangulo.addPoint(100, 250);
        triangulo.addPoint(150, 200);
        g2d.drawPolygon(triangulo);

        //DEGRADADO CON DOS COLORES
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Figuras con bordes complejos");
        frame.add(new EjemploFigurasBordesComplejos());
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}