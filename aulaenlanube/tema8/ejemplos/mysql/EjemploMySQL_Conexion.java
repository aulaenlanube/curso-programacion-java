package aulaenlanube.tema8.ejemplos.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EjemploMySQL_Conexion {

    // Datos conexión con la BD
    public static final String USER = "root";
    public static final String PWD = "";
    public static final String URL = "jdbc:MySQL://localhost/agenda";


    public static void main(String[] args) {

        try {

            // realizamos connexión
            Connection conex = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Se ha conectado correctamente");
            conex.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
