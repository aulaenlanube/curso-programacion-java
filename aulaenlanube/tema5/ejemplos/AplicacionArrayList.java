package aulaenlanube.tema5.ejemplos;

import java.util.ArrayList;

public class AplicacionArrayList {

    public static void main(String[] args) {

        ArrayList<Punto> puntos = new ArrayList<>();
        puntos.add(new Punto(1, "p1"));
        puntos.add(new Punto(2, 3, "p2"));
        puntos.add(new Punto(3, "p3"));
        puntos.add(0, new Punto(4, 5, "p4"));

        puntos.remove(2);
        borrarPunto(puntos, new Punto(4, 5, "p4"));

        System.out.println(puntos.toString());

    }

    static void borrarPunto(ArrayList<Punto> puntos, Punto punto) {
        for (Punto p : puntos) {
            if (p.getX() == punto.getX()
                    && p.getY() == punto.getY()
                    && p.getNombre().equals(punto.getNombre())) {
                puntos.remove(p);
                return;
            }
        }
    }

}
