package affichage;
import affichage.view.Admin;
import affichage.view.Agent;
import affichage.view.Client;

import java.util.Scanner;

public class Presantation {
    public void Presantation(){
      System.out.println("bonjour dans MCNSS :");
      while (true){
          int choixGlobal = this.MenuGlobal();
          switch (choixGlobal){
              case 1 :
                  int admin = Admin.login();
                  if(admin==0){
                      continue;
                  }else {
                      int choix = Admin.MenuAdmin();
                      if(choix==0){
                          continue;
                      }
                  }
              case 2 :
                  int agent = Agent.login();
                  if(agent==0){
                      continue;
                  }else {
                      int choix = Agent.MenuAgent();
                      if(choix==0){
                          continue;
                      }
                  }
              case 3 :
                  int client = Client.login();
                  if(client==0){
                      continue;
                  }else {
                      int choix = Client.MenuClient();
                      if(choix==0){
                          continue;
                      }
                  }
              case 4 :
                  System.exit(0);
              default:
                  System.out.println("\033[0;31mchoix invalid\033[0m");
                  continue;
          }
      }

    }
    public int MenuGlobal(){
            System.out.println("choixi Votre Role");
            System.out.println("1: Admin \n2: Agent\n3: Client\n4: Exit");
            Scanner scanMenuGlobal = new Scanner(System.in);
            int choixMenuGlobal = scanMenuGlobal.nextInt();
            return choixMenuGlobal;
    }

}
