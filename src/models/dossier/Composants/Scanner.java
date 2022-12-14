package models.dossier.Composants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Scanner {
        private String code;
        private String codeDossier;
        public Scanner(String code, String codeDossier) {
            this.code = code;
            this.codeDossier = codeDossier;
        }

    public Boolean addScanner(){
        boolean status = true;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/macnss","root","");
            String sql = "INSERT INTO scanner (code,code_dossier) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            ps.setString(1,this.code);
            ps.setString(2,this.codeDossier);

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
