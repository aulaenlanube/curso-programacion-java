package aulaenlanube.tema4.generadores;

import java.util.Random;

public class GeneredorNombres {

    public static final String[] NOMBRES = {
            "Lucía", "Sofía", "María", "Martina", "Paula", "Julia", "Daniela", "Valeria", "Alba", "Emma",
            "Sara", "Carla", "Ana", "Noa", "Claudia", "Valentina", "Alicia", "Andrea", "Lola", "Laura",
            "Jimena", "Victoria", "Marta", "Elena", "Nora", "Inés", "Carmen", "Adriana", "Aitana", "Manuela",
            "Irene", "Marina", "Blanca", "Rocío", "Candela", "Laia", "Abril", "Vega", "Gabriela", "Natalia",
            "Miriam", "Ainhoa", "Luna", "Regina", "Alejandra", "Isabel", "Ángela", "Clara", "Triana", "Olivia",
            "Lucas", "Hugo", "Martín", "Daniel", "Pablo", "Alejandro", "Mateo", "Adrián", "Álvaro", "Manuel",
            "Leo", "David", "Mario", "Diego", "Javier", "Carlos", "Sergio", "Marcos", "Miguel", "Gabriel",
            "Dylan", "Bruno", "Iker", "Víctor", "Rodrigo", "Juan", "Luis", "Ángel", "Pedro", "José", "Marc",
            "Francisco", "Jorge", "Fernando", "Rafael", "Guillermo", "Jesús", "Jaime", "Samuel", "Gonzalo", "Isaac",
            "Rubén", "Raúl", "Iván", "Edu", "Óscar", "Ricardo", "Ignacio", "Joel", "Nicolás", "Julio"
    };

    public static final String[] APELLIDOS = {
            "García", "González", "Rodríguez", "Fernández", "López", "Martínez", "Sánchez", "Pérez", "Gómez", "Martín",
            "Jiménez", "Ruiz", "Hernández", "Díaz", "Moreno", "Muñoz", "Álvarez", "Romero", "Alonso", "Gutiérrez",
            "Navarro", "Torres", "Domínguez", "Vargas", "Ramos", "Gil", "Ramírez", "Serrano", "Blanco", "Molina", "Asins",
            "Morales", "Suárez", "Ortega", "Delgado", "Castro", "Ortiz", "Rubio", "Marín", "Sanz", "Iglesias",
            "Medina", "Cortés", "Garrido", "Castillo", "Santos", "Lozano", "Guerrero", "Torregrosa", "Prieto", "Méndez",
            "Cruz", "Gallego", "Vidal", "Cabrera", "Mendoza", "Herrera", "Campos", "Duran", "Vega", "Aguilar",
            "Pascual", "Soto", "Guillén", "Rojas", "Peña", "Calvo", "Esteban", "Gallardo", "Rico", "Cordero", "Llácer",
            "Reyes", "Nieto", "Aguado", "Paredes", "Redondo", "Merino", "Santana", "Barrio", "Crespo", "Bravo",
            "Miralles", "Vera", "Arias", "Soler", "Pastor", "Velasco", "Mora", "Saura", "Carrasco", "Riera",
            "Andrés", "Montero", "Rovira", "Vicente", "Heras", "Luna", "Aparicio", "Santos", "Sierra", "Segura", "Moscardó"
    };

    public static String generarNombre() {
        Random random = new Random();
        return NOMBRES[random.nextInt(NOMBRES.length)];
    }

    public static String generarConApellido() {
        Random random = new Random();
        return NOMBRES[random.nextInt(NOMBRES.length)] + " " + APELLIDOS[random.nextInt(APELLIDOS.length)];
    }

    public static String generarConApellidos() {
        Random random = new Random();
        return NOMBRES[random.nextInt(NOMBRES.length)] + " " + APELLIDOS[random.nextInt(APELLIDOS.length)] + " "
                + APELLIDOS[random.nextInt(APELLIDOS.length)];
    }
}
