package aulaenlanube.tema9.ejemplos;

import java.awt.Component;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Rectangle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EjemploJPanel {

    public static void main(String[] args) {

        
        // Obtener la configuración de la pantalla
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();

        // Obtener las dimensiones de la pantalla
        Rectangle screenBounds = gc.getBounds();

        // Crear una nueva ventana
        JFrame ventana = new JFrame(gc);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecer el tamaño de la ventana al 50% de la pantalla
        int windowWidth = (int) (screenBounds.width * 0.5);
        int windowHeight = (int) (screenBounds.height * 0.5);
        ventana.setSize(windowWidth, windowHeight);

        // Fijamos el tipo de Layout
        ventana.setLayout(new GridBagLayout());

        // agregamos etiqueta
        JLabel texto = new JLabel("Texto centrado");
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);

        // agregamos bóton
        JButton boton = new JButton("Botón centrado");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // agregamos panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // agregamos label y botón al panel
        panel.add(texto);
        panel.add(boton);

        // agregamos panel a la ventana
        ventana.add(panel);

        //establece la ventana al centro de la pantalla
        ventana.setLocationRelativeTo(null);

        // mostramos ventana
        ventana.setVisible(true);
    }
}
