package aulaenlanube.tema9.ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class JuegoMecanografia {

    // cantidad de letras que se mostrarán en la partida
    private final int CANTIDAD_RONDAS = 30;

    // atributos
    private JFrame ventana;
    private JLabel letra;
    private JButton boton;
    private Timer cronometro;
    private int puntuacion;
    private long tiempoInicio;
    private int letraActual;
    private int rondaActual;

    // constructor
    public JuegoMecanografia() {

        // datos ventana
        ventana = new JFrame("Juego de Mecanografía");
        ventana.setSize(400, 300);
        ventana.setLayout(new BorderLayout());

        // letra
        letra = new JLabel("", SwingConstants.CENTER);
        letra.setFont(new Font("Arial", Font.BOLD, 100));
        ventana.add(letra, BorderLayout.CENTER);

        // botón
        boton = new JButton("Iniciar Partida");
        boton.addActionListener(e -> iniciarReiniciar());
        ventana.add(boton, BorderLayout.SOUTH);

        // evento al pulsar tecla
        ventana.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                comprobarLetra(e.getKeyChar());
            }
        });

        // visibilidad y cierre
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    // iniciamos la partida
    public void iniciarJuego() {
        puntuacion = 0;
        rondaActual = 0;
        tiempoInicio = System.currentTimeMillis();
        generarLetraAleatoria();
        cronometro = new Timer(10, e -> {
            if (rondaActual > CANTIDAD_RONDAS)
                finalizarJuego();
        });
        cronometro.start();
        ventana.requestFocus();
    }

    // reiniciamos datos y paramos todo
    public void reiniciarJuego() {
        cronometro.stop();
        puntuacion = 0;
        rondaActual = 0;
        letra.setText("");
        ventana.requestFocus();
    }

    // alternar entre iniciar y reiniciar
    public void iniciarReiniciar() {
        if (boton.getText().equals("Iniciar Partida")) {
            iniciarJuego();
            boton.setText("Reiniciar Partida");
        } else {
            reiniciarJuego();
            boton.setText("Iniciar Partida");
        }
    }

    // método que se modifica para guardar datos en la BD
    public void finalizarJuego() {

        // finalizamos partida
        cronometro.stop();
        boton.setText("Iniciar Partida");
        long tiempoFinal = System.currentTimeMillis() - tiempoInicio;

        // pedimos nombre y guardamos la puntuación
        String nombre = JOptionPane.showInputDialog(ventana, "Introduce tu nombre:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            JuegoMecanografiaBD.insertarPuntuacion(nombre, puntuacion, tiempoFinal / 1000.0);
        }

        // mostramos puntuación y botón de mejores tiempos
        Object[] opciones = { "Ver mejores tiempos", "Cerrar" };
        int respuesta = JOptionPane.showOptionDialog(
                ventana,
                "Juego terminado!\nAciertos: " + puntuacion + "\nTiempo: " + tiempoFinal / 1000.0 + "s",
                "Fin del Juego",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        // si pulsamos en "Ver mejores tiempos"
        if (respuesta == 0) {
            String mejoresPuntuaciones = JuegoMecanografiaBD.obtenerMejoresPuntuaciones();
            JOptionPane.showMessageDialog(ventana, mejoresPuntuaciones, "Mejores Tiempos",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        reiniciarJuego();
    }

    // comprobamos si la letra pulsada coincide
    public void comprobarLetra(char letra) {
        if (cronometro.isRunning()) {
            if (letra == letraActual) {
                puntuacion++;
            }
            generarLetraAleatoria();
        }
    }

    // genera una letra minúscula
    public void generarLetraAleatoria() {
        Random r = new Random();
        letraActual = r.nextInt(26) + 'a';
        letra.setText(String.valueOf((char) letraActual));
        rondaActual++;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JuegoMecanografia());
    }
}
