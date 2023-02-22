public class Punto2D {

    private double x;
    private double y;

    public Punto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //////////////////////////////////
    /// GETTERS & SETTERS
    //////////////////////////////////

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    //////////////////////////////////
    /// MÉTODOS 
    //////////////////////////////////   

    @Override
    public String toString() {
        return "[x=" + x + ", y=" + y + "]";
    }

    //////////////////////////////////
    /// MÉTODOS ESTÁTICOS
    //////////////////////////////////

    public static boolean distintos(Punto2D p1, Punto2D p2) {
        return p1.x != p2.x || p1.y != p2.y;
    }

    public static double distancia(Punto2D p1, Punto2D p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Punto2D other = (Punto2D) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }    


}
