package affichage.view;
import affichage.global.Globalmethod;
import affichage.view.Dossiers.Dossier;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;


import services.Courier;
import services.SendService;
import models.SendEnhancedRequestBody;
import models.SendEnhancedResponseBody;
import models.SendRequestMessage;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;

public class Agent {
    public static int login() {
        HashMap checklogin = Globalmethod.login("Email");
            if(checklogin!=null){
                    System.out.println("votre information et correct");
                    String Cle = Globalmethod.sendEmail(checklogin.get("Email"));
                   while (true){
                       Boolean checkCle = checkCle(Cle);
                       if(Boolean.TRUE.equals(checkCle)){
                           return 1;
                       }else if(checkCle==null){
                           return 0;
                       }else {
                           System.out.println("votre cle incorrect");
                           continue;
                       }
                   }
            } else {
                System.out.println("\033[0;31mvotre donnée et invalid\033[0m");
                return 0;
            }
    }
    public static Boolean checkCle(String cleEmail){
        System.out.println("nous somme envoyer le cle d'entrer dans votre email || entrer votre cle d'entrer || or taper exit pour sortie :");
        Scanner scanCle = new Scanner(System.in);
        String Cle = scanCle.nextLine();
        if(Objects.equals(Cle, cleEmail)){
            return true;
        }else if(Objects.equals(Cle, "exit")) {
            return null;
        }else {
            return false;
        }
    }
    public static int MenuAgent(){
        while (true){
            System.out.println("choisi votre choix :");
            System.out.println("1: add Dossier.\n2: Géres les Dossiers\n3: log out");
            Scanner scanChoix = new Scanner(System.in);
            int choix = scanChoix.nextInt();
            switch (choix){
                case 1:
                    Dossier dossier = new Dossier();
                    int dossieradded = dossier.addDossier();
                    if(dossieradded==0){
                        continue;
                    }else {
                        System.out.println("file added");
                        continue;
                    }
                case 2:

                case 3:
                    System.out.println("1: Yes\n2: Non");
                    Scanner surQuite = new Scanner(System.in);
                    int sur = surQuite.nextInt();
                    if(sur==1){
                        return 0;
                    }else if (sur==2){
                        continue;
                    }else {
                        System.out.println("\033[0;31mchoix invalid\033[0m");
                        continue;
                    }
                default:
                    System.out.println("\033[0;31mchoix invalid\033[0m");
                    continue;
            }
        }

    }

    public static void addAgent()  {
        System.out.println("Entrer votre nom");
        Scanner scanNom = new Scanner(System.in);
        String nom = scanNom.nextLine();

        System.out.println("Entrer votre Prenom");
        Scanner scanPrenom = new Scanner(System.in);
        String prenom = scanPrenom.nextLine();

        System.out.println("Entrer votre Email");
        Scanner scanEmail = new Scanner(System.in);
        String Email = scanPrenom.nextLine();

        System.out.println("Entrer votre number phone");
        Scanner scanPhone = new Scanner(System.in);
        String Phone = scanPrenom.nextLine();

        System.out.println("\033[0;32mvotre agent ajouter par success\033[0m");
    }

    public static void sendEmail() {
        Courier.init("pk_test_XPKJ13ZCZQ4CDWJ6J18XYT3FYKAF");

        SendEnhancedRequestBody sendEnhancedRequestBody = new SendEnhancedRequestBody();
        SendRequestMessage sendRequestMessage = new SendRequestMessage();
        HashMap<String, String> to = new HashMap<String, String>();
        to.put("email", "the.staili.abdessalam@gmail.com");
        sendRequestMessage.setTo(to);

        HashMap<String, String> content = new HashMap<String, String>();
        content.put("title", "Simplon Clone : Nouveau Brief");
        content.put("body", "Hello test email");
        sendRequestMessage.setContent(content);

        HashMap<String, Object> data = new HashMap<String, Object>();
        sendRequestMessage.setData(data);
        sendEnhancedRequestBody.setMessage(sendRequestMessage);

        try {
            SendEnhancedResponseBody response = new SendService().sendEnhancedMessage(sendEnhancedRequestBody);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
