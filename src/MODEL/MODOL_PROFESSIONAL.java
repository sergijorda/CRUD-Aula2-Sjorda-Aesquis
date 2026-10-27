package MODEL;

public class MODOL_PROFESSIONAL {
    private int id;
    private String nom;
    PROFESSOR professor;

    public MODOL_PROFESSIONAL(int id, String nom, PROFESSOR professor) {
        this.id = id;
        this.nom = nom;
        this.professor = professor;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public PROFESSOR getProfessor() {
        return professor;
    }
    public void setProfessor(PROFESSOR professor) {
        this.professor = professor;
    }
}
