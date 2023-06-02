package aulaenlanube.tema8.ejemplos.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemploMySQL_Select {

    public static void main(String[] args) {

        try {

            // realizamos conexión
            Connection conex = ConexionBD.conectar("agenda");              

            // preparamos consulta y la ejecutamos
            String query = "SELECT nombre, correo FROM contacto";
            PreparedStatement instruccion = conex.prepareStatement(query);
            ResultSet resultado = instruccion.executeQuery();

            //analizamos el resultado de la consulta
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String correo = resultado.getString("correo");
                System.out.println(nombre+" ("+correo+")");
            }           

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
