package aulaenlanube.tema9.ejemplos;

import javax.swing.*;
import java.awt.*;

public class EjemploJColorChooser extends JFrame {

    private Color colorCirculo = Color.BLACK;
    private int diametro = 200;

    public EjemploJColorChooser() {

        setSize(400, 400);
        setLocationRelativeTo(null); // centramos JFrame

        // botón para abrir el JColorChooser
        JButton boton = new JButton("Elegir color");
        boton.addActionListener(e -> {
            Color colorSeleccionado = JColorChooser.showDialog(null, "Elegir color del círculo", colorCirculo);
            // si elegimos algún color, repintamos
            if (colorSeleccionado != null) {
                colorCirculo = colorSeleccionado;
                repaint();
            }
        });
        add(boton, BorderLayout.SOUTH);

        // visibilidad y cierre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // calculamos las coordenadas para centrar el círculo
        int x = (getWidth() - diametro) / 2;
        int y = (getHeight() - diametro) / 2;

        g.setColor(colorCirculo);
        g.fillOval(x, y, diametro, diametro);
    }

    public static void main(String[] args) {
        new EjemploJColorChooser();
    }
}
