package aulaenlanube.tema9.minipaint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import javax.swing.JComponent;

public class AreaDibujo extends JComponent {

    private ArrayList<Trazo> trazos;

    public AreaDibujo() {
        trazos = new ArrayList<>();
    }

    public void agregarTrazo(Path2D trazo, Color color, float anchoTrazo) {
        trazos.add(new Trazo(trazo, color, anchoTrazo));
        repaint();
    }

    public void borrarTrazos() {
        trazos.clear();
        repaint();
    }

    public void borrarUltimoTrazo() {
        if (trazos.size() > 0)
            trazos.remove(trazos.size() - 1);
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (Trazo trazoActual : trazos) {
            g2.setColor(trazoActual.color);
            g2.setStroke(new BasicStroke(trazoActual.anchoTrazo));
            g2.draw(trazoActual.trazo);
        }
    }

    private class Trazo {

        private Path2D trazo;
        private Color color;
        private float anchoTrazo;

        public Trazo(Path2D trazo, Color color, float anchoTrazo) {
            this.trazo = trazo;
            this.color = color;
            this.anchoTrazo = anchoTrazo;
        }

    }
}