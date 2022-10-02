package models;

import models.person.Person;

import java.sql.*;

public class Admin extends Person {


	public Admin(String matricule, String firstName, String lastName, String email, String passWord) {
		super(matricule, firstName, lastName, email, passWord);
	}

	public static Boolean authenticate(String email, String password) {
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/macnss","root","");
			String sql = "select email,password from admin where email = ?";
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

	/*
	* getPassword take email and return password if email doesn't exist return null
	* Parameter : String Email
	* Return String (PassWord)
	 */
	public static String getPassword(String email){
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/macnss","root","");
			String sql = "select email,password from admin where email = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			connection.setAutoCommit(false);
			ps.setString(1,email);
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
