import models.Admin;
import models.Agent;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {

        //Scanner input = new Scanner(System.in);

        System.out.println(Agent.authenticate("agent1@gmail.com","agent11"));
        Agent a = new Agent("00000000","agent1","agent1","agent1@gmail.com","agent11");
        boolean res = a.addAgent();
        if (!res){
            System.out.println("created successfully!");
        }else {
            System.out.println("nope!");
        }
        Agent.showAgents();

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
