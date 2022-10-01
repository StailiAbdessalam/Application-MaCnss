package affichage;

import java.util.Scanner;

public class Presantation {

    public int MenuGlobal(){

        while (true){
            System.out.println("bonjour dans MCNSS :\nchoixi Votre Role");
            System.out.println("1: Admin \n2: Agent\n3: Patient\n4: Exit");
            Scanner scanMenuGlobal = new Scanner(System.in);
            int choixMenuGlobal = scanMenuGlobal.nextInt();
            if(choixMenuGlobal>4 || choixMenuGlobal<1){
                System.out.println("\033[0;31mchoix invalid\033[0m");
                continue;
            }else if(choixMenuGlobal==4){
                System.exit(0);
            }else {
                return choixMenuGlobal;
            }
        }

    }






}
