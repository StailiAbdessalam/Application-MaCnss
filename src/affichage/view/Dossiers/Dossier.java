package affichage.view.Dossiers;

import java.util.ArrayList;
import java.util.Scanner;

public class Dossier {
    ArrayList<String> ordonances = new ArrayList<>();
    ArrayList<String> Medicament = new ArrayList<>();
    ArrayList<String> Scanner = new ArrayList<>();

    public void addDossier(){
      while(true){
          System.out.println("taper valide pour valider les donners de client .");
          String message = "1: Add Ordinances || "+this.ordonances.size();
          if (ordonances.size() == 0) {
              System.out.println(message);
          } else {
              System.out.println("\033[0;34m"+message+"\033[0m");
          }

          System.out.println("2: Add Medicament || "+this.Medicament.size() );
          System.out.println("3: Add Ordinances || "+this.Scanner.size() );
          System.out.println("4: valider Dossier " );
          Scanner choix = new Scanner(System.in);
          int choiDossier = choix.nextInt();
          switch (choiDossier){
              case 1 :
                  System.out.println("entrer votre ordonance N:"+ordonances.size());
                  Scanner scanOrdonnance = new Scanner(System.in);
                  ordonances.add(scanOrdonnance.nextLine());
                  continue;
              case 2:
                  System.out.println("entrer votre Medicament N:"+Medicament.size());
                  Scanner scanMedicament = new Scanner(System.in);
                  Medicament.add(scanMedicament.nextLine());
                  continue;
              case 3:
                  System.out.println("entrer votre Scanner N:"+Scanner.size());
                  Scanner scanScanner = new Scanner(System.in);
                  Scanner.add(scanScanner.nextLine());
                  continue;

              case 4:
                  System.out.println("valide ");
              case 5:

          }
      }
    }
}
