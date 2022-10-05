package controllers.person;

import models.Admin;

public class AgentController {
    public Boolean authenticate(String email, String password) {
        Admin admin = new Admin();
        String result = admin.getPassword(email,"agent","email");
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
