package aulaenlanube.tema8.ejemplos.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

public class EjemploMySQL_Encriptacion {

    public static void main(String[] args) {

        try {

            // realizamos conexión
            Connection conex = ConexionBD.conectar("usuarios");

            verificarPwd(conex, "tom2@tom.com", "tom");

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void insertarUsuario(Connection conex, String correo, String pwd) {

        try {

            // encriptamos la contraseña
            String pwdEncriptada = BCrypt.hashpw(pwd, BCrypt.gensalt());

            // preparamos y ejecutamos insert
            String query = "INSERT INTO usuario VALUES (?,?)";
            PreparedStatement queryInsert = conex.prepareStatement(query);
            queryInsert.setString(1, correo);
            queryInsert.setString(2, pwdEncriptada);
            queryInsert.executeUpdate();
            System.out.println("El usuario con correo " + correo + " se ha insertado correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean verificarPwd(Connection conex, String correo, String pwd) {
        try {
            // preparamos consulta SQL para obtener la contraseña encriptada
            String query = "SELECT pwd FROM usuario WHERE correo = ?";
            PreparedStatement querySelect = conex.prepareStatement(query);
            querySelect.setString(1, correo);
            ResultSet resultado = querySelect.executeQuery();

            if (resultado.next()) {
                String pwdAlmacenada = resultado.getString("pwd");

                // verificamos si la contraseña recibida coincide
                if (BCrypt.checkpw(pwd, pwdAlmacenada)) {
                    System.out.println("La contraseña es válida");
                    return true;
                } else {
                    System.out.println("La contraseña no es válida");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("No existe ningún contacto con el correo " + correo);
        return false;
    }

}
