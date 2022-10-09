package affichage.view;
import affichage.global.Globalmethod;
import affichage.view.Dossiers.Dossier;
import app.validation.EmailValidator;
import controllers.dossier.DossierController;
import controllers.person.AdminController;
import controllers.person.AgentController;

import java.util.Arrays;
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
        HashMap loginInputs = Globalmethod.login("Email");
        AgentController agent = new AgentController();
        Boolean agentValidation = agent.authenticate((String) loginInputs.get("loginKey"), (String) loginInputs.get("password"));
        if(agentValidation != null && agentValidation){
            System.out.println("votre information et correct");
            String Cle = Globalmethod.sendEmail(String.valueOf(loginInputs.get("loginKey")));
            while (true){
                Boolean checkCle = checkCle(Cle);
                if(Boolean.TRUE.equals(checkCle)){
                    return 1;
                }else if(checkCle==null){
                    return 0;
                }else {
                    System.out.println("votre cle est incorrect");
                    continue;
                }
            }
        }else {
            System.out.println("\033[0;31mvotre donnée et invalid\033[0m");
            return 0;
        }
    }
    public static Boolean checkCle(String cleEmail){
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
            System.out.println("choisi votre option :");
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
                        System.out.println("ed");
                        continue;
                    }
                case 2:
                    AgentController agentController = new AgentController();
                    while (true){
                        int gestionchoix = gestion();
                        switch (gestionchoix){
                            case 1:
                                System.out.println("choisi un Dossier");
                                agentController.getAllPendingFolders();
                                Scanner scan = new Scanner(System.in);
                                String code = scan.nextLine();
                                String status = updatstatus();
                                DossierController.updateState(status,code);
                                String message = "your Dossier N:"+code+" est :"+status;
                                String email = models.dossier.Dossier.getEmailByMatricule(code);
                                sendEmail(email,message);
                                continue;
                            case 2:
                                agentController.getAllPendingFolders();
                                System.out.println("-----------------------------------------------------------------------------------------");
                                continue;
                            case 3:
                                break;
                        }
                        break;
                    }
                    continue;
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

    public static HashMap  addAgent()  {
        HashMap<String,String> agentInfo = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        agentInfo.put("matricule",Globalmethod.genereteMatricule());
        System.out.println("Entrer le nom");
        String nom = scanner.nextLine();
        agentInfo.put("nom",nom);
        System.out.println("Entrer le Prenom");
        String prenom = scanner.nextLine();
        agentInfo.put("prenom",prenom);
        System.out.println("Entrer le Email");
        String email = scanner.nextLine();

        do {
            email = scanner.nextLine();
            agentInfo.put("email",email);
            if (!EmailValidator.isValid(email)){
                System.out.println("tape a valide email");
            }
        }while (!EmailValidator.isValid(email));

        return agentInfo;

    }

    public static void sendEmail(String email,String body) {
        Courier.init("pk_test_XPKJ13ZCZQ4CDWJ6J18XYT3FYKAF");
        SendEnhancedRequestBody sendEnhancedRequestBody = new SendEnhancedRequestBody();
        SendRequestMessage sendRequestMessage = new SendRequestMessage();
        HashMap<String, String> to = new HashMap<String, String>();
        to.put("email",email);
        sendRequestMessage.setTo(to);

        HashMap<String, String> content = new HashMap<String, String>();
        content.put("title", "MCNSS : Reponse Dossier");
        content.put("body", body);
        sendRequestMessage.setContent(content);

        HashMap<String, Object> data = new HashMap<String, Object>();
        sendRequestMessage.setData(data);
        sendEnhancedRequestBody.setMessage(sendRequestMessage);

        try {
            SendEnhancedResponseBody response = new SendService().sendEnhancedMessage(sendEnhancedRequestBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int gestion(){
      while (true){
          System.out.println("choisi votre option :");
          System.out.println("1- send reponse \n2- check all dosiier\n3- quiter");
          Scanner scan = new Scanner(System.in);
          int choix = scan.nextInt();
          if(choix>3 || choix <1){
              System.out.println("\033[0;31mchoix invalid\033[0m");
              continue;
          }else{
              return choix;
          }
      }
    }

    public static String updatstatus(){
       while (true){
           System.out.println("1- validate reumbourcement\n2- rejucted reumbourcement");
           Scanner scan = new Scanner(System.in);
           int choixstatus = scan.nextInt();
           switch (choixstatus){
               case 1:
                   return "Valide";
               case 2:
                   return "Failed";
               default:
                   System.out.println("\033[0;31mchoix invalid\033[0m");
                   continue;
           }
       }
    }
}
