package aulaenlanube.tema6.ejemplos;
import java.util.ArrayList;

public class AppAnimales {

    public static void main(String[] args) {
        
        ArrayList<Object> animales = new ArrayList<>();
        animales.add(new Animal());
        animales.add(new Perro());
        animales.add(new Pitbull());

        for (Object a : animales) {
            System.out.println("La clase del objeto es: "+a.getClass().getName());
            System.out.println(a);
        }           
    }
}

class Animal {
    
    @Override
    public String toString() {
        return "El animal hace un ruido";
    }
}

class Perro extends Animal {

    @Override
    public String toString() {
        return "El perro ladra";
    }
}

class Pitbull extends Perro {
        
    @Override
    public String toString() {
        return "El pitbull tiene un ladrido profundo";
    }
}
