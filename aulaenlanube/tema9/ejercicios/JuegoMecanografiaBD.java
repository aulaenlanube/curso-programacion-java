package aulaenlanube.tema9.ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class JuegoMecanografiaBD {

    // datos conexión con la BD
    private static final String USER = "root";
    private static final String PWD = "";
    private static final String URL = "jdbc:MySQL://localhost/juegomeca";

    // conexión con la BD
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PWD);
    }

    // insertamos una nueva puntuación
    public static void insertarPuntuacion(String nombre, int puntuacion, double tiempo) {

        String sql = "INSERT INTO puntuaciones(nombre, puntuacion, tiempo) VALUES(?,?,?)";

        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setInt(2, puntuacion);
            pstmt.setDouble(3, tiempo);
            pstmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // obtenemos las 10 mejores puntuaciones
    public static String obtenerMejoresPuntuaciones() {

        String resultado = "MEJORES TIEMPOS\n-----------------------------\n";
        String sql = "SELECT nombre, puntuacion, tiempo FROM puntuaciones ORDER BY puntuacion DESC, tiempo ASC LIMIT 10";

        try (Connection conn = conectar();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int puntuacion = rs.getInt("puntuacion");
                double tiempo = rs.getDouble("tiempo");
                String entrada = nombre + " -- " + tiempo + "s (" + puntuacion + "aciertos)\n";
                resultado += entrada;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return resultado;
    }
}
