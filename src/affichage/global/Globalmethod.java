package affichage.global;
import controllers.person.AdminController;
import java.util.HashMap;
import java.util.Scanner;
public class Globalmethod {
    public static HashMap login(String cle){
        HashMap<String,String> infoLogin = new HashMap<>();
        System.out.println("entrer votre "+cle+" :");
        Scanner scanEmail = new Scanner(System.in);
        infoLogin.put("Email",scanEmail.nextLine());
        System.out.println("entrer votre Password :");
        Scanner scanPassword = new Scanner(System.in);
        infoLogin.put("Password",scanPassword.nextLine());
        AdminController admin = new AdminController();
        Boolean adminValid = admin.authenticate(infoLogin.get("Email"),infoLogin.get("Password"));
        if(adminValid !=null && adminValid){
            return infoLogin;
        }else {
            return null;
        }
    }

    public static String sendEmail(Object email){

        return "123";
    }

}
