package models;
import models.person.Person;
import java.sql.*;

public class Agent extends Person {

    public Agent(String matricule, String firstName, String lastName, String email, String passWord) {
        super(matricule, firstName, lastName, email, passWord);
    }




    public static Boolean authenticate(String email, String password) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/macnss","root","");
            String sql = "select email,password from agent where email = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == false) {
                return null;
            } else {
                String pw = rs.getString(2);
                if (pw.equals(password))
                    return true;
                else
                    return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
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

    public static void showAgents(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/macnss","root","");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM agent");
            while (resultSet.next()){
                System.out.println("    MATRICULE : "+resultSet.getString(1)+" | NOM : "+resultSet.getString(2)+" | PRENOM : "+resultSet.getString(3)+" | EMAIL : "+resultSet.getString(4));
            }
        }catch (SQLException e){
            System.out.println("Something went wrong : "+e);
        }
    }



}
