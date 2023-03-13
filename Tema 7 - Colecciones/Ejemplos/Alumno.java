public class Alumno {
    private String nombre;
    private String nia;
    private int edad;
   
    public Alumno(String nombre, String nia, int edad) {
        this.nombre = nombre;
        this.nia = nia;
        this.edad = edad;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nia
     */
    public String getNia() {
        return nia;
    }

    /**
     * @param nia the nia to set
     */
    public void setNia(String nia) {
        this.nia = nia;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", nia=" + nia + ", edad=" + edad + "]";
    }
    
}
