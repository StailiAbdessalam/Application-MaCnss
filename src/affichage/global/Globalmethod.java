package affichage.global;
import controllers.person.AdminController;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;

public class Globalmethod {
    public static HashMap login(String cle){
        //Pattern patternEmail = Pattern.compile(".s");
        //Pattern patternMatricule = Pattern.compile(".s");
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

    public static String genereteMatricule(){
        UUID idOne = UUID.randomUUID();
        String str=""+idOne;
        int uid=str.hashCode();
        String filterStr=""+uid;
        int chaytz = (13-filterStr.length());
        for (int i = 0; i < chaytz; i++) {
            double n = Math.random() * 10;
            filterStr = filterStr + ((int)n);
        }
        filterStr=filterStr.replaceAll("-", ""+ (int)Math.random() * 10);
        return filterStr;
    }


}
