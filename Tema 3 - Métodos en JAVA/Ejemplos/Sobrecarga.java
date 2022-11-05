public class Sobrecarga {

    public static void main(String[] args) {

        saludar();
        saludar("Pepe");
        saludar("Pepe", "Xàtiva");
        System.out.println(suma('a', 3));
        suma('a', 3.0);
        prueba();
    }

    static int suma(int a, int b) {
        return a + b;
    }

    static void prueba()
    {
        int x = 21;
        System.out.println("Prueba");
        if(x == 2) return;
        System.out.println("preba 2");
        return;
    }

    static void suma(int a, double b) {
        System.out.println(a + b);
    }

    static void saludar() {
        System.out.println("Hola, qué tal??");
    }

    static void saludar(String nombre) {
        System.out.println("Hola " + nombre + ", cómo estás??");
    }

    static void saludar(String nombre, String ciudad) {
        System.out.println("Hola " + nombre + ", qué tal por " + ciudad + "??");
    }

}
