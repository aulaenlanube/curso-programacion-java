package aulaenlanube.tema9.ejemplos;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EjemploRectangulosQuicksort extends JPanel {

    private int dimension;
    private int espaciado;
    private int rectangulos;
    private int intervalo;
    private int[] alturas;

    public EjemploRectangulosQuicksort(int dimension, int espaciado, int rectangulos, int intervalo) {

        this.dimension = dimension;
        this.espaciado = espaciado;
        this.rectangulos = rectangulos;
        this.intervalo = intervalo;

        // creamos las alturas
        alturas = new int[rectangulos];
        for (int i = 0; i < rectangulos; i++) {
            alturas[i] = dimension * (i + 1);
        }

        // desordenamos array
        desordenar();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < rectangulos; i++) {
            int x = i * (dimension + espaciado) + 5;
            int alturaActual = alturas[i];
            int y = getHeight() - alturaActual;
            g.fillRect(x, y, dimension, alturaActual);
        }
    }

    public void desordenar() {

        for (int i = 0; i < alturas.length; i++) {
            int indice = new Random().nextInt(alturas.length);
            int temp = alturas[indice];
            alturas[indice] = alturas[i];
            alturas[i] = temp;
        }
    }

    public void quickSort() {
        try {
            Thread.sleep(1000);
            quicksort(alturas, 0, alturas.length - 1);
            JOptionPane.showMessageDialog(null, "Se ha ordenado el array de "+alturas.length+" elementos", "Ordenación",
            JOptionPane.INFORMATION_MESSAGE);
        } catch (InterruptedException e) {           
            e.printStackTrace();
        }        
    }

    private void quicksort(int A[], int izq, int der) {

        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;

        try {
            while (i < j) { // mientras no se crucen las búsquedas
                while (A[i] <= pivote && i < j)
                    i++; // busca elemento mayor que pivote
                while (A[j] > pivote)
                    j--; // busca elemento menor que pivote
                if (i < j) { // si no se han cruzado
                    aux = A[i]; // los intercambia
                    A[i] = A[j];
                    A[j] = aux;

                    //esperamos el intervalo en ms
                    Thread.sleep(intervalo);
                    super.repaint();
                }
            }

            A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
            A[j] = pivote; // los menores a su izquierda y los mayores a su derecha

            //esperamos el intervalo en ms
            Thread.sleep(intervalo);
            super.repaint();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (izq < j - 1)
            quicksort(A, izq, j - 1); // ordenamos subarray izquierdo
        if (j + 1 < der)
            quicksort(A, j + 1, der); // ordenamos subarray derecho
    }

    
    public static void main(String[] args) {

        int dimension = 20;  //px 
        int espaciado = 5;  //px 
        int rectangulos = 40; //px 
        int intervalo = 100; //ms
        

        JFrame frame = new JFrame();
        EjemploRectangulosQuicksort rects = new EjemploRectangulosQuicksort(dimension, espaciado, rectangulos, intervalo);
        frame.add(rects);
        frame.setSize((dimension+espaciado)*rectangulos+20,dimension*rectangulos+40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        rects.quickSort();       
    }
}