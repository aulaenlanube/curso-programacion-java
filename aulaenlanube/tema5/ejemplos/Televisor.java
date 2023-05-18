package aulaenlanube.tema5.ejemplos;

public class Televisor {

    private int canal;
    private int volumen;
    private int color;

    public Televisor() {
        canal = 1;
        volumen = 5;
        color = 7;
    }

    public void subirColor() {
        setColor(color + 1);
    }

    public void bajarColor() {
        setColor(color - 1);
    }

    public void setColor(int valorColor) {
        if (valorColor > 7)
            color = 7;
        else if (valorColor < 1)
            color = 1;
        else
            color = valorColor;
    }

    public void subirVolumen() {
        setVolumen(volumen + 1);
    }

    public void bajarVolumen() {
        setVolumen(volumen - 1);
    }

    public void setVolumen(int valorVolumen) {
        if (valorVolumen > 15)
            volumen = 15;
        else if (valorVolumen < 0)
            volumen = 0;
        else
            volumen = valorVolumen;
    }

    public void subirCanal() {
        setCanal(canal + 1);
    }

    public void bajarCanal() {
        setCanal(canal - 1);
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int valorCanal) {
        if (valorCanal > 10)
            canal = 0;
        else if (valorCanal < 0)
            canal = 10;
        else
            canal = valorCanal;
    }

    public void mostrarDatos(String nombre) {
        System.out.println("La televisión " + nombre + ":");
        System.out.println("Canal actual = " + canal);
        System.out.println("Volumen actual = " + volumen);
        System.out.println("Color actual = " + color);
        System.out.println("----------------------------");
    }

}
