package affichage.global;
import controllers.person.AdminController;
import java.util.HashMap;
import java.util.Scanner;
public class Globalmethod {
    public static HashMap login(String cle){
        HashMap<String,String> infoLogin = new HashMap<>();
        System.out.println("entrer votre "+cle+" :");
        Scanner scanEmail = new Scanner(System.in);
        infoLogin.put("loginKey",scanEmail.nextLine());
        System.out.println("entrer votre Password :");
        Scanner scanPassword = new Scanner(System.in);
        infoLogin.put("password",scanPassword.nextLine());
        if(!infoLogin.get("loginKey").isEmpty() && !infoLogin.get("password").isEmpty()){
            return infoLogin;
        }else {
            return null;
        }
    }

    public static String sendEmail(Object email){

        return "123";
    }

}
