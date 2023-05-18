package aulaenlanube.tema5.ejercicios;

import java.util.ArrayList;
import aulaenlanube.tema4.bordes.Bordes;

public class Pagina {
    private int dia;
    private int mes;
    private ArrayList<Cita> citas;

    public Pagina(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
        this.citas = new ArrayList<>();
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Cita buscarCita(Cita c) {
        for (Cita cita : this.citas) {
            if (cita.getHora() == c.getHora() && cita.getMinutos() == c.getMinutos()) {
                return cita;
            }
        }
        return null;
    }

    public void agregarCita(Cita c) {
        if (buscarCita(c) != null)
            System.out.println("ERROR: No se puede agregar la cita, hora ocupada");
        else {
            this.citas.add(c);
            System.out.println("Cita agregada correctamente el día " + dia + " de " + Agenda.meses[mes - 1] + " a las "
                    + c.getHora() + ":" + c.getMinutos());
        }
    }

    public void borrarCita(Cita c) {
        Cita aBorrar = buscarCita(c);
        if (aBorrar != null) {
            this.citas.remove(aBorrar);
            System.out.println("Cita borrada correctamente");
        } else
            System.out.println("ERROR: No se puede borrar la cita, la cita no existe");
    }

    public void verCitas() {
        String s = "ESTAS SON LAS CITAS DEL " + dia + " de " + Agenda.meses[mes - 1] + "\n";
        for (Cita c : this.citas) {
            s += c.toString();
        }
        Bordes.mostrarTextoConBordes(s);
    }
}
