package MODEL;

public class PROFESSOR {
    private int id;
    private String nom;
    private String cognom;

    public PROFESSOR(int id, String nom, String cognom) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
    }

    public PROFESSOR(String cognom, int id, String nom) {
        this.id = id;
        this.cognom = cognom;
        this.nom = nom;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getCognom() { return cognom; }
    public void setCognom(String cognom) { this.cognom = cognom; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
