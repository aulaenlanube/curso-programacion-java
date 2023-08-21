package aulaenlanube.tema9.minipaint;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MiniPaint {

    private JFrame ventana;
    private AreaDibujo areaDibujo;
    private Path2D.Float trazoActual;

    private Color colorActual = Color.BLACK; // color de inicio
    private float anchoTrazoActual = 1.0f; // ancho inicial del trazo

    public MiniPaint() {

        ventana = new JFrame("Mini Paint");
        ventana.setSize(600, 600);
        areaDibujo = new AreaDibujo();
        ventana.add(areaDibujo, BorderLayout.CENTER);

        //evento al hacer clic
        areaDibujo.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                //si es clic derecho, mostramos menú contextual
                if (SwingUtilities.isRightMouseButton(e)) {
                    mostrarMenuContextual(e.getX(), e.getY());
                } 
                //si es clic izquierdo, creamos un nuevo trazo
                else {
                    trazoActual = new Path2D.Float();
                    trazoActual.moveTo(e.getX(), e.getY());
                    areaDibujo.agregarTrazo(trazoActual, colorActual, anchoTrazoActual);
                }
            }
        });

        //evento al arrastrar
        areaDibujo.addMouseMotionListener(new MouseMotionAdapter() {
            
            public void mouseDragged(MouseEvent e) {
                //si mantenemos clic izquierdo, añadimos puntos al trazo actual
                if (!SwingUtilities.isRightMouseButton(e)) {
                    trazoActual.lineTo(e.getX(), e.getY());
                    areaDibujo.repaint();
                }
            }
        });

        // menu de Opciones
        JMenuBar barraPrincipal = new JMenuBar();
        JMenu menuOpciones = new JMenu("Opciones");

        // opción guardar
        JMenuItem opcionGuardar = new JMenuItem("Guardar imagen");
        opcionGuardar.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(ventana);
            if (seleccion == JFileChooser.APPROVE_OPTION)
                guardarImagen(new File(fileChooser.getSelectedFile().getAbsolutePath() + ".jpg"));
        });

        // opción limpiar
        JMenuItem opcionLimpiar = new JMenuItem("Borrar todo");
        opcionLimpiar.addActionListener(e -> {
            areaDibujo.borrarTrazos();
        });

        // añadimos opciones y menú
        menuOpciones.add(opcionGuardar);
        menuOpciones.add(opcionLimpiar);
        barraPrincipal.add(menuOpciones);
        ventana.setJMenuBar(barraPrincipal);

        // visibilidad y cierre
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }

    private void mostrarMenuContextual(int x, int y) {

        JPopupMenu menuContextual = new JPopupMenu();

        // Opciones de color
        JMenuItem opcionRojo = new JMenuItem("Rojo");
        opcionRojo.addActionListener(e -> colorActual = Color.RED);
        menuContextual.add(opcionRojo);

        JMenuItem opcionAzul = new JMenuItem("Azul");
        opcionAzul.addActionListener(e -> colorActual = Color.BLUE);
        menuContextual.add(opcionAzul);

        JMenuItem opcionNegro = new JMenuItem("Negro");
        opcionNegro.addActionListener(e -> colorActual = Color.BLACK);
        menuContextual.add(opcionNegro);

        // Separador
        menuContextual.addSeparator();

        // Opciones de ancho de trazo
        JMenuItem trazoFino = new JMenuItem("Trazo fino");
        trazoFino.addActionListener(e -> anchoTrazoActual = 1.0f);
        menuContextual.add(trazoFino);

        JMenuItem trazoMedio = new JMenuItem("Trazo medio");
        trazoMedio.addActionListener(e -> anchoTrazoActual = 3.0f);
        menuContextual.add(trazoMedio);

        JMenuItem trazoGrueso = new JMenuItem("Trazo grueso");
        trazoGrueso.addActionListener(e -> anchoTrazoActual = 5.0f);
        menuContextual.add(trazoGrueso);

        menuContextual.show(areaDibujo, x, y);
    }

    private void guardarImagen(File file) {

        BufferedImage imagen = new BufferedImage(areaDibujo.getWidth(), areaDibujo.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = imagen.createGraphics();

        // pintamos el fondo de color blanco, cuando se crea una nueva BufferedImage,
        // por defecto todos los píxeles son negros
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, imagen.getWidth(), imagen.getHeight());

        areaDibujo.paint(g2);
        g2.dispose();

        try {
            ImageIO.write(imagen, "jpg", file);
            JOptionPane.showMessageDialog(ventana, "Imagen guardada exitosamente", "Guardado",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(ventana, "Error al guardar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MiniPaint();
    }
}
