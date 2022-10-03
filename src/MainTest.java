import models.Admin;
import models.Agent;
import models.Client;
import models.dossier.Composants.Medicament;
import models.dossier.Composants.Ordonnance;
import models.dossier.Composants.Scanner;
import models.dossier.Dossier;

import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {
        ArrayList<Ordonnance> arrayOrdonnance = new ArrayList<>();
        ArrayList<Medicament> arrayMedicament = new ArrayList<>();
        ArrayList<Scanner> arrayScanner = new ArrayList<>();
        //Scanner input = new Scanner(System.in);
        Client client = new Client("HH29512","client1","client1","client1@gmail.com","client1");
        Dossier d = new Dossier("D31111","En attente","En attente",client.getMatricule());
        Ordonnance o1 = new Ordonnance("O111111","L3dam",d.getCode());
        arrayOrdonnance.add(o1);
        Medicament m1 = new Medicament("M111111",d.getCode());
        arrayMedicament.add(m1);
        models.dossier.Composants.Scanner s1 = new Scanner("S111111",d.getCode());
        arrayScanner.add(s1);

        d.createDossier(arrayOrdonnance,arrayMedicament,arrayScanner);



        //System.out.println(Agent.authenticate("agent1@gmail.com","agent11"));
        //Agent a = new Agent("00000000","agent1","agent1","agent1@gmail.com","agent11");
        //boolean res = a.addAgent();
        //if (!res){
        //    System.out.println("created successfully!");
        //}else {
        //    System.out.println("nope!");
        //}
        //Agent.showAgents();

        //System.out.println("hello word");
        //System.out.print("Matricule : ");
        //String mat = input.nextLine();
        //System.out.print("Nom : ");
        //String nom = input.nextLine();
        //System.out.print("Prenom : ");
        //String prenom = input.nextLine();
        //System.out.print("Email : ");
        //String email = input.nextLine();
        //System.out.print("Mot de passe : ");
        //String mdp = input.nextLine();

        //Admin admin = new Admin(mat, nom, prenom, email, mdp);
        //boolean result = admin.addAdmin();
        //if (!result) {
        //    System.out.println("Admin was successfully added!");
        //    System.out.printf("\n\n");
        //    System.out.println("\t\t Admins");
        //    Admin.showAdmins();
        //}
        return;

    }

}
