package aulaenlanube.tema6.ejemplos;
import java.util.ArrayList;

public class AppEquals {

    public static void main(String[] args) {        
        
        Punto2D p1 = new Punto2D(0.3, 0.3);        
        Punto2D p2 = new Punto2D(0.1+0.2, 0.1+0.2);        
        Punto2D p3 = new Punto2D(0, 0);        
        Punto2D p4 = p1;   

        if(p1.equals(p2)) System.out.println("Iguales");
        else System.out.println("Distintos");

        if(p1.equals(p4)) System.out.println("Iguales");
        else System.out.println("Distintos");

        ArrayList<Punto2D> puntos = new ArrayList<>();
        puntos.add(p1);
        puntos.add(p2);
        puntos.add(p3);
        puntos.add(p4);

        puntos.remove(new Punto2D(3, 3));
        System.out.println(puntos);
    }    

    
}
