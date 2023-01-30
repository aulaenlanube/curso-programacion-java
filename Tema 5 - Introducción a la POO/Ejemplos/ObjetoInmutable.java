public final class ObjetoInmutable {
    private final int n;
    private final String s;
    private final Punto p;

    public ObjetoInmutable(int n, String s, Punto p) {
        this.n = n;
        this.s = s;
        this.p = new Punto(p.getX(), p.getY());
    }

    public int getN() { 
        return n;  
    }
    public String getS() {  
    	    return s; 
    }
    public Punto getPunto() {
        return new Punto(p.getX(), p.getY());
    } 
}

