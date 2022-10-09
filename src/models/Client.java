package models;

import models.person.Person;

import java.sql.*;

public class Client extends Person {
    public Client(String matricule, String firstName, String lastName, String email, String passWord) {
        super(matricule, firstName, lastName, email, passWord);
    }

    public Client() {};

    public static void showFoldersByClient(String clientMat){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/macnss","root","");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT code,status,totalPrix FROM dossier where matricule_client = '"+ clientMat+"'");
            while (resultSet.next()){
                System.out.println(" - CODE : "+resultSet.getString(1)+" | reponse final : "+resultSet.getString(2)+" | le montant remboursé : "+resultSet.getString(3));
            }
        }catch (SQLException e){
            System.out.println("Something went wrong : "+e);
        }
    }
}
