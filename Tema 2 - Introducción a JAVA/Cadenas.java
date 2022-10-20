public class Cadenas {

    public static void main(String[] args) {
        
        String cadena = "    Curso JAVA    ".trim();        
        int longitud = cadena.length();  
        char letraFinal = cadena.charAt(cadena.length()-1);   
        String cadenaMayusculas = cadena.toUpperCase(); 
        String cadenaMinusculas = cadena.toLowerCase();
        String palabra = cadena.substring(0, 5);

        System.out.println("["+cadena+"] tiene "+longitud+" caracteres.");
        System.out.println("Letra final: "+letraFinal);   
        System.out.println("["+cadena+"] en mayúsculas es ["+cadenaMayusculas+"]");     
        System.out.println("["+cadena+"] en minúsculas es ["+cadenaMinusculas+"]");  
        System.out.println("La primera palabra es: ["+palabra+"]");
    }
    
}
