package aulaenlanube.tema8.ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aulaenlanube.tema8.ejemplos.mysql.ConexionBD;

public class EjerciciosBdWorld {

    public static void main(String[] args) {

        try {

            Connection conex = ConexionBD.conectar("world");
            crearFicherosCiudadesPaises(conex);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void mostrarCiudadesPais(Connection conex, String codPais) {

        try {

            String query = "SELECT Name, Population FROM city WHERE CountryCode = ?";
            PreparedStatement querySelect = conex.prepareStatement(query);
            querySelect.setString(1, codPais);
            ResultSet resultado = querySelect.executeQuery();

            while (resultado.next()) {
                String nombre = resultado.getString("Name");
                int poblacion = resultado.getInt("Population");
                System.out.println(nombre + "(" + poblacion + ")");
            }
            
        } catch (Exception e) {
            System.out.println("Error al obtener información de la BD");
        }
    }

    public static void crearFicheroCiudadesPais(Connection conex, String codPais) {

        try {

            FileWriter fw = new FileWriter(codPais + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);

            String query = "SELECT Name, Population FROM city WHERE CountryCode = ?";
            PreparedStatement querySelect = conex.prepareStatement(query);
            querySelect.setString(1, codPais);
            ResultSet resultado = querySelect.executeQuery();

            while (resultado.next()) {
                String nombre = resultado.getString("Name");
                int poblacion = resultado.getInt("Population");
                bw.write(nombre + "(" + poblacion + ")\n");
            }
            bw.close();

        } catch (Exception e) {
            System.out.println("Error al obtener datos");
        }
    }

    public static void crearFicherosCiudadesPaises(Connection conex) {

        try {

            String query = "SELECT Code FROM country";
            PreparedStatement querySelect = conex.prepareStatement(query);
            ResultSet resultado = querySelect.executeQuery();

            while (resultado.next()) {
                String codPais = resultado.getString("Code");
                crearFicheroCiudadesPais(conex, codPais);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener información de la BD");
        }
    }

}
