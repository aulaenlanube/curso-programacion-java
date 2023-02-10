public class Agenda {

    public static final int[] diasMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    public static final String[] meses = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto",
            "septiembre", "octubre", "noviembre", "diciembre" };

    private int anyo;
    private Pagina[] paginas;
    private Pagina abierta;

    public Agenda(int anyo) {
        this.anyo = anyo;
        paginas = new Pagina[365];
        int contadorMes = 1;
        int contadorDia = 1;
        for (int i = 0; i < this.paginas.length; i++) {
            paginas[i] = new Pagina(contadorDia++, contadorMes);
            if (contadorDia > diasMes[contadorMes - 1]) {
                contadorDia = 1;
                contadorMes++;
            }
        }
        this.abierta = this.paginas[0];
    }

    public int getAnyo() {
        return anyo;
    }

    public Pagina getAbierta() {
        return abierta;
    }

    public void mostrarPaginaAbierta() {
        System.out.println("Página abierta --> " + this.abierta.getDia() + " de " + meses[this.abierta.getMes() - 1]
                + " de " + anyo);
    }

    public void abrirPagina(int dia, int mes) {
        for (Pagina p : paginas) {
            if (p.getDia() == dia && p.getMes() == mes) {
                this.abierta = p;
                mostrarPaginaAbierta();
                return;
            }
        }
        System.out.println("Página no válida");
        mostrarPaginaAbierta();
    }
}
