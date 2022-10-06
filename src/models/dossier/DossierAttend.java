package models.dossier;

public class DossierAttend {
    protected String code ;
    protected String status ;
    protected String response;
    protected String matricule_client;

    public DossierAttend(String code, String status, String response, String matricule_client) {
        this.code = code;
        this.status = status;
        this.response = response;
        this.matricule_client = matricule_client;
    }
}
