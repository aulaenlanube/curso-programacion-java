package aulaenlanube.tema6.ejemplos;
import java.util.Arrays;

public class AppTiposEnumerados1 {

    public static void main(String[] args) {
        
        DiaSemana diaActual = DiaSemana.JUEVES;
        Mes mesActual = Mes.FEBRERO;        
        System.out.println("Los días de la semana son: " + Arrays.toString(DiaSemana.values()));
        System.out.println("Hoy es " + diaActual + " y el mes actual es " + mesActual);
        System.out.println(mesActual + " tiene " + mesActual.getDias() + " días");
    }

}
