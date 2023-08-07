/**
 * EJERCICIOS FINALES REPASO JAVA SWING
 * 
 * Crear un cronómetro con segundos y centésimas. Deberá tener 2 JButton, para iniciar y reiniciar el tiempo. 
 * Al pulsar el botón de iniciar, dicho botón permitirá pausar el tiempo, mientras que al pulsar en reiniciar, el contador pasará a estar a cero y se detendrá. 
 * Ampliar la aplicación para que si pausamos con el contador de centésimas en 00, nos muestre un mensaje de diálogo.
 *  
 */

package aulaenlanube.tema9.ejercicios;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DecimalFormat;

public class CronometroPrecision extends JFrame {

    private long inicioTiempo;
    private long tiempoPausado;
    private boolean corriendo;
    private JLabel label;
    private Timer timer;
    private JButton iniciarPausar;
    private JButton reiniciar;

    public CronometroPrecision() {

        inicioTiempo = 0;
        tiempoPausado = 0;
        corriendo = false;

        // configuración del JFrame
        setTitle("Cronómetro");
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // etiqueta del cronómetro
        label = new JLabel("00:00");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        add(label);

        // botón iniciar-pausar
        iniciarPausar = new JButton("Iniciar");
        add(iniciarPausar);

        // botón reiniciar
        reiniciar = new JButton("Reiniciar");
        add(reiniciar);

        // evento del contador cada 10ms
        timer = new Timer(10, e -> {
            if (corriendo) {
                long ahora = System.currentTimeMillis();
                long transcurrido = tiempoPausado + (ahora - inicioTiempo);

                DecimalFormat df = new DecimalFormat("00");
                long segundos = (transcurrido / 1000) % 60;
                long centesimas = (transcurrido / 10) % 100;

                label.setText(df.format(segundos) + ":" + df.format(centesimas));
            }
        });

        // evento iniciar-pausar
        iniciarPausar.addActionListener(e -> {
            if (corriendo) {
                tiempoPausado += System.currentTimeMillis() - inicioTiempo;
                corriendo = false;
                iniciarPausar.setText("Iniciar");

                long transcurrido = tiempoPausado;
                long centesimas = (transcurrido / 10) % 100;
                if (centesimas == 0) {
                    JOptionPane.showMessageDialog(null, "Cronómetro en 0 centésimas", "Mensaje",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                inicioTiempo = System.currentTimeMillis();
                corriendo = true;
                iniciarPausar.setText("Pausar");
                timer.start();
            }
        });

        // evento reiniciar
        reiniciar.addActionListener(e -> {
            inicioTiempo = System.currentTimeMillis();
            tiempoPausado = 0;
            corriendo = false;
            iniciarPausar.setText("Iniciar");
            label.setText("00:00");
        });
    }

    public static void main(String[] args) {
        new CronometroPrecision().setVisible(true);
    }
}
