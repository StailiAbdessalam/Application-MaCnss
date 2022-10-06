package models.dossier;
import app.Cnx;
import models.dossier.Composants.Medicament;
import models.dossier.Composants.Ordonnance;
import models.dossier.Composants.Scanner;
import java.sql.*;
import java.util.ArrayList;

public class Dossier {
    private String code;
    private String status;
    private String response;
    private String matriculeClient;
    protected static Connection connection = Cnx.CNX();
    public Dossier(String code, String status, String response,String matriculeClient) {
        this.code = code;
        this.status = status;
        this.response = response;
        this.matriculeClient = matriculeClient;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }
    public void setResponse(String response) {
        this.response = response;
    }
    public String getMatriculeClient() {
        return matriculeClient;
    }
    public void setMatriculeClient(String matriculeClient) {
        this.matriculeClient = matriculeClient;
    }

    public Boolean createDossier(ArrayList<Ordonnance> ordonnances, ArrayList<Medicament> medicaments, ArrayList<Scanner> scanners){
        Boolean status = true;
        try {
            if (!ordonnances.isEmpty()){
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/macnss","root","");
                String sql = "INSERT INTO dossier (code,status,response,matricule_client,totalPrix) VALUES (?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql);
                connection.setAutoCommit(false);
                ps.setString(1,this.code);
                ps.setString(2,this.status);
                ps.setString(3,this.response);
                ps.setString(4,this.matriculeClient);
                ps.setString(5,null);
                status = ps.execute();
                connection.commit();
                ps.close();
                connection.close();

                for (Ordonnance o: ordonnances) {
                        o.addOrdonnance();
                }
                if (!medicaments.isEmpty()){
                    for (Medicament m: medicaments) {
                        m.addMedicament();
                    }
                }
                if (!scanners.isEmpty()) {
                    for (Scanner s : scanners) {
                        s.addScanner();
                    }
                }
            }else {
                System.out.println("Ordonnance is mandatory,You need at least one.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;

    }

    public static void  getAllPendingFoldersByStatus(String status){
        ArrayList dossiers = new ArrayList();
        try {
            String sql = "SELECT * FROM `dossier` WHERE status=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            ps.setString(1,status);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                do {
                    System.out.println(rs.getString("code"));
                    dossiers.add(new DossierAttend(rs.getString("code"),rs.getString("status"),rs.getString("response"),rs.getString("matricule_client")));
                }while(rs.next());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void updatedossier(String response,String totalPrix,String code){

        try {
            String sql = "UPDATE dossier SET response=? , totalPrix=? WHERE code=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,response);
            ps.setString(2,totalPrix);
            ps.setString(3,code);
            //connection.setAutoCommit(false);
            System.out.println(ps);
            int rs = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
