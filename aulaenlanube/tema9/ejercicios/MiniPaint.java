package aulaenlanube.tema9.ejercicios;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class MiniPaint {
    private JFrame frame;
    private DrawArea drawArea;
    private Path2D.Float currentPath;
    private Color currentColor = Color.BLACK; // Color inicial

    public MiniPaint() {
        frame = new JFrame("Mini Paint");
        drawArea = new DrawArea();

        frame.add(drawArea, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);

        drawArea.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    showColorPicker(e.getX(), e.getY());
                } else {
                    currentPath = new Path2D.Float();
                    currentPath.moveTo(e.getX(), e.getY());
                    drawArea.addPath(currentPath, currentColor);
                }
            }
        });

        drawArea.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (!SwingUtilities.isRightMouseButton(e)) {
                    currentPath.lineTo(e.getX(), e.getY());
                    drawArea.repaint();
                }
            }
        });
    }

    private void showColorPicker(int x, int y) {
        JPopupMenu colorMenu = new JPopupMenu();

        JMenuItem redItem = new JMenuItem("Rojo");
        redItem.addActionListener(e -> currentColor = Color.RED);
        colorMenu.add(redItem);

        JMenuItem blueItem = new JMenuItem("Azul");
        blueItem.addActionListener(e -> currentColor = Color.BLUE);
        colorMenu.add(blueItem);

        JMenuItem blackItem = new JMenuItem("Negro");
        blackItem.addActionListener(e -> currentColor = Color.BLACK);
        colorMenu.add(blackItem);

        colorMenu.show(drawArea, x, y);
    }

    public static void main(String[] args) {
        new MiniPaint();
    }

    private class DrawArea extends JComponent {
        private class ColoredPath {
            public Path2D path;
            public Color color;

            ColoredPath(Path2D path, Color color) {
                this.path = path;
                this.color = color;
            }
        }

        private ArrayList<ColoredPath> paths = new ArrayList<>();

        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            for (ColoredPath cp : paths) {
                g2.setColor(cp.color);
                g2.draw(cp.path);
            }
        }

        public void addPath(Path2D path, Color color) {
            paths.add(new ColoredPath(path, color));
            repaint();
        }
    }
}
