package controllers.dossier;

import affichage.global.Globalmethod;
import controllers.System.SystemController;
import models.dossier.Composants.Medicament;
import models.dossier.Composants.Ordonnance;
import models.dossier.Composants.Scanner;

import java.util.ArrayList;

public class DossierController {

    public Boolean addDossier(String matriculeClient,ArrayList<String> ordonnances,ArrayList<String> medicaments,ArrayList<String> scanners){
        ArrayList<Ordonnance> ords = new ArrayList<>();
        ArrayList<Medicament> medis = new ArrayList<>();
        ArrayList<Scanner> scans = new ArrayList<>();
        String code = Globalmethod.genereteMatricule();
        models.dossier.Dossier dossier = new models.dossier.Dossier(code,"En attente","En attente",matriculeClient);
        for (String ord : ordonnances) {
            Ordonnance ordonnance = new Ordonnance(Globalmethod.genereteMatricule(),ord,dossier.getCode());
            ords.add(ordonnance);
        }
        for (String mc : medicaments) {
            Medicament medicament = new Medicament(mc,dossier.getCode());
            medis.add(medicament);
        }
        for (String sc : scanners) {
            models.dossier.Composants.Scanner scanner = new models.dossier.Composants.Scanner(sc,dossier.getCode());
            scans.add(scanner);
        }
        Boolean DossierAdded = dossier.createDossier(ords,medis,scans);
        if(!DossierAdded){
            SystemController systemController = new SystemController();
            systemController.checkDossier(code);
        }
        return DossierAdded;
    }
}
