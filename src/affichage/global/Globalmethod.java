package affichage.global;

import java.util.Scanner;

public class Globalmethod {
    public static Boolean login(){
        System.out.println("entrer votre Email :");
        Scanner scanEmail = new Scanner(System.in);
        String Email = scanEmail.nextLine();
        System.out.println("entrer votre Password :");
        Scanner scanPassword = new Scanner(System.in);
        String Password = scanPassword.nextLine();

        return true;
    }
}
