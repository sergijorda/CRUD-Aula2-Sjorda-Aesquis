package CONTROLLER;

import DAO.PROFESSOR_DAO;
import DAOImpl.PROFESSOR_DAOIMPL;
import MODEL.PROFESSOR;

public class PROFESSOR_CONTROLLER {
    private PROFESSOR_DAO professorDAO;

    public PROFESSOR_CONTROLLER() {
        this.professorDAO = new PROFESSOR_DAOIMPL();
    }

    public void altaProfessor(PROFESSOR professor) {
        professorDAO.addDam2(professor);
    }
}
