public enum Modulo {

    PROGRAMACION("PRG", "Programación"),
    BASES_DE_DATOS("BDA", "Bases de Datos"),
    LENGUAJES_DE_MARCAS("LM", "Lenguajes de marcas"),
    ENTORNOS_DE_DESARROLLO("ED", "Entornos de desarrollo"),
    SISTEMAS_INFORMATICOS("SI","Sistemas informáticos");    

    private String nombre;
    private String abreviatura;  
  
    Modulo(String abreviatura, String nombre) {
        this.abreviatura = abreviatura;
        this.nombre = nombre;
    }
    public String getAbreviatura() {
        return abreviatura;
    }
    public String getNombre() {
        return nombre;
    }

    
}
