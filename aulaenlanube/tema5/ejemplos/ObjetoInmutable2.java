package aulaenlanube.tema5.ejemplos;

public final class ObjetoInmutable2 {

    private final Punto[] arrayPuntos;

    public ObjetoInmutable2(Punto[] arrayPuntos) {
        this.arrayPuntos = obtenerCopia(arrayPuntos);
    }

    public Punto[] getArrayPuntos() {
        return obtenerCopia(arrayPuntos);
    }

    private Punto[] obtenerCopia(Punto[] array) {

        Punto[] copia = new Punto[array.length];
        for (int i = 0; i < copia.length; i++) {
            copia[i] = new Punto(array[i].getX(), array[i].getY());
        }
        return copia;
    }
}
