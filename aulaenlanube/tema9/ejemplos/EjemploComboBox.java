package aulaenlanube.tema9.ejemplos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EjemploComboBox {

    public static void main(String[] args) {
        
        JFrame ventana = new JFrame("Ejemplo ComboBox");
        ventana.setSize(800, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creamos un JComboBox
        String[] opciones = { "1DAM", "1DAW", "2DAM", "2DAW" };
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        // Crea un JTextField
        JTextField textField = new JTextField(10); // 10 es el ancho

        // creamos un JButton
        JButton boton = new JButton("Matricular");

        // creamos un JLabel
        JLabel label = new JLabel("");

        //evento al seleccionar opción del comboBox
        comboBox.addActionListener(e -> {
            System.out.println("Valor del ComboBox modificado: " + comboBox.getSelectedItem());
            label.setText("Valor del ComboBox modificado: " + comboBox.getSelectedItem());
        });

        // evento al pulsar el botón
        boton.addActionListener(e -> {           

            String nombre = textField.getText();
            if (nombre.length() > 2) {
                System.out.println(nombre + " se ha matriculado en el grupo " + comboBox.getSelectedItem());
                label.setText(nombre + " se ha matriculado en el grupo " + comboBox.getSelectedItem());
                ponerLetrasNegro(label);
            } else {
                System.out.println("ERROR al matricular: El nombre debe tener como mínimo 3 letras");
                label.setText("ERROR al matricular: El nombre debe tener como mínimo 3 letras");
                ponerLetrasRojo(label);                
            }
        });

        // agregamos componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(textField);
        panel.add(comboBox);
        panel.add(boton);
        panel.add(label);

        // Asegurar que los componentes estén centrados
        panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);


        // Añadir el panel al marco y hacerlo visible
        ventana.setLayout(new FlowLayout());
        ventana.add(panel, BorderLayout.CENTER);

        //ventana.add(new JButton("South"), BorderLayout.SOUTH);
        //ventana.add(new JButton("North"), BorderLayout.NORTH);
        //ventana.add(new JButton("East"), BorderLayout.EAST);
        //ventana.add(new JButton("West"), BorderLayout.WEST);
        //ventana.add(new JButton("Center"), BorderLayout.CENTER);

        //establece la ventana al centro de la pantalla
        ventana.setLocationRelativeTo(null);

        // mostramos ventana
        ventana.setVisible(true);
    }

    public static void ponerLetrasRojo(JLabel label) {

        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.RED);

    }

    public static void ponerLetrasNegro(JLabel label) {

        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.BLACK);
        
    }
}