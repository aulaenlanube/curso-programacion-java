package aulaenlanube.tema5.ejemplos;

import java.util.ArrayList;

public class TestObjetoInmutable3 {

    public static void main(String[] args) {

        ArrayList<Punto> listaPuntos = new ArrayList<>();
        Punto p0 = new Punto(0, 0);
        Punto p1 = new Punto(1, 1);
        Punto p2 = new Punto(2, 2);
        listaPuntos.add(p0);
        listaPuntos.add(p1);
        listaPuntos.add(p2);

        // creamos una instancia
        ObjetoInmutable3 obj3 = new ObjetoInmutable3(listaPuntos);

        // datos antes de modificar
        System.out.println(obj3.getListaPuntos().get(0).getX());

        // añadimos elemento a la lista
        obj3.getListaPuntos().add(0, new Punto(1000));
        System.out.println(obj3.getListaPuntos().size());

        // modificamos p0
        p0.setX(9);

        // datos después de modificar la instancia
        System.out.println(obj3.getListaPuntos().get(0).getX());

        // modificamos lista
        obj3.getListaPuntos().get(0).setX(99);
        System.out.println(obj3.getListaPuntos().get(0).getX());

    }

}
