package affichage.view;

import affichage.global.Globalmethod;
import controllers.person.AdminController;
import controllers.person.ClientController;

import java.util.HashMap;
import java.util.Scanner;

public class Client {
    public static int login() {
        HashMap loginInputs = Globalmethod.login("Matricule");
        ClientController client = new ClientController();
        Boolean clientValidation = client.authenticate((String) loginInputs.get("loginKey"), (String) loginInputs.get("password"));
        if(clientValidation != null && clientValidation){
            return 1;
        }else {
            System.out.println("\033[0;31mvotre donnée et invalid\033[0m");
            return 0;
        }
    }

    public static int MenuClient(){
        while (true){
            System.out.println("choisi votre choix :");
            System.out.println("1: afficher les dossier. \n2: log out");
            Scanner scanChoix = new Scanner(System.in);
            int choix = scanChoix.nextInt();
            switch (choix){
                case 1:
                    models.Client.showFoldersByClient("HH29512");
                    continue;
                case 2:
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
}
