package aulaenlanube.tema9.ejemplos;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EjemploJDialog {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Ventana con JDialog");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        ventana.setVisible(true);

        JDialog dialog = new JDialog();
        dialog.setTitle("Simple JDialog");
        dialog.setSize(400, 200);
        dialog.setLayout(new FlowLayout());
        dialog.add(new JLabel("Esto es un JDialog sencillo y modal"));
        dialog.setLocationRelativeTo(null); // centra el JDialog en la pantalla        

        JButton botonOK = new JButton("OK");
        JButton botonCancelar = new JButton("Cancelar");
        botonOK.addActionListener(e -> System.out.println("Has pulsado OK"));
        botonCancelar.addActionListener(e -> {
            System.out.println("Has pulsado Cancelar");
            dialog.dispose();
        });
        
        dialog.add(botonOK);
        dialog.add(botonCancelar);
        dialog.setModal(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}
