package aulaenlanube.tema8.ejemplos;

public class Contacto {

    private String nombre;
    private String correo;
    private String imagen;
    private int telefono;

    public Contacto(String nombre, String correo, String imagen, int telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.imagen = imagen;
        this.telefono = telefono;
    }
    
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public String getImagen() {
        return imagen;
    }
    public int getTelefono() {
        return telefono;
    }
    
    @Override
    public String toString() {
        return "[nombre=" + nombre + ", correo=" + correo + ", imagen=" + imagen + ", telefono=" + telefono
                + "]";
    }
    
}
