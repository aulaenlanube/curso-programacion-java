package aulaenlanube.tema9.ejemplos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.*;

public class EjemploRepaintHora extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        LocalDateTime horaActual  = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String textoHora  = horaActual.format(formatter);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Hola, Mundo! son las " + textoHora, 50, 50);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Hola Mundo con reloj");
        EjemploRepaintHora panel = new EjemploRepaintHora();
        ventana.add(panel);
        ventana.setSize(400, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

        Timer reloj = new Timer(1000, e -> panel.repaint());
        reloj.start();
    }
} 
