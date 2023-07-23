package aulaenlanube.tema9.ejercicios;

import javax.swing.*;
import java.awt.*;

public class SumadorEnteros extends JFrame {

    private JTextField campo1, campo2;
    private JLabel suma, resultado;
    private JButton botonSumar;

    public SumadorEnteros() {

        // configuramos ventana
        setTitle("Sumador de Enteros");
        setSize(400, 100);
        setLayout(new FlowLayout());

        // creamos cajas de texto y etiquetas
        campo1 = new JTextField(4);
        campo2 = new JTextField(4);
        suma = new JLabel("+");
        resultado = new JLabel(" = ");

        // creamos botón y asignamos acción
        botonSumar = new JButton("Sumar");
        botonSumar.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(campo1.getText());
                int num2 = Integer.parseInt(campo2.getText());
                resultado.setText(" =  " + (num1 + num2));
            } catch (NumberFormatException ex) {
                // mensaje de error
                JOptionPane.showMessageDialog(null, "Debes introducir números enteros.", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // añadir los componentes a la ventana
        add(botonSumar);
        add(campo1);
        add(suma);
        add(campo2);
        add(resultado);

        // mostramos JFrame y configuramos cierre
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SumadorEnteros();
    }
}
