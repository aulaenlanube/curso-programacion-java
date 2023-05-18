package aulaenlanube.tema7.ejemplos.programacionFuncional;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EjemploStreams8 {

    public static void main(String[] args) {
      List<String> nombres = Arrays.asList("Tom", "Jon", "Kal", "Ana");

      Comparator<Trabajador> comparadorTrabajadores = Comparator.comparing(Trabajador::getNombre);

      // Method Reference para referenciar al constructor de la clase Trabajador
      Function<String, Trabajador> referenciaConstructor = Trabajador::new;
      List<Trabajador> trabajadores = nombres.stream()      
                                      .map(referenciaConstructor)  
                                      .sorted(comparadorTrabajadores)                                    
                                      .collect(Collectors.toList());
      
      System.out.println("Lista de trabajadores: " + trabajadores);
         
      
         
      }
}
