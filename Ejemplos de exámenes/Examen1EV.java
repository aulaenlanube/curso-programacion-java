import java.util.Arrays;
import java.util.Scanner;

public class Examen1EV {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String opcion = "";

        do {
            mostrarMenu();
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    ejercicio1(3);
                    break;
                case "2":
                    ejercicio2("Examen de PROGRAMACIÓN");
                    break;
                case "3":
                    int[] nums = ejercicio3(new int[] {1,2,3,1,12,3,1,2,4,5});
                    System.out.println(Arrays.toString(nums));
                    break;
                case "4":
                    ejercicio4(17712);
                    break;
                case "5":
                    salir();
                    break;
                default:
                    opcionNoValida();
            }
        } while (!opcion.equals("5"));
        entrada.close();
    }

    static void ejercicio1(int n) {

        if (n > 9 || n < 1) {
            System.out.println("ERROR: el número debe estar entre 1 y 9");
            return;
        }

        int lado = n * 2 - 1;
        int numActual;
        for (int i = 0; i < lado; i++) {
            numActual = n;
            for (int j = 0; j < lado; j++) {
                System.out.print(numActual + " ");
                if (j < n - 1)
                    numActual--;
                else
                    numActual++;
            }
            System.out.println();
        }
    }

    static void ejercicio2(String s) {

        String nueva = "";
        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {
                case 'Á':
                case 'á':
                case 'A':
                case 'a':
                    nueva += 4;
                    break;
                case 'É':
                case 'é':
                case 'E':
                case 'e':
                    nueva += 3;
                    break;
                case 'Ó':
                case 'ó':
                case 'O':
                case 'o':
                    nueva += 0;
                    break;
                case 'Í':
                case 'í':
                case 'I':
                case 'i':
                    nueva += 1;
                    break;
                case ' ':
                    nueva += '_';
                    break;
                default:
                    nueva += s.charAt(i);
            }
        }
        System.out.println(nueva);
    }

    static int[] ejercicio3(int[] nums) {

        int[] distintos = {nums[0]};
        for (int i = 1; i < nums.length; i++) {

            //si no está repetido
            if(!repetido(nums[i], distintos)) {

                //creamos un Array nuevo con un elemento adicional
                int[] aux = new int[distintos.length+1];

                //copiamos los elementos
                for (int j = 0; j < distintos.length; j++) {
                    aux[j] = distintos[j];                    
                }
                //añadimos el no repetido
                aux[aux.length-1] = nums[i];

                //clonamos
                distintos = aux.clone();
            }            
        }
        return distintos;
    }

    static void ejercicio4(int n) {

        if(n<0) System.out.println("Los números negativos no serán analizados");
        else if(n<8) System.out.println("El número está en OCTAL");
        else if(n%10 > 7) System.out.println("El número NO está en OCTAL");
        else ejercicio4(n/10);
    }

    static boolean repetido(int n, int[] array) {

        for (int i = 0; i < array.length; i++) {
            if(n == array[i]) return true;            
        }
        return false;
    }

    static void mostrarMenu() {
        String s = """


                ╔═══════════════════════════════════╗
                ║       M E N Ú    E X A M E N      ║
                ║═══════════════════════════════════║
                ║    1 - Dibujar figura             ║
                ║    2 - Modificar String           ║
                ║    3 - Array sin duplicados       ║
                ║    4 - Octal                      ║
                ║    5 - Salir                      ║
                ╚═══════════════════════════════════╝


                """;
        System.out.println(s);
    }

    static void opcionNoValida() {

        String s = """

                ╔═════════════════════════════════════════════════════╗
                ║ ERROR:  Debes seleccionar una opción entre 1 y 5    ║
                ╚═════════════════════════════════════════════════════╝
                    """;
        System.out.println(s);

    }
    
    static void salir() {

        String s = """

                ╔══════════════════════════════════════════════╗
                ║ Ha sido un honor servirle, hasta la próxima  ║
                ╚══════════════════════════════════════════════╝
                    """;
        System.out.println(s);
    }
}
