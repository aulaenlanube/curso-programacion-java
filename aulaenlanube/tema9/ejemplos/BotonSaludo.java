package aulaenlanube.tema9.ejemplos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// creamos una clase para implementar ActionListener
public class BotonSaludo implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        // acción al hacer click
        System.out.println("Hola mundo desde un botón: Clase BotonSaludo");
    }
}