import models.Admin;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Matricule : ");
        String mat = input.nextLine();
        System.out.print("Nom : ");
        String nom = input.nextLine();
        System.out.print("Prenom : ");
        String prenom = input.nextLine();
        System.out.print("Email : ");
        String email = input.nextLine();
        System.out.print("Mot de passe : ");
        String mdp = input.nextLine();

        Admin admin = new Admin(mat, nom, prenom, email, mdp);
        boolean result = admin.addAdmin();

        if (!result) {
            System.out.println("Admin was successfully added!");
            System.out.printf("\n\n");
            System.out.println("\t\t Admins");

            Admin.showAdmins();
            return;
        } else {
            return;
        }


    }


}