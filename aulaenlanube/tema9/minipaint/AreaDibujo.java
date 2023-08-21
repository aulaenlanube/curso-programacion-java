package aulaenlanube.tema9.minipaint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import javax.swing.JComponent;

public class AreaDibujo extends JComponent {

    private ArrayList<Trazo> trazos = new ArrayList<>();

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (Trazo cp : trazos) {
            g2.setColor(cp.color);
            g2.setStroke(new BasicStroke(cp.anchoTrazo));
            g2.draw(cp.trazo);
        }
    }

    public void agregarTrazo(Path2D path, Color color, float anchoTrazo) {
        trazos.add(new Trazo(path, color, anchoTrazo));
        repaint();
    }

    public void borrarTrazos() {
        trazos.clear();
        repaint();
    }

    //clase privada Trazo
    private class Trazo {

        public Path2D trazo;
        public Color color;
        public float anchoTrazo;

        public Trazo(Path2D trazo, Color color, float anchoTrazo) {
            this.trazo = trazo;
            this.color = color;
            this.anchoTrazo = anchoTrazo;
        }
    }
}