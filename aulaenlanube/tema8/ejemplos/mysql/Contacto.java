package aulaenlanube.tema8.ejemplos.mysql;

import aulaenlanube.tema4.bordes.Bordes;

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void mostrarDatos() {
        String datosContactoActual = "";
        datosContactoActual += "Nombre: " + nombre + "\n";
        datosContactoActual += "Correo: " + correo + "\n";
        datosContactoActual += "Teléfono: " + telefono + "\n";
        datosContactoActual += "Imagen: " + imagen + "\n";
        Bordes.mostrarTextoConBordes(datosContactoActual);
    }


}
