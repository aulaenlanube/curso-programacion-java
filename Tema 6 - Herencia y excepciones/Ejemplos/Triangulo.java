public class Triangulo extends Figura2D {

    public static final byte NO_TRIANGULO = 0;
    public static final byte EQUILATERO = 1;
    public static final byte ISOSCELES = 2;
    public static final byte ESCALENO = 3;

    private Punto2D p1, p2, p3;
    private byte tipo;

    public Triangulo(Punto2D p1, Punto2D p2, Punto2D p3) {
        super(3);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        setTipo();
    }

    public double area() {
        double a = Punto2D.distancia(p1, p2);
        double b = Punto2D.distancia(p2, p3);
        double c = Punto2D.distancia(p3, p1);
        double s = (a + b + c) / 2;
        return (Math.sqrt(s * (s - a) * (s - b) * (s - c)));
    }

    public double perimetro() {
        return Punto2D.distancia(p1, p2) + Punto2D.distancia(p2, p3) + Punto2D.distancia(p3, p1);
    }

    public boolean esTriangulo() {
        return (p2.getY() - p1.getY()) * (p3.getX() - p2.getX()) != (p3.getY() - p2.getY()) * (p2.getX() - p1.getX());
    }

    private void setTipo() {

        if (esTriangulo()) {

            double a = Math.round(Punto2D.distancia(p1, p2)*1000)/1000d;
            double b = Math.round(Punto2D.distancia(p2, p3)*1000)/1000d;
            double c = Math.round(Punto2D.distancia(p3, p1)*1000)/1000d;

            if (a == b && b == c)
                this.tipo = EQUILATERO;
            else if (a != b && b != c && a != c)
                this.tipo = ESCALENO;
            else
                this.tipo = ISOSCELES;
        } else
            this.tipo = NO_TRIANGULO;
    }

    public String tipoTriangulo() {
        switch (this.tipo) {
            case EQUILATERO:
                return "EQUILÁTERO";
            case ISOSCELES:
                return "ISÓSCELES";
            case ESCALENO:
                return "ESCALENO";
            default:
                return "NO_TRIÁNGULO";
        }
    }

    @Override
    public String toString() {
        if (esTriangulo())
            return "El Triángulo es de tipo " + tipoTriangulo().toLowerCase() + ", de área " + Math.round(area() * 10) / 10d
                    + " y perímetro " + Math.round(perimetro() * 10) / 10d + "\n"
                    + "Sus puntos son: p1" + p1.toString() + ", p2" + p2.toString() + ", p3" + p3.toString();
                    
        return "El triángulo no es válido";
    }

}
