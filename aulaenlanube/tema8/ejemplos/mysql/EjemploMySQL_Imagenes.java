package aulaenlanube.tema8.ejemplos.mysql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import aulaenlanube.tema4.bordes.Bordes;
import aulaenlanube.tema4.generadores.GeneredorNombres;

public class EjemploMySQL_Imagenes {

    public static void main(String[] args) {

        try {

            Connection conex = ConexionBD.conectar("agenda2");
            insertarContactoBD(conex);
            mostrarDatosContactosBD(conex);

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarContactoBD(Connection conex) throws IOException, SQLException {

        // Datos del contacto a insertar
        String nombre = GeneredorNombres.generarConApellido();
        String correo = nombre.replaceAll(" ", "_").toLowerCase() + "@aulaenlanube.com";
        int telefono = new Random().nextInt(600000000, 700000000);
        String rutaImagen = "aulaenlanube/tema8/imagenes/default.jpg";

        // binario con la imagen del contacto
        final byte[] binarioImagen = Files.readAllBytes(Paths.get(rutaImagen));

        // preparamos el insert
        String queryInsert = "INSERT INTO contacto(nombre, correo, telefono, imagen, binarioImagen) VALUES (?,?,?,?,?)";
        PreparedStatement queryFinalInsert = conex.prepareStatement(queryInsert);
        queryFinalInsert.setString(1, nombre);
        queryFinalInsert.setString(2, correo);
        queryFinalInsert.setInt(3, telefono);
        queryFinalInsert.setString(4, rutaImagen);
        queryFinalInsert.setBytes(5, binarioImagen);

        // ejecutamos el insert y mostramos mensaje
        if (queryFinalInsert.executeUpdate() == 1)
            System.out.println("'" + nombre + "' se ha insertado correctamente");
    }

    public static void mostrarDatosContactosBD(Connection conex) throws SQLException {

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
    }
}
