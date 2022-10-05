package models.System;

import app.Cnx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class System {

    protected String CodeDossier;
    protected Connection connection= Cnx.CNX();

    public String[]  getDossier(){
        String sql = "select  ,password from   where  = ?";
        return null;
    }


}
