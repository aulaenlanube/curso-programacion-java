package aulaenlanube.tema8.ejercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import aulaenlanube.tema8.ejemplos.mysql.ConexionBD;

public class EjercicioCiudadesPIB {

    public static void main(String[] args) {

        try {

            // conectamos con la web
            URL url = new URL("https://es.wikipedia.org/wiki/Anexo:Ciudades_por_PIB");

            // obtenemos todo el contenido HTML de la página
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
            String lineas = "";
            String linea = "";
            while ((linea = in.readLine()) != null) {
                lineas += linea + "\n";
            }
            in.close();

            // realizamos conexión
            Connection conex = ConexionBD.conectar("ciudades");

            // Parse the HTML content
            String htmlContent = lineas;
            int inicioTabla = htmlContent.indexOf("<table>") + "<table>".length();
            int finTabla = htmlContent.indexOf("</table>");
            String tabla = htmlContent.substring(inicioTabla, finTabla).trim();

            String[] filas = tabla.split("</tr>");
            for (String fila : filas) {

                fila = fila.replace("<tr>", "").replace("</td>", "").trim();
                String[] columnas = fila.split("<td>");

                if (columnas.length >= 5) {

                    // nombre ciudad
                    String ciudad = columnas[2];
                    int inicio = ciudad.indexOf(">");
                    ciudad = ciudad.substring(inicio + 1, ciudad.length() - 1);
                    ciudad = ciudad.split("</a>")[0];

                    // pais
                    String pais = columnas[3].split("</span>")[1];
                    inicio = pais.indexOf(">");
                    pais = pais.substring(inicio + 1, pais.length() - 1);
                    pais = pais.split("</a>")[0];

                    // pib total
                    String pibT = columnas[4];
                    pibT = pibT.replaceAll("\\D", "");
                    long pibTotal = Long.parseLong(pibT);

                    // pib per cápita
                    String pibC = columnas[5];
                    pibC = pibC.replaceAll("\\D", "");
                    long pibCapita = Long.parseLong(pibC);

                    // insertamos fila
                    String query = "INSERT INTO ciudad(ciudad, pais, pib_total, pib_capita) VALUES (?,?,?,?)";
                    PreparedStatement queryInsert = conex.prepareStatement(query);
                    queryInsert.setString(1, ciudad);
                    queryInsert.setString(2, pais);
                    queryInsert.setLong(3, pibTotal);
                    queryInsert.setLong(4, pibCapita);
                    queryInsert.executeUpdate();
                }
            }
            System.out.println("Ciudades insertadas correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
