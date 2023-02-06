public class AppTriangulos {

    public static void main(String[] args) {        

        Punto p1 = new Punto(0);
        Punto p2 = new Punto(1,0);
        Punto p3 = new Punto(0,1);

        Punto.areaTriangulo(p1, p2, p3);
    }
    
}
