package affichage.view;

import affichage.global.Globalmethod;

import java.util.HashMap;
import java.util.Scanner;

public class Admin {

    public static int login() {
        HashMap checklogin = Globalmethod.login("Email");
        if(checklogin!=null){
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
                   addAgent();
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




}
