import java.util.ArrayList;

public final class ObjetoInmutable3 {

    private final ArrayList<Punto> listaPuntos; 

    public ObjetoInmutable3 (ArrayList<Punto> listaPuntos) {
        this.listaPuntos = obtenerCopia(listaPuntos);       
    }

    public ArrayList<Punto> getListaPuntos() {
        return obtenerCopia(listaPuntos);
    }

    private ArrayList<Punto> obtenerCopia(ArrayList<Punto> lista) {

        ArrayList<Punto> copia = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
             copia.add(new Punto(lista.get(i).getX(), lista.get(i).getY()));
        }
        return copia;
    }    
}
