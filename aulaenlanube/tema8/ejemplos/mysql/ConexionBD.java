package aulaenlanube.tema8.ejemplos.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Datos conexión con la BD
    private static final String USER = "root";
    private static final String PWD = "";
    private static final String URL = "jdbc:MySQL://localhost/";

    public static Connection conectar(String nombreBD) throws SQLException {
        return DriverManager.getConnection(URL+nombreBD, USER, PWD);        
    }
}
