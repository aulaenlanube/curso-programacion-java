package aulaenlanube.tema7.ejemplos;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class EjemplosTime {

    public static void main(String[] args) {

        // Fecha y hora de nacimiento
        LocalDateTime fechaHoraNacimiento = LocalDateTime.of(1981, 9, 1, 8, 0);

        // Convertir la fecha y hora de nacimiento a un Instant
        Instant nacimientoInstant = fechaHoraNacimiento.atZone(ZoneId.systemDefault()).toInstant();

        // Obtener el Instant actual
        Instant ahoraInstant = Instant.now();

        // Calcular la duración desde el Instant de nacimiento hasta el Instant actual
        Duration duracionDesdeNacimiento = Duration.between(nacimientoInstant, ahoraInstant);

        DecimalFormat df = new DecimalFormat("#,###");

        System.out.println("En días: " + df.format(duracionDesdeNacimiento.toDays()));
        System.out.println("En horas: " + df.format(duracionDesdeNacimiento.toHours()));
        System.out.println("En minutos: " + df.format(duracionDesdeNacimiento.toMinutes()));
        System.out.println("En segundos: " + df.format(duracionDesdeNacimiento.toSeconds()));
    }
}
