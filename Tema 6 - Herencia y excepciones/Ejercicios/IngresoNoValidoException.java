public class IngresoNoValidoException extends Exception {

    public IngresoNoValidoException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ERROR: No se ha podido realizar el ingreso, " + getMessage();
    }

}
