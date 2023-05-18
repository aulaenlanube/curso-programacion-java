public class ValorReferencia {

    public static void main(String[] args) {

        try {
            int num = 1;
            String nombre = "String inmutable";
            Punto p1 = new Punto(1, 1);

            modificarPunto(p1);
            modificarEntero(num);
            modificarString(nombre);

            System.out.println("Punto.x = " + p1.getX()); 
            System.out.println("num = " + num); 
            System.out.println("nombre = " + nombre);
            
        } catch (PuntoNoValidoException e) {
            System.out.println(e);
        } 
    }

    public static void modificarPunto(Punto p) {
        p.setX(999);
    }

    public static void modificarEntero(int n) {
        n = 999;
    }

    public static void modificarString(String s) {
        s = "String modificada";
    }

}
