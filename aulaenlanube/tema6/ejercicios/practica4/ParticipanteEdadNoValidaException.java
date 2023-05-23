package aulaenlanube.tema6.ejercicios.practica4;

public class ParticipanteEdadNoValidaException extends Exception {

    public ParticipanteEdadNoValidaException() {
        super("La edad del participante no és válida, no puede ser menor de 14 años");
    }

    public ParticipanteEdadNoValidaException(String message) {
        super(message);
    }
}
