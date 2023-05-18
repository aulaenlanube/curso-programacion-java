package aulaenlanube.tema6.ejemplos;
public class AppDiasMeses {

    public static void main(String[] args) {
        String diasSemana = "";
        DiaSemana diaActual = DiaSemana.JUEVES;
        Mes mesActual = Mes.ENERO;
        for (DiaSemana d : DiaSemana.values())
            diasSemana += d.toString() + ", ";
        System.out.println("Los días de la semana son: " + diasSemana);
        System.out.println("Hoy es " + diaActual + " y el mes actual es " + mesActual);
        System.out.println(mesActual + " tiene " + mesActual.getDias() + " días");
    }

}
