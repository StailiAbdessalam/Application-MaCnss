package controllers.person;

import affichage.view.Agent;
import models.Admin;

import java.util.HashMap;

public class AdminController {
    public Boolean authenticate(String email, String password) {
        Admin admin = new Admin();
        String result = admin.getPassword(email,"admin","email");
        if (result == null) {
            return null;
        } else {
            if (result.equals(password))
                return true;
            else
                return false;
        }
    }

    public Boolean addAgent(){
        HashMap agentInfo = Agent.addAgent();
        String matricule = agentInfo.get("matricule").toString();
        String nom = agentInfo.get("nom").toString();
        String prenom = agentInfo.get("prenom").toString();
        String email = agentInfo.get("email").toString();
        String password = "123456";
        models.Agent agent = new models.Agent(matricule,prenom,nom,email,password);
        Boolean result = agent.addAgent();
        return result;
    }
}
