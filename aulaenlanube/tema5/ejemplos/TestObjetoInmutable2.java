package aulaenlanube.tema5.ejemplos;

public class TestObjetoInmutable2 {

    public static void main(String[] args) {

        Punto[] arrayPuntos = new Punto[3];
        Punto p0 = new Punto(0, 0);
        Punto p1 = new Punto(1, 1);
        Punto p2 = new Punto(2, 2);
        arrayPuntos[0] = p0;
        arrayPuntos[1] = p1;
        arrayPuntos[2] = p2;

        // creamos una instancia
        ObjetoInmutable2 obj2 = new ObjetoInmutable2(arrayPuntos);

        // datos antes de modificar
        System.out.println(obj2.getArrayPuntos()[0].getX());

        // modificamos p0
        p0.setX(9);

        // datos después de modificar la instancia
        System.out.println(obj2.getArrayPuntos()[0].getX());

        // modificamos array
        obj2.getArrayPuntos()[0].setX(99);
        System.out.println(obj2.getArrayPuntos()[0].getX());

    }

}
