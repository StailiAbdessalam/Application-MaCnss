package controllers.System;

import models.System.System;

public class SystemController {
    protected String CodeDossier;
    public SystemController(String codeDossier) {
        this.CodeDossier = codeDossier;
    }

    public void checkDossier(){
        System systemModel=new System();
        String[] dossier = systemModel.getDossier();

    }
}
