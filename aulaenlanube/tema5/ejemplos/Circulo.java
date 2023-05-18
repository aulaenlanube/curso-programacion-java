package aulaenlanube.tema5.ejemplos;

public class Circulo {
    private double radio;
    private String color;
    private int centroX, centroY;

    Circulo() { // crea un círculo de radio 50, negro y centro en (100,100)
        radio = 50;
        color = "negro";
        centroX = 100;
        centroY = 100;
    }

    Circulo(double r) { // crea un círculo de radio 50, negro y centro en (100,100)
        setRadio(r);
        color = "blanco";
        centroX = 0;
        centroY = 0;
    }

    public double getRadio() { // consulta el radio del círculo
        return radio;
    }

    public void setRadio(double nuevoRadio) { // actualiza el radio del círculo a nuevoRadio
        if (nuevoRadio >= 0)
            radio = nuevoRadio;
    }

    public void decrece() { // decrementa el radio del círculo
        radio = radio / 1.3;
    }

    public double area() { // calcula el área del círculo
        return Math.PI * radio * radio;
    }

    public void mostrarDatos() { // obtiene un String con las componentes del círculo
        System.out.println("Círculo de radio " + radio + ", color " + color + " y centro (" + centroX + "," + centroY
                + "), y su área es " + area());
    }
}
