package DAO;

import java.util.List;
import MODEL.PROFESSOR;

public interface PROFESSOR_DAO {
    void addDam2(PROFESSOR professor);
    List<PROFESSOR> readDam2();
    void updateDam2(PROFESSOR professor);
    void deleteDam2(int idProfessor);
}
