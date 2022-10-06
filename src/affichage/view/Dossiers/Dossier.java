package affichage.view.Dossiers;

import controllers.dossier.DossierController;

import java.util.ArrayList;
import java.util.Scanner;

public class Dossier {
    ArrayList<String> ordonances = new ArrayList<>();
    ArrayList<String> medicaments = new ArrayList<>();
    ArrayList<String> scanners = new ArrayList<>();
    public int addDossier(){
      while(true){
          System.out.println("taper valide pour valider les donners de client .");
          String message = "1: Add Ordinances || "+this.ordonances.size();
          if (ordonances.size() == 0) {
              System.out.println(message);
          } else {
              System.out.println("\033[0;34m"+message+"\033[0m");
          }
          message = "2: Add Medicament || "+this.medicaments.size();
          if (medicaments.size() == 0) {
              System.out.println(message);
          } else {
              System.out.println("\033[0;34m"+message+"\033[0m");
          }

          message = "3: Add Scanner || "+this.scanners.size() ;
          if (scanners.size() == 0) {
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
                  System.out.println("entrer le type d'ordonance :"+ordonances.size());
                  Scanner scanOrdonnance = new Scanner(System.in);
                  ordonances.add(scanOrdonnance.nextLine());
                  continue;
              case 2:
                  System.out.println("entrer le code du Medicament :"+medicaments.size());
                  Scanner scanMedicament = new Scanner(System.in);
                  medicaments.add(scanMedicament.nextLine());
                  continue;
              case 3:
                  System.out.println("entrer le code du Scanner :"+scanners.size());
                  Scanner scanScanner = new Scanner(System.in);
                  scanners.add(scanScanner.nextLine());
                  continue;
              case 4:
                  System.out.println("Entrer le Matricule du Client");
                  Scanner scanner = new Scanner(System.in);
                  String matriculeClient = scanner.nextLine();
                  DossierController dossierController = new DossierController();
                  Boolean res = dossierController.addDossier(matriculeClient,ordonances,medicaments,scanners);
                  if (!res){
                      System.out.println("Dossier Created successfully");
                  }else {
                      System.out.println("something went wrong");
                  }
                  return 1;
              case 5:
                  return 0;
              default:
                  System.out.println("\033[0;31mvotre choix invalid\033[0m");
          }
      }
    }
}
