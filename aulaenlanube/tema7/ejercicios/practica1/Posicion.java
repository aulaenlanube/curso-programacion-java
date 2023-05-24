package aulaenlanube.tema7.ejercicios.practica1;

public enum Posicion {
    
    PORTERO("Portero", 2000, 3000),
    DEFENSA("Defensa", 2500, 3500),
    CENTROCAMPISTA("Centrocampista", 3500, 4000),
    DELANTERO("Delantero", 4000, 5000);

    private final String nombrePosicion;
    private final double salarioMinimo;
    private final double salarioMaximo;

    Posicion(String nombrePosicion, double salarioMinimo, double salarioMaximo) {
        this.nombrePosicion = nombrePosicion;
        this.salarioMinimo = salarioMinimo;
        this.salarioMaximo = salarioMaximo;
    }

    public String getNombrePosicion() {
        return nombrePosicion;
    }

    public double getSalarioMinimo() {
        return this.salarioMinimo;
    }

    public double getSalarioMaximo() {
        return this.salarioMaximo;
    }
}

