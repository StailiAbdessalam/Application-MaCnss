package affichage.global;

import java.util.HashMap;
import java.util.Scanner;

public class Globalmethod {
    public static HashMap login(String cle){
        HashMap<String,String> infoLogin = new HashMap<>();
        System.out.println("entrer votre "+cle+" :");
        Scanner scanEmail = new Scanner(System.in);
        infoLogin.put("Emain",scanEmail.nextLine());
        System.out.println("entrer votre Password :");
        Scanner scanPassword = new Scanner(System.in);
        infoLogin.put("Password",scanPassword.nextLine());
        // called a method in controller to check if email and password is correct
        if(true){
            return infoLogin;
        }else {
            return null;
        }
    }

    public static String sendEmail(Object email){

        return "123";
    }

}
