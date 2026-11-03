package MODEL;

public class MODUL_PROFESSIONAL {
    private int id;
    private String nom;
    private int idProfessor;
    private String nomProfessor;

    public MODUL_PROFESSIONAL(int id, String nom, int idProfessor) {
        this.id = id;
        this.nom = nom;
        this.idProfessor = idProfessor;
    }

    public MODUL_PROFESSIONAL(int id, String nom, int idProfessor, String nomProfessor) {
        this.id = id;
        this.nom = nom;
        this.idProfessor = idProfessor;
        this.nomProfessor = nomProfessor;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getIdProfessor() { return idProfessor; }
    public void setIdProfessor(int idProfessor) { this.idProfessor = idProfessor; }

    public String getNomProfessor() { return nomProfessor; }
    public void setNomProfessor(String nomProfessor) { this.nomProfessor = nomProfessor; }
}
