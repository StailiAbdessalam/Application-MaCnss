package controllers.person;

import models.Admin;

public class ClientController {

    public Boolean authenticate(String matricule, String password) {
        Admin admin = new Admin();
        String result = admin.getPassword(matricule,"client","matricule");
        if (result == null) {
            return null;
        } else {
            if (result.equals(password))
                return true;
            else
                return false;
        }
    }
}
