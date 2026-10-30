package DAO;

import MODEL.PROFESSOR;
import java.util.List;

public interface PROFESSOR_DAO {

    void afegirProfessor(PROFESSOR professor);

    List<PROFESSOR> llistarProfessors();

    void actualitzarProfessor(int id, PROFESSOR professor);

    void eliminarProfessor(int id);
}