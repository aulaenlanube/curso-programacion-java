package aulaenlanube.tema8.ejemplos.mysql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import aulaenlanube.tema4.bordes.Bordes;
import aulaenlanube.tema4.generadores.GeneredorNombres;

public class EjemploMySQL_Imagen {

    public static void main(String[] args) {

        try {

            // Datos del contacto a insertar
            String nombre = GeneredorNombres.generarConApellido();
            String correo = nombre.replaceAll(" ", "_").toLowerCase() + "@aulaenlanube.com";
            int telefono = 123456789;
            String rutaImagen = "aulaenlanube/tema8/imagenes/default.jpg";

            // realizamos conexión
            Connection conex = ConexionBD.conectar("agenda2");

            // imagen
            final byte[] binarioImagen = Files.readAllBytes(Paths.get(rutaImagen));

            // preparamos el insert
            String queryInsert = "INSERT INTO contacto(nombre, correo, telefono, imagen, binarioImagen) VALUES (?,?,?,?,?)";
            PreparedStatement queryFinalInsert = conex.prepareStatement(queryInsert);
            queryFinalInsert.setString(1, nombre);
            queryFinalInsert.setString(2, correo);
            queryFinalInsert.setInt(3, telefono);
            queryFinalInsert.setString(4, rutaImagen);
            queryFinalInsert.setBytes(5, binarioImagen);

            // ejecutamos el insert
            if (queryFinalInsert.executeUpdate() == 1)
                System.out.println("El Contacto de nombre '" + nombre + "' se ha insertado correctamente");

            // consultamos contactos
            String querySelect = "SELECT nombre, correo, telefono FROM contacto";
            PreparedStatement queryFinalSelect = conex.prepareStatement(querySelect);
            ResultSet resultado = queryFinalSelect.executeQuery();

            // recorremos los datos obtenidos
            while (resultado.next()) {
                String datosContactoActual = "";
                datosContactoActual += "Nombre: " + resultado.getString("nombre") + "\n";
                datosContactoActual += "Correo: " + resultado.getString("correo") + "\n";
                datosContactoActual += "Teléfono: " + resultado.getInt("telefono") + "\n";
                datosContactoActual += "Imagen: " + resultado.getInt("imagen") + "\n";
                Bordes.mostrarTextoConBordes(datosContactoActual);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
