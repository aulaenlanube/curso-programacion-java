package aulaenlanube.tema6.ejercicios.practica1;

import java.util.ArrayList;

public class Empresa {

    private String cif;
    private String nombre;
    private ArrayList<Trabajador> trabajadores;

    public Empresa(String cif, String nombre) {
        this.cif = cif;
        this.nombre = nombre;
        this.trabajadores = new ArrayList<>();
    }

    public void addTrabajador(Trabajador trabajador) {
        this.trabajadores.add(trabajador);
    }

    public String getCif() {
        return cif;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }
}
