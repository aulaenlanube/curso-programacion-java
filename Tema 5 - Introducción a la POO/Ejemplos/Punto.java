public class Punto {

    private static int puntos = 1;

    public int x;
    public int y;
    public String nombre;


    public Punto(int x, int y, String nombre) {
        this(x,y);
        this.nombre = nombre;
        puntos++;
    }
    
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
        puntos+=2;
    }

    public Punto(int x) {
        this.x = x;
        this.y = x;
        puntos+=3;
    }

    public Punto(int x, String nombre) {
        this(x);
        this.nombre = nombre;
        puntos+=4;
    }

    

    public double calcularDistanciaCentro() {
        double z;
        z = Math.sqrt((x * x) + (y * y));
        return z;
    }

    public void mostrarDatos() {
        if (this.nombre == null)
            System.out.println("El punto no tiene nombre, sus datos son:");
        else
            System.out.println("El punto de nombre " + nombre + " tiene los siguientes datos:");
        System.out.println("X=" + x);
        System.out.println("Y=" + y);
        System.out.println("La distancia respecto al centro es " + calcularDistanciaCentro());
        getPuntos();
        System.out.println("--------------------------------------------------------------");
    }

    public static void getPuntos() {        
        System.out.println("Puntos="+puntos);
    }

    /**
     * @param puntos the puntos to set
     */
    public static void setPuntos(int puntos) {
        Punto.puntos = puntos;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
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

}
