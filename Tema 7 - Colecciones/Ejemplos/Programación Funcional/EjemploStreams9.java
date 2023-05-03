import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EjemploStreams9 {

    public static void main(String[] args) {

        // Ejemplo para ordenar las distintas palabras de una String según la cantidad
        // de veces que aparece cada palabra, de mayor a menor

        //SOLUCIÓN 1   
        String texto = "Esto es un ejemplo ejemplo palabra palabra palabra ";

        Map<String, Long> palabrasOrden = Arrays.stream(texto.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) 
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))              
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
   
        System.out.println("Palabras ordenadas por frecuencia: " + palabrasOrden+"\n\n");


        //SOLUCIÓN 2          
        Map<String, Long> conteoPalabras = Arrays.stream(texto.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        LinkedHashMap<String, Long> palabrasOrdenadas = new LinkedHashMap<>();        
        conteoPalabras.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> palabrasOrdenadas.put(entry.getKey(), entry.getValue()));
        
        palabrasOrdenadas.forEach((palabra, cantidad) ->
                System.out.println("Palabra: " + palabra + ", Cantidad: " + cantidad));
  
    }
}
