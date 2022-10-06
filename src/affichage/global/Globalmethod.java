package affichage.global;

import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

import com.google.protobuf.Value;
import services.Courier;
import services.SendService;
import models.SendEnhancedRequestBody;
import models.SendEnhancedResponseBody;
import models.SendRequestMessage;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;

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
    public static String sendEmail(String email){
           Courier.init("pk_prod_Q02ESMDGP3MRBNMWTZ3Q1XN0A244");
            SendEnhancedRequestBody sendEnhancedRequestBody = new SendEnhancedRequestBody();
            SendRequestMessage sendRequestMessage = new SendRequestMessage();
            HashMap<String, String> to = new HashMap<String, String>();
            to.put("email", email);
            sendRequestMessage.setTo(to);

            HashMap<String, String> content = new HashMap<String, String>();
            content.put("title", "CLe d'entrer : Nouveau Cle");
            int idOne = Math.abs(UUID.randomUUID().hashCode());
            content.put("body", "Code :"+ idOne);
            sendRequestMessage.setContent(content);

            HashMap<String, Object> data = new HashMap<String, Object>();
            sendRequestMessage.setData(data);
            sendEnhancedRequestBody.setMessage(sendRequestMessage);

            try {
                SendEnhancedResponseBody response = new SendService().sendEnhancedMessage(sendEnhancedRequestBody);
                System.out.println("nous somme envoyer le cle d'entrer dans votre email || entrer votre cle d'entrer || or taper exit pour sortie :");
            } catch (IOException e) {
                e.printStackTrace();
            }
        return String.valueOf(idOne);
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
