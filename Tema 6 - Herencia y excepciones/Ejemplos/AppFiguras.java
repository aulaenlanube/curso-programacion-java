public class AppFiguras {

    public static void main(String[] args) {        
        
        Punto2D p1 = new Punto2D(0.3, 0.3);        
        Punto2D p2 = new Punto2D(0.1+0.2, 0.1+0.2);        
        Punto2D p3 = new Punto2D(0, 0);  

        //no triángulo
        Triangulo t1 = new Triangulo(p1, p2, p3);
        BordesMatrices.mostrarTextoConBordes(t1.toString());

        //isósceles
        p2 = new Punto2D(1, 0);
        p3 = new Punto2D(0, 1);
        t1 = new Triangulo(p1, p2, p3);
        BordesMatrices.mostrarTextoConBordes(t1.toString());

        //escaleno
        p3 = new Punto2D(0, 2);
        t1 = new Triangulo(p1, p2, p3);
        BordesMatrices.mostrarTextoConBordes(t1.toString());

        //equilátero
        p3 = new Punto2D(0.5, 0.5*Math.sqrt(3));
        t1 = new Triangulo(p1, p2, p3);
        BordesMatrices.mostrarTextoConBordes(t1.toString());
    }    

    
}
