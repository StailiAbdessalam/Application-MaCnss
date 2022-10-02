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


}
