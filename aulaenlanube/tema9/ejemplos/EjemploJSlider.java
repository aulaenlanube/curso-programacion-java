package aulaenlanube.tema9.ejemplos;

import javax.swing.*;
import java.awt.*;

public class EjemploJSlider extends JFrame {

    private int diametroCirculo = 200;
    private Color colorCirculo = Color.GRAY;

    private JSlider sliderRojo;
    private JSlider sliderVerde;
    private JSlider sliderAzul;

    public EjemploJSlider() {

        // configuramos JFrame
        setTitle("Sliders colores");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        // configuramos JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        // creamos los 3 sliders
        sliderRojo = new JSlider(0, 255);
        sliderVerde = new JSlider(0, 255);
        sliderAzul = new JSlider(0, 255);
        ;

        // añadimos etiquetas y sliders
        panel.add(new JLabel("R:", JLabel.RIGHT));
        panel.add(sliderRojo);
        panel.add(new JLabel("G:", JLabel.RIGHT));
        panel.add(sliderVerde);
        panel.add(new JLabel("B:", JLabel.RIGHT));
        panel.add(sliderAzul);

        // añadimos panel
        add(panel, BorderLayout.SOUTH);

        // añadimos listeners a los 3 sliders
        sliderRojo.addChangeListener(e -> cambiarColor()); //mostrar ejemplo con ChangeEvent e
        sliderVerde.addChangeListener(e -> cambiarColor());
        sliderAzul.addChangeListener(e -> cambiarColor());

        // visibilidad y cierre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void cambiarColor() {

        int rojo = sliderRojo.getValue();
        int verde = sliderVerde.getValue();
        int azul = sliderAzul.getValue();

        colorCirculo = new Color(rojo, verde, azul);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(colorCirculo);
        g.fillOval(150, 150, diametroCirculo, diametroCirculo);
    }

    public static void main(String[] args) {
        new EjemploJSlider();
    }
}
