public class Alumno implements Comparable<Alumno> {
    private String nombre;
    private String nia;
    private int edad;
   
    public Alumno(String nombre, String nia, int edad) {
        this.nombre = nombre;
        this.nia = nia;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNia() {
        return nia;
    }

    public void setNia(String nia) {
        this.nia = nia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "[nombre=" + nombre + ", edad="+edad+"]";
    }

    @Override
    public int compareTo(Alumno a) {
        int comparacion = Integer.compare(a.getEdad(), this.edad); 
        if (comparacion == 0) comparacion = nombre.compareTo(a.getNombre());     
        return comparacion;       
    }
    
}
