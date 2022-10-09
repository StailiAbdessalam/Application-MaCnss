package controllers.person;

import app.security.BCrypt;
import models.Admin;
import models.dossier.Dossier;

import java.util.ArrayList;

public class AgentController {
    public Boolean authenticate(String email, String password) {
        Admin admin = new Admin();
        String result = admin.getPassword(email,"agent","email");
        if (result == null) {
            return null;
        } else {
            return BCrypt.checkpw(password, result);
        }
    }


    public void getAllPendingFolders(){
        ArrayList<Dossier> folders;
        folders = Dossier.getAllFoldersByStatus("En attente");
        for (int i = 0; i < folders.size(); i++) {
            Dossier d = folders.get(i);
            Dossier d1 = folders.get(i);
            Dossier d2 = folders.get(i);
            System.out.println((i+1) + "- Dossier code : "+ d.getCode() + " | response : "+ d.getResponse());
        }
    }






}
