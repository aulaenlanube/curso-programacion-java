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
    
                // insertamos usuario
                insertarUsuario(conex, "pepe@pepe.com", "pepe");
                
            } catch (SQLException e) {
                System.out.println(e);
            }

    }

    public static void insertarUsuario(Connection conex, String correo, String pwd) {
        try {
            // encriptamos la contraseña
            String pwdEncriptada = BCrypt.hashpw(pwd, BCrypt.gensalt());
            // preparamos y ejecutamos insert
            String query = "INSERT INTO contacto VALUES (?,?)";
            PreparedStatement queryInsert = conex.prepareStatement(query);
            queryInsert.setString(1, correo);
            queryInsert.setString(2, pwdEncriptada);
            queryInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean verificarPwd(Connection conex, String correo, String pwd) {
        try {

            // Preparas tu consulta SQL para obtener la contraseña almacenada
             String query = "SELECT pwd FROM usuario WHERE correo = ?";
            PreparedStatement querySelect = conex.prepareStatement(query);
            querySelect.setString(1, correo);
            ResultSet resultado = querySelect.executeQuery();

            if (resultado.next()) {
                String pwdAlmacenada = resultado.getString("pwd");
                // verificamos si la contraseña coincide con la almacenada
                if (BCrypt.checkpw(pwd, pwdAlmacenada))
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
