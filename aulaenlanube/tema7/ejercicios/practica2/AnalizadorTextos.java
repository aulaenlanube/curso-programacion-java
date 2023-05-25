package aulaenlanube.tema7.ejercicios.practica2;

import java.util.*;

public class AnalizadorTextos {
    
    private String texto;
    private Map<String, Integer> palabras;

    public AnalizadorTextos(String texto) {
        this.texto = texto.toLowerCase();
        this.palabras = new HashMap<>();
        contarPalabras();
    }

    private void contarPalabras() {
        String[] arr = texto.split("\\W+");
        for (String str : arr) {
            palabras.put(str, palabras.getOrDefault(str, 0) + 1);
        }
    }

    public List<Map.Entry<String, Integer>> palabrasMasFrecuentes(int n) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(palabras.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return list.subList(0, Math.min(n, list.size()));
    }

    public List<Map.Entry<String, Integer>> palabrasMenosFrecuentes(int n) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(palabras.entrySet());
        list.sort(Map.Entry.comparingByValue());
        return list.subList(0, Math.min(n, list.size()));
    }

    public Map<Integer, List<String>> palabrasPorLongitud() {
        Map<Integer, List<String>> longitudPalabras = new HashMap<>();
        for (String palabra : palabras.keySet()) {
            int longitud = palabra.length();
            if (!longitudPalabras.containsKey(longitud)) {
                longitudPalabras.put(longitud, new ArrayList<>());
            }
            longitudPalabras.get(longitud).add(palabra);           
        }
        for (Map.Entry<Integer,List<String>> longitudActual : longitudPalabras.entrySet()) {
            Collections.sort(longitudActual.getValue());            
        }
        return longitudPalabras;
    }
}

