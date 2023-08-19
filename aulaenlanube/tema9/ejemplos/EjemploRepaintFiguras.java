package aulaenlanube.tema9.ejemplos;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EjemploRepaintFiguras extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2;
        int size = 300; // tamaño de la figura

        switch (new Random().nextInt(5)) {
            case 0 -> g.setColor(Color.BLUE);
            case 1 -> g.setColor(Color.RED);
            case 2 -> g.setColor(Color.GRAY);
            case 3 -> g.setColor(Color.GREEN);
            case 4 -> g.setColor(Color.ORANGE);
        } 

        switch (new Random().nextInt(5)) {

            case 0 ->
                // círculo                
                g.fillOval(centroX - size / 2, centroY - size / 2, size, size);

            case 1 ->
                // rectángulo
                g.fillRect(centroX - size / 2, centroY - size / 2, size, size);

            case 2 -> {
                // triángulo
                Polygon triangulo = new Polygon();
                triangulo.addPoint(centroX, centroY - size / 2);
                triangulo.addPoint(centroX - size / 2, centroY + size / 2);
                triangulo.addPoint(centroX + size / 2, centroY + size / 2);
                g.fillPolygon(triangulo);
            }
            case 3 -> {
                // pentágono
                Polygon pentagono = new Polygon();
                for (int i = 0; i < 5; i++) {
                    pentagono.addPoint((int) (centroX + size / 2 * Math.cos(i * 2 * Math.PI / 5)),
                            (int) (centroY + size / 2 * Math.sin(i * 2 * Math.PI / 5)));
                }
                g.fillPolygon(pentagono);                
            }
                
            case 4 -> {
                // hexágono
                Polygon hexagono = new Polygon();
                for (int i = 0; i < 6; i++) {
                    hexagono.addPoint((int) (centroX + size / 2 * Math.cos(i * 2 * Math.PI / 6)),
                            (int) (centroY + size / 2 * Math.sin(i * 2 * Math.PI / 6)));
                }
                g.fillPolygon(hexagono);               
            }                
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Figuras random");
        frame.setSize(600, 600);

        EjemploRepaintFiguras panel = new EjemploRepaintFiguras();
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // repaint del panel cada 500ms
        Timer timer = new Timer(100, e -> panel.repaint());
        timer.start();
    }
}
