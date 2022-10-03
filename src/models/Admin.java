package models;

import models.person.Person;

import java.sql.*;

public class Admin extends Person {


	public Admin(String matricule, String firstName, String lastName, String email, String passWord) {
		super(matricule, firstName, lastName, email, passWord);
	}



}
