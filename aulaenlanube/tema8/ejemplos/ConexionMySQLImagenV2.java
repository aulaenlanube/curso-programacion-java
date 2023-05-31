package aulaenlanube.tema8.ejemplos;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import aulaenlanube.tema4.bordes.Bordes;

public class ConexionMySQLImagenV2 {

    // Datos conexión con la BD
    public static final String USER = "root";
    public static final String PWD = "";
    public static final String URL = "jdbc:MySQL://localhost/agenda";

    public static void main(String[] args) {

        try {

            Connection conex = DriverManager.getConnection(URL, USER, PWD);
            insertarContactoBD(conex, new Contacto("Tom", "tom@tom.com ", "imagenes/img1.jpg", 20));
            mostrarDatosContactosBD(conex);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarContactoBD(Connection conex, Contacto contacto) {

        try {

            final byte[] binarioImagen = Files.readAllBytes(Paths.get(contacto.getImagen()));

            // insertamos contacto
            String queryInsert = "INSERT INTO contacto(nombre, correo, telf, imagen, binarioImagen) VALUES (?,?,?,?,?)";
            PreparedStatement queryFinalInsert = conex.prepareStatement(queryInsert);
            queryFinalInsert.setString(1, contacto.getNombre());
            queryFinalInsert.setString(2, contacto.getCorreo());
            queryFinalInsert.setString(3, contacto.getImagen());
            queryFinalInsert.setBytes(4, binarioImagen);
            queryFinalInsert.setBytes(5, binarioImagen);
            queryFinalInsert.executeUpdate();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarDatosContactosBD(Connection conex) {

        try {

            // consultamos contactos
            String querySelect = "SELECT nombre, correo, telefono, imagen FROM contacto";
            PreparedStatement queryFinalSelect = conex.prepareStatement(querySelect);
            ResultSet contactos = queryFinalSelect.executeQuery();

            // recorremos los datos obtenidos
            while (contactos.next()) {

                Contacto contacto = new Contacto(
                        contactos.getString("nombre"),
                        contactos.getString("correo"),
                        contactos.getString("imagen"),
                        contactos.getInt("telefono"));

                Bordes.mostrarTextoConBordes(contacto.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void cargarImagenesContactosBD(Connection conex) {

        try {

            // consultamos contactos
            String querySelect = "SELECT imagen, binarioImagen FROM contacto";
            PreparedStatement queryFinalSelect = conex.prepareStatement(querySelect);
            ResultSet contactos = queryFinalSelect.executeQuery();

            // recorremos los contactos obtenidos
            while (contactos.next()) {

                Blob blob = contactos.getBlob("binarioImagen");
                byte[] blobBytes = blob.getBytes(1, (int) blob.length());

                // Especifica la ruta y el nombre del archivo donde quieres guardar el BLOB
                String outputPath = contactos.getString("imagen");

                            // Convierte el array de bytes a una imagen
            ByteArrayInputStream bis = new ByteArrayInputStream(blobBytes);
            java.awt.image.BufferedImage image = ImageIO.read(bis);

            // Guarda la imagen como un archivo JPG
            File outputFile = new File("/ruta/a/tu/carpeta/imagen.jpg");
            ImageIO.write(image, "jpg", outputFile);

                // Usa FileOutputStream para escribir los bytes en un archivo
                FileOutputStream fos = new FileOutputStream(outputPath);
                fos.write(blobBytes);
                fos.close();

            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }
}
