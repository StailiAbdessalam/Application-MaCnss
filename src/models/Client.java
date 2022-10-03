package models;

import models.person.Person;

import java.sql.*;

public class Client extends Person {
    public Client(String matricule, String firstName, String lastName, String email, String passWord) {
        super(matricule, firstName, lastName, email, passWord);
    }

    public Client() {};
}
