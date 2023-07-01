package aulaenlanube.tema9.ejemplos;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class EjemploComponentes {

    public static void main(String[] args) {

//creamos la ventana
JFrame ventana = new JFrame("Ventana con componentes");
ventana.setLayout(new FlowLayout());
ventana.setSize(700, 500);

//creamos JLabel
JLabel jLabel = new JLabel("Esto es un JLabel");
ventana.add(jLabel);

//creamos JButton
JButton jButton = new JButton("Botón");
ventana.add(jButton);

//creamos JTextField
JTextField jTextField = new JTextField("Esto es un JTextField");
ventana.add(jTextField);

//creamos JCheckBox
JCheckBox jCheckBox = new JCheckBox("Esto es JCheckBox");
ventana.add(jCheckBox);

//creamos JRadioButton
JRadioButton jRadioButton = new JRadioButton("Esto es JRadioButton");
ventana.add(jRadioButton);

//menu de opciones
JMenuBar barraMenu = new JMenuBar();
JMenu menu = new JMenu("Esto es un JMenu");
menu.add(new JMenuItem("Esto la opción 1 del primer menú"));
menu.add(new JMenuItem("Esto la opción 2 del primer menú"));

JMenu menu2 = new JMenu("Esto es otro JMenu");
menu2.add(new JMenuItem("Esto la opción 1 del segundo menú"));
menu2.add(new JMenuItem("Esto la opción 2 del segundo menú"));

barraMenu.add(menu);
barraMenu.add(menu2);
ventana.setJMenuBar(barraMenu);

//mostrarmos ventana y configuramos el cierre
ventana.setVisible(true);
ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
