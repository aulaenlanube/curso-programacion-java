package aulaenlanube.tema5.ejemplos;

public class AplicacionTv {

    public static void main(String[] args) {

        Televisor tv1 = new Televisor();
        Televisor tv2 = new Televisor();

        tv1.subirVolumen();
        tv1.bajarCanal();
        tv1.subirColor();
        tv1.bajarCanal();
        tv2.bajarVolumen();
        tv2.subirCanal();

        tv1.mostrarDatos("tv1");
        tv2.mostrarDatos("tv2");

    }

}
