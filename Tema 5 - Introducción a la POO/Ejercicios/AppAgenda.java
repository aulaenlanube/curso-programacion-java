public class AppAgenda {

    public static void main(String[] args) {

        Agenda a = new Agenda(2023);
        a.abrirPagina(3, 2);  
        
        a.getAbierta().agregarCita(new Cita(11, 21, "Reunión 1", "Se hablará sobre qué lenguaje de programación aprender primero"));
        a.getAbierta().agregarCita(new Cita(11, 15, "Reunión 2", "Se hablará sobre el futuro de la IA"));
        a.getAbierta().agregarCita(new Cita(11, 14, "Reunión 3", "Se hablará sobre el desarrollo de videojuegos en Unreal Engine"));
        a.getAbierta().agregarCita(new Cita(11, 59, "Reunión 4", "Se hablará sobre el desarrollo de videojuegos en Unity"));

        a.getAbierta().verCitas();


    }    
}
