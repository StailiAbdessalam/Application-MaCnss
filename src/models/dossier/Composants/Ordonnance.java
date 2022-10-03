package models.dossier.Composants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ordonnance {
    private String code;
    private String medecinType;
    private String codeDossier;

    public Ordonnance(String code, String medecinType, String codeDossier) {
        this.code = code;
        this.medecinType = medecinType;
        this.codeDossier = codeDossier;
    }

    public Boolean addOrdonnance(){
        boolean status = true;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/macnss","root","");
            String sql = "INSERT INTO ordonnance (code,type_medecin,code_dossier) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            ps.setString(1,this.code);
            ps.setString(2,this.medecinType);
            ps.setString(3,this.codeDossier);
            status = ps.execute();
            connection.commit();
            ps.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
}
