package controllers.person;

import models.Admin;
import models.Agent;

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

        return null;
    }
}
