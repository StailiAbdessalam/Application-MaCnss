package models;

import models.person.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Agent extends Person {

    public Agent(String matricule, String firstName, String lastName, String email, String passWord) {
        super(matricule, firstName, lastName, email, passWord);
    }

    public Boolean addAgent(){
        boolean status = true;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/macnss","root","");
            String sql = "INSERT INTO agent (matricule,nom,prenom,email,password) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            ps.setString(1,this.matricule);
            ps.setString(2,this.lastName);
            ps.setString(3,this.firstName);
            ps.setString(4,this.email);
            ps.setString(5,this.passWord);
            status = ps.execute();
            connection.commit();
            ps.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }

    @Override
    protected Boolean authenticate(String email, String password) {
        return true;
    }
}
