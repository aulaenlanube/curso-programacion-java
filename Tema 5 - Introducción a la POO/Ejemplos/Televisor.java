public class Televisor {

    private int canal;
    private int volumen;

    public Televisor() {
        canal = 1;
        volumen = 5;
    }

    public void subirVolumen() {
        setVolumen(volumen + 1);
    }

    public void bajarVolumen() {
        setVolumen(volumen - 1);
    }

    public void setVolumen(int valorVolumen) {
        if (valorVolumen >= 0 && valorVolumen < 100)
            volumen = valorVolumen;
        System.out.println("Volumen:" + volumen);
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
        if (valorCanal > 0 && valorCanal < 100)
            canal = valorCanal;
        System.out.println("Canal:" + canal);
    }

}
