import java.util.ArrayList;

public class GraficoLineas2D {

    private ArrayList<Punto> puntos;

    public GraficoLineas2D() {
        this.puntos = new ArrayList<>();
    }
    public GraficoLineas2D(ArrayList<Punto> puntos) {
        this();
        setPuntos(puntos);
    }

    public boolean esPositivo(Punto p) {
        return p.getX() >= 0 && p.getY() >= 0;
    }

    public void eliminarPunto() {

        if (!puntos.isEmpty()) {
            puntos.remove(puntos.size() - 1);
            System.out.println("Punto eliminado correctamente");
        } else
            System.out.println("No se ha podido eliminar el punto, lista vacia");
    }

    public void agregarPunto(Punto p) {

        // si la lista está vacia, agregamos el primer punto
        if (puntos.isEmpty()) {
            puntos.add(p);
            System.out.println("Primer punto agregado correctamente");
            return;
        }

        // si hay algún punto
        Punto anterior = puntos.get(puntos.size() - 1);

        if (esPositivo(p) && Punto.distintos(p, anterior) && p.getX() >= anterior.getX()) {
            puntos.add(p);
            System.out.println("Punto agregado correctamente");
        } else
            System.out.println("ERROR: no se ha podido agregar el punto");
    }

    public void setPuntos(ArrayList<Punto> puntos) {

        if (validarPuntos(puntos)) {
            this.puntos = puntos;
            System.out.println("Lista modificada correctamente");
        } else
            System.out.println("ERROR: no se ha podido modificar la lista de puntos");
    }

    private boolean validarPuntosOld(ArrayList<Punto> puntos) {

        // lista con puntos
        if (!puntos.isEmpty()) {
            // más de un punto
            if (puntos.size() > 1) {

                for (int i = 0; i < puntos.size() - 1; i++) {
                    Punto punto = puntos.get(i);
                    Punto siguiente = puntos.get(i + 1);

                    // si alguno de los puntos no es válido
                    if (!esPositivo(punto) || !esPositivo(siguiente) || !Punto.distintos(punto, siguiente)
                            || punto.getX() > siguiente.getX())
                        return false;
                }
                // todos los puntos son válidos
                return true;
            }
            // si el punto es positivos
            else if (esPositivo(puntos.get(0)))
                return true;
            // si el punto no es positivo
            else
                return false;
        }
        // lista sin puntos
        return true;
    }

    private boolean validarPuntos(ArrayList<Punto> puntos) {

        // lista con puntos, válida
        if (puntos.isEmpty())
            return true;

        // primer punto, si no es positivo
        if (puntos.get(0).getX() < 0 || puntos.get(0).getY() < 0) {
            return false;
        }

        // más de un punto
        for (int i = 1; i < puntos.size(); i++) {
            Punto punto = puntos.get(i);
            Punto anterior = puntos.get(i - 1);

            // si alguno de los puntos no es válido
            if (!esPositivo(punto) || !Punto.distintos(punto, anterior)
                    || punto.getX() < anterior.getX())
                return false;
        }
        // todos los puntos son válidos
        return true;
    }

    public void mostrarGrafico() {

        for (Punto p : puntos) {
            System.out.println(p.toString());
        }
    }
}
