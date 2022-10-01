package affichage.view;

import affichage.global.Globalmethod;

import java.util.Scanner;

public class Admin {

    public static int login() {
        Boolean checklogin = Globalmethod.login();
        if(checklogin){
            return 1;
        }else {
            System.out.println("\033[0;31mvotre donnée et invalid\033[0m");
            return 0;
        }

    }

    public static int MenuAdmin(){
       while (true){
           System.out.println("choisi votre choix :");
           System.out.println("1: add agent. \n2: Géres les Dossiers\n3: log out");
           Scanner scanChoix = new Scanner(System.in);
           int choix = scanChoix.nextInt();
           switch (choix){
               case 1:

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




}
