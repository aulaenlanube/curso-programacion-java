package aulaenlanube.tema6.ejercicios.practica3;

public enum GeneroLiterario {
    POETICO("Poético"), 
    NARRATIVO("Narrativo"), 
    DRAMATICO("Dramático"), 
    DIDACTICO("Didáctico"), 
    LIRICO("Lírico");

    private final String nombre;
    GeneroLiterario(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }

};
