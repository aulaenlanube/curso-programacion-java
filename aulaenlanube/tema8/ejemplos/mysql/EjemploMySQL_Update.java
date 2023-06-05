package aulaenlanube.tema8.ejemplos.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EjemploMySQL_Update {

    public static void main(String[] args) {
        try {

            // realizamos conexión
            Connection conex = ConexionBD.conectar("agenda");

            // insertamos contacto
            String query = "UPDATE contacto SET nombre = ? WHERE nombre = ?";
            PreparedStatement queryUpdate = conex.prepareStatement(query);
            queryUpdate.setString(1, "pepe");
            queryUpdate.setString(2, "pepe2");
            int resultado = queryUpdate.executeUpdate();

            // analizamos el resultado del insert
            if (resultado > 0)
                System.out.println("Se han modificado " + resultado + " contactos correctamente");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
