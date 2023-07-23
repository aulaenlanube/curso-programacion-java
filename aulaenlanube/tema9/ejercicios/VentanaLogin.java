package aulaenlanube.tema9.ejercicios;

import javax.swing.*;
import java.awt.*;
import java.util.regex.*;

public class VentanaLogin extends JFrame {

    private JTextField campoNombre;
    private JPasswordField campoPass, campoVerificarPass;
    private JLabel etiquetaNombre, etiquetaPass, etiquetaVerificarPass;
    private JButton botonLogin;    

    public VentanaLogin() {
        
        // configurar ventana
        setTitle("Ventana de Login");
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));

        // crear componentes
        etiquetaNombre = new JLabel("Nombre de usuario: ");
        campoNombre = new JTextField(20);

        etiquetaPass = new JLabel("Contraseña: ");
        campoPass = new JPasswordField(20);

        etiquetaVerificarPass = new JLabel("Verificar contraseña: ");
        campoVerificarPass = new JPasswordField(20);

        // crear botón y acción
        botonLogin = new JButton("Login");
        botonLogin.addActionListener(e -> {
            Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}");
            Matcher matcher = pattern.matcher(String.valueOf(campoPass.getPassword()));
            if (!matcher.matches()) {
                System.out.println("La contraseña debe contener al menos 8 caracteres, una mayúscula, una minúscula y un número.");
            } else if (!String.valueOf(campoPass.getPassword()).equals(String.valueOf(campoVerificarPass.getPassword()))) {
                System.out.println("Las contraseñas no coinciden.");
            } else {
                System.out.println("Inicio de sesión exitoso.");                
            }
        });

        // añadir componentes
        add(etiquetaNombre);
        add(campoNombre);
        add(etiquetaPass);
        add(campoPass);
        add(etiquetaVerificarPass);
        add(campoVerificarPass);
        add(botonLogin);

        // mostramos JFrame y configuramos cierre
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new VentanaLogin();
    }
}
