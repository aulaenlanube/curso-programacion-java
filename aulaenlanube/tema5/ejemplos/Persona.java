package aulaenlanube.tema5.ejemplos;

public class Persona {

    String nombre;
    int edad;
    String ciudadResidencia;
    String profesion;
    String dni;

    public Persona(String s, int n, String d) {

        nombre = s;
        edad = n;
        ciudadResidencia = "Sin ciudad";
        profesion = "Sin profesión";
        dni = d;
    }

    public void mostrarDatos() {

        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Edad: " + edad);
        System.out.println("Ciudad: " + ciudadResidencia);
        System.out.println("Profesión: " + profesion);
        System.out.println("--------------------------------");

    }

    public void mostrarDatosConBordes() {

        String datos = "";
        datos += "Nombre: " + nombre + "\n";
        datos += "DNI: " + dni + "\n";
        datos += "Edad: " + edad + "\n";
        datos += "Ciudad: " + ciudadResidencia + "\n";
        datos += "Profesión: " + profesion + "\n";
        System.out.println(datos);
    }

}
