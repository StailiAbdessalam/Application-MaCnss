package affichage.view;
import affichage.global.Globalmethod;
import affichage.view.Dossiers.Dossier;
import controllers.person.AdminController;
import controllers.person.AgentController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

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
        agentInfo.put("email",email);

        return agentInfo;
    }

}
