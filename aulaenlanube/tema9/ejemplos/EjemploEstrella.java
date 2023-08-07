package aulaenlanube.tema9.ejemplos;

import javax.swing.*;
import java.awt.*;

public class EjemploEstrella extends JPanel {
    
    private static final int RADIUS = 150;
    private static final int POINT_COUNT = 5;
    private static final int SKIP = 2;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int[] xPoints = new int[POINT_COUNT];
        int[] yPoints = new int[POINT_COUNT];

        for (int i = 0; i < POINT_COUNT; i++) {
            double angle = 2 * Math.PI * i / POINT_COUNT;
            xPoints[i] = (int) (centerX + RADIUS * Math.cos(angle));
            yPoints[i] = (int) (centerY + RADIUS * Math.sin(angle));
        }

        int lastX = xPoints[0];
        int lastY = yPoints[0];
        for (int i = 0; i <= POINT_COUNT; i++) {
            g.drawLine(lastX, lastY, xPoints[(i * SKIP) % POINT_COUNT], yPoints[(i * SKIP) % POINT_COUNT]);
            lastX = xPoints[(i * SKIP) % POINT_COUNT];
            lastY = yPoints[(i * SKIP) % POINT_COUNT];
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new EjemploEstrella());
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}