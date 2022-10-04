package affichage.view;

import affichage.global.Globalmethod;
import controllers.person.AdminController;
import controllers.person.ClientController;

import java.util.HashMap;

public class Client {
    public static int login() {
        HashMap loginInputs = Globalmethod.login("Matricule");
        ClientController client = new ClientController();
        Boolean clientValidation = client.authenticate((String) loginInputs.get("loginKey"), (String) loginInputs.get("password"));
        if(clientValidation != null && clientValidation){
            return 1;
        }else {
            System.out.println("\033[0;31mvotre donnée et invalid\033[0m");
            return 0;
        }
    }
}
