package affichage.view;

import affichage.global.Globalmethod;
import controllers.person.AdminController;

import java.util.HashMap;
import java.util.Scanner;

public class Admin {
    public static int login() {
        HashMap loginInputs = Globalmethod.login("Email");
        AdminController admin = new AdminController();
        Boolean adminValidation = admin.authenticate((String) loginInputs.get("loginKey"), (String) loginInputs.get("password"));
        if(adminValidation != null && adminValidation){
            return 1;
        }else {
            System.out.println("\033[0;31mvotre donnée et invalid\033[0m");
            return 0;
        }
    }
    public static int MenuAdmin(){
       while (true){
           System.out.println("choisi votre choix :");
           System.out.println("1: add agent. \n2: log out");
           Scanner scanChoix = new Scanner(System.in);
           int choix = scanChoix.nextInt();
           switch (choix){
               case 1:
                   AdminController adminController = new AdminController();
                   Boolean ajout = adminController.addAgent();
                   if (!ajout){
                       System.out.println("Agent ajouté avec succès");
                   }else {
                       System.out.println("\033[0;quelque chose s'est mal passé\033[0;");
                   }
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
