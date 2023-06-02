package aulaenlanube.tema8.ejemplos.mysql;

import java.sql.Connection;
import java.sql.SQLException;

import aulaenlanube.tema4.generadores.GeneredorNombres;

public class EjemploMySQL_Insert {

    public static void main(String[] args) {

        try {

            // Datos del contacto a insertar
            String nombre = GeneredorNombres.generarConApellido();
            String correo = nombre.replaceAll(" ", "_").toLowerCase() + "@aulaenlanube.com";

            // realizamos conexión
            Connection conex = ConexionBD.conectar();

            // insertamos contacto
            String query = "INSERT INTO contacto(nombre, correo) VALUES ('" + nombre + "', '" + correo + "')";
            int resultado = conex.prepareStatement(query).executeUpdate();

            // analizamos el resultado del insert
            if (resultado == 1)
                System.out.println("El Contacto de nombre '" + nombre + "' se ha insertado correctamente");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
