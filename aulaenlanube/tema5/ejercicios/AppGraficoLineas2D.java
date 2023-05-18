package aulaenlanube.tema5.ejercicios;

import aulaenlanube.tema5.ejemplos.Punto;

public class AppGraficoLineas2D {

    public static void main(String[] args) {

        Punto p1 = new Punto(1, 1, "p1");
        Punto p2 = new Punto(2, 2, "p2");
        Punto p3 = new Punto(3, 3, "p3");
        Punto p4 = new Punto(4, 4, "p4");
        Punto p5 = new Punto(5, 5, "p5");

        GraficoLineas2D grafico = new GraficoLineas2D();

        grafico.agregarPunto(p1);
        grafico.agregarPunto(p3);
        grafico.eliminarPunto();
        grafico.agregarPunto(p2);
        grafico.agregarPunto(p4);
        grafico.agregarPunto(p5);
        grafico.mostrarGrafico();
    }
}
