
import java.awt.*;
import java.awt.image.BufferedImage;

public class EjemploGraphicsConfiguration {

    public static void main(String[] args) {

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        ImageCapabilities ic = gc.getImageCapabilities();

        if (ic.isAccelerated()) {
            System.out.println("La configuración gráfica soporta aceleración de hardware ");
        }

        // crear imágenes compatibles
        BufferedImage imagen = gc.createCompatibleImage(500, 300);
        imagen.getSource();

        //creamos ventana a partir de la configuración del dispositivo
        Window ventana = new Window(new Frame(gc));
        ventana.setVisible(false);

    }

}
