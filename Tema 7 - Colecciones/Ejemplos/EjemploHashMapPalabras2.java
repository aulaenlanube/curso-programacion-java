import java.util.HashMap;
import java.util.Map;

public class EjemploHashMapPalabras2 {

    public static void main(String[] args) {        

        String s = "Cadena    !!..__cadena ejemplo\n\nejemplo ejempló";
 
        // Utilizamos HashMap para almacenar las palabras y sus frecuencias
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();

        // Convertimos la cadena de entrada a minúsculas y eliminamos los caracteres que no sean letras
        String soloLetras = s.toLowerCase().replaceAll("\n", " ").replaceAll("[^a-záéíóúüñçA-ZÁÉÍÓÚÜÑÇ ]", "");

        // Dividimos la cadena en palabras usando el método split
        String[] palabras = soloLetras.split("\\s+");

        // Recorremos el array de palabras
        for (String palabra : palabras) {
            // Incrementamos la frecuencia de la palabra en el mapa
            frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
        }

        // Imprimimos los resultados
        System.out.println("Frecuencia de palabras en la cadena de entrada:");
        for (Map.Entry<String, Integer> claveValor : frecuenciaPalabras.entrySet()) {
            System.out.println(claveValor.getKey()+": "+claveValor.getValue());
        }
    }
}
