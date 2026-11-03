package DAO;

import java.util.List;
import MODEL.MODUL_PROFESSIONAL;

public interface MODUL_PROFESSIONAL_DAO {
    void addDam2(MODUL_PROFESSIONAL modul);
    List<MODUL_PROFESSIONAL> readDam2();
    void updateDam2(MODUL_PROFESSIONAL modul);
    void deleteDam2(int idModul);
}
