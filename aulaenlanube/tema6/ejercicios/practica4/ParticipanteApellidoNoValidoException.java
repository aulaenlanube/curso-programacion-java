package aulaenlanube.tema6.ejercicios.practica4;

public class ParticipanteApellidoNoValidoException extends Exception {

    public ParticipanteApellidoNoValidoException() {
        super("El apellido del participante no és válido");
    }

    public ParticipanteApellidoNoValidoException(String message) {
        super(message);
    }
}
