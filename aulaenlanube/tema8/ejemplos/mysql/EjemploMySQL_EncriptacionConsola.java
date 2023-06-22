package aulaenlanube.tema8.ejemplos.mysql;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class EjemploMySQL_EncriptacionConsola {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String pwdOriginal = "p3p3";
        String pwdIntroducida = "";

        String pwdEncriptada = BCrypt.hashpw(pwdOriginal, BCrypt.gensalt());
        System.out.println("La pwd encriptada es: " + pwdEncriptada);

        do {
            System.out.println("Dime la contraseña para verificarla");
            pwdIntroducida = scn.nextLine();
        } while (!BCrypt.checkpw(pwdIntroducida, pwdEncriptada));

        System.out.println("Contraseña verificada!!");
        scn.close();
    }

}
