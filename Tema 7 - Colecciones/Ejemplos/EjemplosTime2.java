import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class EjemplosTime2 {

    public static void main(String[] args) {

        // Fecha y hora de nacimiento
        LocalDate fechaNacimiento = LocalDate.of(1981, 9, 1);
        LocalTime horaNacimiento = LocalTime.of(8, 0);
        // Fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        if (LocalDateTime.of(fechaNacimiento, horaNacimiento).isAfter(fechaHoraActual))
            System.out.println("Fecha de nacimiento no válida");
        else {
            // Calcular el período desde la fecha de nacimiento hasta la fecha actual
            Period p = Period.between(fechaNacimiento, fechaHoraActual.toLocalDate());
            // Calcular la duración desde la hora de nacimiento hasta la hora actual en el
            // último día
            Duration d = Duration.between(horaNacimiento, fechaHoraActual.toLocalTime());
            if (d.isNegative()) {
                p = p.minusDays(1);
                d = d.plusDays(1);
            }
            // Convertir la duración a horas, minutos y segundos
            long horas = d.toHours();
            long minutos = d.toMinutes() % 60;
            long segundos = d.getSeconds() % 60;
            System.out.println("Han pasado " + p.getYears() + " años, "
                    + p.getMonths() + " meses, " + p.getDays() + " días, " + horas
                    + " horas, " + minutos + " minutos y " + segundos + " segundos desde tu nacimiento.");
        }
    }
}
