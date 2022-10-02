package models.dossier;

import models.dossier.Composants.Medicament;
import models.dossier.Composants.Ordonnance;
import models.dossier.Composants.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dossier {
    private String code;
    private String status;
    private String response;
    private String matriculeClient;

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

        boolean status = true;
        try {
            if (!ordonnances.isEmpty()){
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/macnss","root","");
                String sql = "INSERT INTO dossier (code,status,response,matricule_client) VALUES (?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql);
                connection.setAutoCommit(false);
                ps.setString(1,this.code);
                ps.setString(2,this.status);
                ps.setString(3,this.response);
                ps.setString(4,this.matriculeClient);
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


}
