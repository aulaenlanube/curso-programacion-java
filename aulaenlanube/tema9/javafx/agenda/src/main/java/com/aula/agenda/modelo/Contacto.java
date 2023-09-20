package com.aula.agenda.modelo;

import javafx.beans.property.SimpleStringProperty;

public class Contacto {

    private static final String RUTA = "/com/aula/agenda/imgs/";

    private SimpleStringProperty nombre;
    private SimpleStringProperty correo;
    private SimpleStringProperty imagenPerfil;
    private SimpleStringProperty webPersonal;
    private SimpleStringProperty telefono;

    // constructor completo
    public Contacto(String nombre, String correo, String imagenPerfil, String webPersonal, String telefono) {
        this.nombre = new SimpleStringProperty(nombre);
        this.correo = new SimpleStringProperty(correo);
        this.imagenPerfil = new SimpleStringProperty(imagenPerfil);
        this.webPersonal = new SimpleStringProperty(webPersonal);
        this.telefono = new SimpleStringProperty(telefono);
    }

    // getters y setters

    public SimpleStringProperty getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public SimpleStringProperty getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo.set(correo);
    }

    public SimpleStringProperty getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil.set(imagenPerfil);
    }

    public SimpleStringProperty getWebPersonal() {
        return webPersonal;
    }

    public void setWebPersonal(String webPersonal) {
        this.webPersonal.set(webPersonal);
    }

    public SimpleStringProperty getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }

    public String getRutaImagenPerfil() {
        return RUTA+imagenPerfil.getValue();
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", imagenPerfil=" + imagenPerfil +
                ", webPersonal='" + webPersonal + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Contacto contacto = (Contacto) o;

        if (!nombre.equals(contacto.nombre))
            return false;
        if (!correo.equals(contacto.correo))
            return false;
        return telefono.equals(contacto.telefono);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + correo.hashCode();
        result = 31 * result + telefono.hashCode();
        return result;
    }

}
