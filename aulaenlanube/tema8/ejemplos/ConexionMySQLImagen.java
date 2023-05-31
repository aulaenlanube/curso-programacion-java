package aulaenlanube.tema8.ejemplos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import aulaenlanube.tema4.bordes.Bordes;

public class ConexionMySQLImagen {

    // Datos conexión con la BD
    public static final String USER = "root";
    public static final String PWD = "";
    public static final String URL = "jdbc:MySQL://localhost/agenda";

    // Datos del contacto a insertar
    public static final String NOMBRE = "Pepe";
    public static final String CORREO = "Pepe@pepe.com";
    public static final int TELF = 123456789;
    public static final String RUTA_IMAGEN = "aulaenlanube/tema8/imagenes/default.jpg";

    public static void main(String[] args) {

        try {

            Connection conex = DriverManager.getConnection(URL, USER, PWD);

            // imagen
            final byte[] DATOS_IMAGEN = Files.readAllBytes(Paths.get(RUTA_IMAGEN));

            // insertamos contacto
            String queryInsert = "INSERT INTO contacto(nombre, correo, telf, imagen) VALUES (?,?,?,?)";
            PreparedStatement queryFinalInsert = conex.prepareStatement(queryInsert);
            queryFinalInsert.setString(1, NOMBRE);
            queryFinalInsert.setString(2, CORREO);
            queryFinalInsert.setInt(3, TELF);
            queryFinalInsert.setBytes(4, DATOS_IMAGEN);
            queryFinalInsert.executeUpdate();

            // consultamos contactos
            String querySelect = "SELECT nombre, correo, telf FROM contacto";
            PreparedStatement queryFinalSelect = conex.prepareStatement(querySelect);
            ResultSet resultado = queryFinalSelect.executeQuery();

            // recorremos los datos obtenidos
            while (resultado.next()) {
                String datosContactoActual = "";
                datosContactoActual += "NOMBRE: " + resultado.getString("nombre") + "\n";
                datosContactoActual += "CORREO: " + resultado.getString("correo") + "\n";
                datosContactoActual += "TELF: " + resultado.getInt("telf") + "\n";
                Bordes.mostrarTextoConBordes(datosContactoActual);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
