package controllers.person;

import affichage.view.Agent;
import app.Config;
import app.security.BCrypt;
import models.Admin;

import java.util.HashMap;

public class AdminController {
    public Boolean authenticate(String email, String password) {
        Admin admin = new Admin();
        String result = admin.getPassword(email,"admin","email");
        if (result == null) {
            return null;
        } else {
            return BCrypt.checkpw(password,result);
        }
    }

    public Boolean addAgent(){
        HashMap agentInfo = Agent.addAgent();
        String matricule = agentInfo.get("matricule").toString();
        String nom = agentInfo.get("nom").toString();
        String prenom = agentInfo.get("prenom").toString();
        String email = agentInfo.get("email").toString();
        String password = "123456";
        String hashedPassword = BCrypt.hashpw(password, Config.salt);
        models.Agent agent = new models.Agent(matricule,prenom,nom,email,hashedPassword);
        return agent.addAgent();
    }
}
