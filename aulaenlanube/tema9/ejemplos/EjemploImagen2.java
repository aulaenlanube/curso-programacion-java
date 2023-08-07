package aulaenlanube.tema9.ejemplos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class EjemploImagen2 {

    public static void main(String[] args) {

       try {
            URL urlImagen = new URL("https://aulaenlanube.com/wp-content/uploads/2021/03/JAVA-AULAENLANUBE-1024x576.jpg");
            BufferedImage imagen = ImageIO.read(urlImagen);
            JFrame ventana = new JFrame();    
            ventana.setSize(imagen.getWidth(),imagen.getHeight());             

            // creamos un JPanel personalizado para manejar el redibujado de la imagen
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(imagen, 0, 0, this.getWidth()/2, this.getHeight()/2, this);
                }
            };

            ventana.add(panel);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setVisible(true);            

        } catch (IOException ex) {
            System.out.println("Error al cargar la imagen");            
        }
    }    
}
