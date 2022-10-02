package affichage.view;
import affichage.global.Globalmethod;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

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
                    continue;
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
