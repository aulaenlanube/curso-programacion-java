public class RetiroNoValidoException extends Exception{

    public RetiroNoValidoException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ERROR: No se ha podido realizar el retiro, " + getMessage();
    }
    
}
