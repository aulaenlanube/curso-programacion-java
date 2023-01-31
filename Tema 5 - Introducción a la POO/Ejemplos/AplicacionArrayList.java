import java.util.ArrayList;

public class AplicacionArrayList {

    public static void main(String[] args) {

        ArrayList<Punto> puntos = new ArrayList();
        Punto p1 = new Punto(1,2);
        Punto p2 = new Punto(1);
        Punto p3 = new Punto(1,3);
        Punto p4 = new Punto(3,3);

        puntos.add(p1);
        puntos.add(p2);
        puntos.add(p3);
        puntos.add(1, p4);       
        puntos.remove(2);
        puntos.remove(p1);
    }
}
