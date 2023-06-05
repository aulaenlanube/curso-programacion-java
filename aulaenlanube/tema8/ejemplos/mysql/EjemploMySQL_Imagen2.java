package aulaenlanube.tema8.ejemplos.mysql;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import aulaenlanube.tema4.generadores.GeneredorNombres;

public class EjemploMySQL_Imagen2 {

    public static void main(String[] args) {

        try {

            // realizamos conexión
            Connection conex = ConexionBD.conectar("agenda2");

            // cargarContactosDesdeCarpeta(conex, "aulaenlanube/tema8/imagenes/imgs");
            // insertarContactoBD(conex,new Contacto("Tom", "tom@tom.com ",
            // "aulaenlanube/tema8/imagenes/default.jpg", 651454545));
            mostrarDatosContactosBD(conex);
            // descargarImagenesContactosBD(conex);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public static void insertarContactoBD(Connection conex, Contacto contacto) {

    try {
        // Leemos la imagen y la conviertimos en un array de bytes
        final byte[] binarioImagen = Files.readAllBytes(Paths.get(contacto.getImagen()));

        // preparamos el insert
        String queryInsert = "INSERT INTO contacto(nombre, correo, telefono, imagen, binarioImagen) VALUES (?,?,?,?,?)";
        PreparedStatement queryFinalInsert = conex.prepareStatement(queryInsert);
        queryFinalInsert.setString(1, contacto.getNombre());
        queryFinalInsert.setString(2, contacto.getCorreo());
        queryFinalInsert.setInt(3, contacto.getTelefono());
        queryFinalInsert.setString(4, contacto.getImagen());
        queryFinalInsert.setBytes(5, binarioImagen);

        // ejecutamos el insert
        if (queryFinalInsert.executeUpdate() > 0) {
            System.out.println("Contacto insertado correctamente");
        } else
            System.out.println("Error al insertar el contacto");

    } catch (SQLException | IOException e) {
        e.printStackTrace();
    }
}

    public static void mostrarDatosContactosBD(Connection conex) throws SQLException {

        // consultamos contactos
        String querySelect = "SELECT nombre, correo, telefono, imagen FROM contacto";
        PreparedStatement queryFinalSelect = conex.prepareStatement(querySelect);
        ResultSet contactos = queryFinalSelect.executeQuery();

        // recorremos los datos obtenidos
        while (contactos.next()) {

            // creamos un contacto con los datos de la fila actual
            Contacto contacto = new Contacto(
                    contactos.getString("nombre"),
                    contactos.getString("correo"),
                    contactos.getString("imagen"),
                    contactos.getInt("telefono"));

            // mostramos datos del contacto
            contacto.mostrarDatos();
        }
    }

    public static void descargarImagenesContactosBD(Connection conex) throws SQLException, IOException {

        // obtenemos información de la imágenes de los contactos
        String querySelect = "SELECT imagen, binarioImagen FROM contacto";
        PreparedStatement queryFinalSelect = conex.prepareStatement(querySelect);
        ResultSet contactos = queryFinalSelect.executeQuery();

        // recorremos los contactos obtenidos
        while (contactos.next()) {

            Blob blob = contactos.getBlob("binarioImagen");
            byte[] blobBytes = blob.getBytes(1, (int) blob.length());

            // Especifica la ruta y el nombre del archivo donde quieres guardar el BLOB
            String rutaImagen = contactos.getString("imagen");

            // Usa FileOutputStream para escribir los bytes en un archivo
            FileOutputStream fos = new FileOutputStream(rutaImagen);
            fos.write(blobBytes);
            fos.close();
        }

    }

    public static void mostrarImagenContacto(Connection conex, Contacto contacto) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(contacto.getImagen()));
            } else
                throw new Exception();
        } catch (Exception e) {
            System.out.println("ERROR: no se ha podido leer la imagen del contacto");
        } // No hace falta dar tantos datos
    }

    public static void cargarContactosDesdeCarpeta(Connection conex, String rutaCarpeta) {

        File carpeta = new File(rutaCarpeta);
        if (carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();

            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    String nombre = GeneredorNombres.generarConApellido();
                    String correo = nombre.replaceAll(" ", "_").toLowerCase() + "@aulaenlanube.com";
                    String imagen = archivo.getPath();
                    int telefono = new Random().nextInt(600000000, 700000000);
                    Contacto contacto = new Contacto(nombre, correo, imagen, telefono);
                    insertarContactoBD(conex, contacto);
                }
            }
        } else
            System.out.println("La ruta proporcinada no es una carpeta válida");

    }

}
