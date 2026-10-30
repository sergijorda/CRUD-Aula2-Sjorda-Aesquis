package MODEL;

public class PROFESSOR {
    private String nom;
    private String cognom;
    private String id;

    public PROFESSOR(String nom, String cognom) {
        this.nom = nom;
        this.cognom = cognom;
    }

    public PROFESSOR(String cognom, String id, String nom) {
        this.cognom = cognom;
        this.id = id;
        this.nom = nom;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
