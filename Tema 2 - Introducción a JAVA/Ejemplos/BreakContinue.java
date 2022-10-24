public class BreakContinue {

    public static void main(String[] args) {
        int cantidad = 3;
        System.out.println("La palabra se ha repetido "+cantidad+(cantidad == 1 ? " vez" : " veces"));

        //ejemplo 1
        System.out.println("Empezamos...");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Vuelta: " + i);
            if (i == 8)
                break;
            System.out.println("Terminada vuelta: " + i);
        }
        System.out.println("Terminado");

        // ejemplo 2
        System.out.println("Empezamos...");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Vuelta: " + i);
            if (i == 8)
                continue;
            System.out.println("Terminada vuelta: " + i);
        }
        System.out.println("Terminado");

        // ejemplo 3
        System.out.println("Empezamos...");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Vuelta: " + i);
            salir: if (i == 8) {
                i++;
                break salir;
            }
            System.out.println("Terminada vuelta: " + i);
        }
        System.out.println("Terminado");

        // ejemplo 4
        int n = 0;
        for (;;) {
            if (n == 5)
                break;
            System.out.print(n);
            n++;
        }
        System.out.println("Fin");

    }

}
