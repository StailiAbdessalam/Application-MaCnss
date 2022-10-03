package models.person;

import java.sql.*;

public abstract class Person {
	protected String matricule;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String passWord;

    public Person(String matricule, String firstName, String lastName, String email, String passWord) {
        this.matricule = matricule;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passWord = passWord;
    }

    public Person() {}

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /*
     * getPassword take email and return password if email doesn't exist return null
     * Parameter : String Email
     * Return String (PassWord)
     */
    public String getPassword(String loginId,String table,String loginCle){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/macnss","root","");
            String sql = "select "+loginCle+",password from "+table+" where email = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            ps.setString(1,loginId);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == false) {
                return null;
            } else {
                String pw = rs.getString(2);
                return pw;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
