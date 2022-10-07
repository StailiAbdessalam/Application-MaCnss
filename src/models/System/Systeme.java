package models.System;
import app.Cnx;
import java.sql.*;


public class Systeme {
    protected static Connection connection= Cnx.CNX();
       public static Double getPrixRembourcementTotalByTable(String CodeDossier,String TableCnss,String TableDonner ){
        try {
            String sql = "SELECT SUM(prix_rembourcement)"+
                          "FROM "+TableCnss+
                        " WHERE code=(SELECT code "+
                        "FROM "+TableDonner+" WHERE code_dossier=?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            System.out.println(sql);
            connection.setAutoCommit(false);
            ps.setString(1,CodeDossier);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
