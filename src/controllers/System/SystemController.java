package controllers.System;

import models.System.Systeme;
import models.dossier.Dossier;

public class SystemController {

    public void checkDossier(String code){

    Double  TotalPrixMedicament =  Systeme.getPrixRembourcementTotalByTable(code,"medicaments_cnss","medicament");
    Double  TotalPrixScanner = Systeme.getPrixRembourcementTotalByTable(code,"scanner_cnss","scanner");
    Double totalPrixordonnace = Systeme.getPrixRembourcementTotalByTable(code,"ordonnance_cnss","ordonnance");
    Double rommbourcement = TotalPrixMedicament+TotalPrixScanner+totalPrixordonnace;
    String reponse="";
    if(rommbourcement > 1){
        reponse="valide";
    }else {
        reponse="failed";
    }
        Dossier.updatedossier(reponse, String.valueOf(rommbourcement),code);
    }
}
