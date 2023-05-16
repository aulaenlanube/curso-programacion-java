public class Instituto {

    public static void main(String[] args) {

        Grupo dam = new Grupo("1DAM");

        dam.agregarAlumno(new Alumno("Pep", "1111A", 15));
        dam.agregarAlumno(new Alumno("Tom", "2222A", 17));
        dam.agregarAlumno(new Alumno("Jon", "3333A", 14));
        dam.agregarAlumno(new Alumno("Kal", null, 13));
        dam.agregarAlumno(new Alumno("Sam", null, 18));
        dam.agregarAlumno(new Alumno("Tim", null, 15));

        dam.eliminarPorEdad(17);
        dam.listarAlumnos();

    }
}
