package aulaenlanube.tema6.ejercicios.practica4;

public class ParticipanteNoValidoException extends Exception {

    public static final byte NOMBRE_NO_VALIDO = 0;
    public static final byte APELLIDO_NO_VALIDO = 1;
    public static final byte EDAD_NO_VALIDA = 2;

    private byte tipoError;

    public ParticipanteNoValidoException(byte tipoError) {
        this.tipoError = tipoError;
    }

    @Override
    public String toString() {
        String s = "";
        switch (tipoError) {
            case NOMBRE_NO_VALIDO:
                s = "El nombre del participante no és válido";
                break;
            case APELLIDO_NO_VALIDO:
                s = "El apellido del participante no és válido";
                break;
            case EDAD_NO_VALIDA:
                s = "La edad del participante no és válida, no puede ser menor de 14 años";
                break;
        }
        return s;
    }
}
