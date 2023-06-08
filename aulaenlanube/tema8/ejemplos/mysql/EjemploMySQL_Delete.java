package aulaenlanube.tema8.ejemplos.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EjemploMySQL_Delete {

    public static void main(String[] args) {
        
            try {
    
                // realizamos conexión
                Connection conex = ConexionBD.conectar("agenda");
    
                // insertamos contacto
                String query = "DELETE FROM contacto WHERE edad = ?";
                PreparedStatement queryDelete = conex.prepareStatement(query);
                queryDelete.setInt(1, 18);
                int resultado = queryDelete.executeUpdate();
    
                // analizamos el resultado del insert
                if (resultado > 0)
                    System.out.println("Se han borrado " + resultado + " contactos correctamente");
    
            } catch (SQLException e) {
                System.out.println(e);
            }
        

    }
}
