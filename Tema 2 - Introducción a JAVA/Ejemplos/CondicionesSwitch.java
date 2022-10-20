public class CondicionesSwitch {

    public static void main(String[] args) {

        String palabra = "ab";
        palabra = palabra.toUpperCase();

        switch (palabra) {
            case "AB":
                System.out.println("Opción AB");
                break;
            case "A2":
                System.out.println("Opción A2");
                break;
            default:
                System.out.println("Opción por defecto");
        }
    }

}
