package aulaenlanube.tema6.ejemplos;
public class PuntoNoValidoException extends Exception {

    private Punto punto;

    public PuntoNoValidoException(Punto punto) {
        this.punto = punto;
    }

    public String toString() {
        return "ERROR, las coordenadas ("+punto.getX()+", "+punto.getY()+") no son válidas";
    }

}
