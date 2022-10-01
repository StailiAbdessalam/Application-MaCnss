package models;

import models.person.Person;

public class Agent extends Person {

    public Agent(String matricule, String firstName, String lastName, String email, String passWord) {
        super(matricule, firstName, lastName, email, passWord);
    }

    @Override
    protected Boolean authenticate(String email, String password) {
        return true;
    }
}
