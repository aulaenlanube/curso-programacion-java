package aulaenlanube.tema8.ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionMySQL {

    // Datos conexión con la BD
    public static final String USER = "root";
    public static final String PWD = "";
    public static final String URL = "jdbc:MySQL://localhost/agenda";

    // Datos del contacto a insertar
    public static final String NOMBRE = "Pepe";
    public static final String CORREO = "Pepe@pepe.com";
    public static final int TELF = 123456789;

    public static void main(String[] args) {

        try {

            // realizamos connexión
            Connection conex = DriverManager.getConnection(URL, USER, PWD);

            // insertamos contacto
            String queryInsert = "INSERT INTO contacto(nombre, correo) VALUES ('" + NOMBRE + "', '" + CORREO + "')";
            conex.createStatement().executeUpdate(queryInsert);

            // consultamos contactos
            String querySelect = "SELECT nombre, correo FROM contacto";
            ResultSet resultado = conex.createStatement().executeQuery(querySelect);

            // recorremos los datos obtenidos
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String correo = resultado.getString("correo");
                System.out.println("NOMBRE: " + nombre);
                System.out.println("CORREO: " + correo);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
