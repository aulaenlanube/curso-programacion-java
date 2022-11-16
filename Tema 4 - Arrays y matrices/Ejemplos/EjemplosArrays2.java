import java.util.Random;

import javax.swing.JPopupMenu.Separator;

public class EjemplosArrays2 {

    public static void main(String[] args) {

        int elementos = 10;         //aquí va la cantidad de elementos del Array
        int max = 100;              //aquí va el valor máximo-1 de los elementos del Array
        String separador = " - ";   //aquí va el separador de los elementos del Array
        mostrarArray(crearArray(elementos,max), separador);       
    }

    static void mostrarArray(int[] n, String s)
    {
        for (int i = 0; i < n.length-1; i++) {
            System.out.print(n[i]+s);
        }
        System.out.println(n[n.length-1]);
    }

    static int[] crearArray(int elementos, int max)
    {
        int[] array = new int[elementos];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(max);            
        }
        return array;
    }

}
