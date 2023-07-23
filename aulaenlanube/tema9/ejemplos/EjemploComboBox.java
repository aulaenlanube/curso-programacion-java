package aulaenlanube.tema9.ejemplos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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

        // creamos un JComboBox
        Integer[] opciones = { 1,2,3};
        JComboBox<Integer> comboBox = new JComboBox<>(opciones);

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
                label.setForeground(Color.BLACK);
            } else {
                System.out.println("ERROR al matricular: El nombre debe tener como mínimo 3 letras");
                label.setText("ERROR al matricular: El nombre debe tener como mínimo 3 letras");
                label.setForeground(Color.RED);              
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

        // mostramos ventana
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}