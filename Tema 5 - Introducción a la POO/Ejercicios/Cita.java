public class Cita {
    private int hora;
    private int minutos;
    private String titulo;
    private String texto;

    public Cita(int hora, int minutos, String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
        setHora(hora);
        setMinutos(minutos);
    }

    public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTexto(String text) {
        this.texto = text;
    }

    public void setHora(int hora) {

        // hora no válida, ponemos a cero
        if (minutos >= 24 && minutos < 0) {
            this.hora = 0;
            System.out.println("Hora nó válida, fijada a 0");
        }
        // hora válida
        else
            this.hora = hora;
    }

    public void setMinutos(int minutos) {

        // minutos no válidos, ponemos a cero
        if (minutos >= 60 && minutos < 0) {
            this.minutos = 0;
            System.out.println("Minutos nó válidos, fijados a 0");
            return;
        }

        // resto de casos
        switch (minutos % 5) {
            case 0:  this.minutos = minutos;     break;
            case 1:  this.minutos = --minutos;   break;
            case 2:  this.minutos = minutos - 2; break;
            case 3:  this.minutos = minutos + 2; break;
            case 4:  this.minutos = ++minutos;   break;
        }
        if(this.minutos == 60) this.minutos = 55;
        System.out.println("Minutos nó válidos, fijados a " + this.minutos);
    }

    @Override
    public String toString() {
        return "-> (" + this.getHora() + ":" + this.getMinutos() + "): [" + this.getTitulo() + "] " + this.getTexto()
                + "\n";
    }
}
