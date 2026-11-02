package CONTROLLER;

import java.util.List;
import DAO.PROFESSOR_DAO;
import DAOImpl.PROFESSOR_DAOIMPL;
import MODEL.PROFESSOR;

public class PROFESSOR_CONTROLLER {
    private PROFESSOR_DAO professorDAO;

    public PROFESSOR_CONTROLLER() {
        this.professorDAO = new PROFESSOR_DAOIMPL();
    }

    // 1. Alta (Ja el tenies)
    public void altaProfessor(PROFESSOR professor) {
        professorDAO.addDam2(professor);
    }

    // 2. Llistar (Retorna la llista a la vista)
    public List<PROFESSOR> llistarProfessors() {
        return professorDAO.readDam2();
    }

    // 3. Actualitzar
    public void actualitzarProfessor(PROFESSOR professor) {
        professorDAO.updateDam2(professor);
    }

    // 4. Eliminar
    public void eliminarProfessor(int id) {
        professorDAO.deleteDam2(id);
    }
}
