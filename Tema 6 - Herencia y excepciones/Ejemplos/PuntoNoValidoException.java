public class PuntoNoValidoException extends Exception {

    private Punto punto;

    public PuntoNoValidoException(Punto punto) { // constructor utilizado en throw
        this.punto = punto;
    }

    public String toString() {
        return "Punto(" + this.punto.getX() + ", " + this.punto.getY() + ") no válido";
    }

}
