package aulaenlanube.tema9.ejercicios;

import javax.swing.*;
import java.awt.*;

public class ConversorMonedas extends JFrame {

    private JTextField campo;
    private JLabel resultado;
    private JButton botonConvertir; 
    private JComboBox<String> opciones;

    public ConversorMonedas() {

        // configurar JFrame
        setTitle("Conversor de monedas");
        setSize(400, 100);
        setLayout(new FlowLayout());

        // añadir componentes
        campo = new JTextField(10);
        resultado = new JLabel("");
        opciones = new JComboBox<>(new String[] { "€ a $", "$ a €" });

        // botón y acción
        botonConvertir = new JButton("Convertir");
        botonConvertir.addActionListener(e -> {
            try {
                double cantidad = Double.parseDouble(campo.getText());
                String seleccion = opciones.getSelectedItem().toString();
                String mensaje = "";

                if (seleccion.equals("€ a $"))
                    mensaje = cantidad + "€ equivalen a " + (Math.round(cantidad / 0.91 * 100.0) / 100.0) + "$";
                else
                    mensaje = cantidad + "$ equivalen a " + (Math.round(cantidad * 0.91 * 100.0) / 100.0) + "€";

                resultado.setText(mensaje);

            } catch (NumberFormatException ex) {
                // mensaje de error
                resultado.setText("Debes introducir una cantidad numérica válida");
            }
        });

        // añadir los componentes a la ventana
        add(campo);
        add(opciones);
        add(botonConvertir);
        add(resultado);

        // mostrar JFrame y configurar cierre
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ConversorMonedas();
    }
}
