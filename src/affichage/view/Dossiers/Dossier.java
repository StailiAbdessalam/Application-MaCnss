package affichage.view.Dossiers;

import java.util.ArrayList;
import java.util.Scanner;

public class Dossier {
    ArrayList<String> ordonances = new ArrayList<>();
    ArrayList<String> Medicament = new ArrayList<>();
    ArrayList<String> Scanner = new ArrayList<>();

    public int addDossier(){
      while(true){
          System.out.println("taper valide pour valider les donners de client .");
          String message = "1: Add Ordinances || "+this.ordonances.size();
          if (ordonances.size() == 0) {
              System.out.println(message);
          } else {
              System.out.println("\033[0;34m"+message+"\033[0m");
          }
          message = "2: Add Medicament || "+this.Medicament.size();
          if (Medicament.size() == 0) {
              System.out.println(message);
          } else {
              System.out.println("\033[0;34m"+message+"\033[0m");
          }

          message = "3: Add Scanner || "+this.Scanner.size() ;
          if (Scanner.size() == 0) {
              System.out.println(message);
          } else {
              System.out.println("\033[0;34m"+message+"\033[0m");
          }
          System.out.println("4: valider Dossier");
          System.out.println("5: Exit");
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
                  // called methodController to add dossier in a database
                  return 1;
              case 5:
                  return 0;
              default:
                  System.out.println("\033[0;31mvotre choix invalid\033[0m");
          }
      }
    }
}
