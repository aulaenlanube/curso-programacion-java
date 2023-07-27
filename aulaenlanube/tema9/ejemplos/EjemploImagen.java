package aulaenlanube.tema9.ejemplos;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EjemploImagen {

    public static void main(String[] args) throws IOException {

        // creamos un JFrame
        JFrame ventana = new JFrame();        
        ventana.setSize(1000, 600);  
        ventana.setLayout(new FlowLayout());                 
        
        // creamos la imagen
        BufferedImage imagenOriginal = ImageIO.read(new File("aulaenlanube/tema9/imagenes/logo-aulaenlanube.jpg"));

        // redimensionamos la imagen
        Image imagenEscalada1 = imagenOriginal.getScaledInstance(300, 300, Image.SCALE_FAST);  
        Image imagenEscalada2 = imagenOriginal.getScaledInstance(300, 300, Image.SCALE_SMOOTH);        
        
        // creamos un JLabel y fijamos la imagen sobre él
        JLabel labelImagen1 = new JLabel(new ImageIcon(imagenEscalada1));
        JLabel labelImagen2 = new JLabel(new ImageIcon(imagenEscalada2));


        labelImagen1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Has pulsado en la imagen de la izquierda en las coordenadas ("+e.getX()+", "+e.getY()+")");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Has pulsado con el foco en la imagen de la izquierda");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Has soltado el botón del ratón");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Has entrado en la imagen de la izquierda");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Has salido de la imagen de la izquierda");
            }
            
        });

        // añadimos el JLabel al JFrame, visible y cierre
        ventana.add(labelImagen1);    
        ventana.add(labelImagen2);   
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }    
}
