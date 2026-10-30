package DAO;

import MODEL.MODOL_PROFESSIONAL;
import java.util.List;

public interface MODUL_PROFESSIONAL_DAO {

    void afegirModul(MODOL_PROFESSIONAL modul);

    List<MODOL_PROFESSIONAL> llistarModuls();

    void actualitzarModul(int id, MODOL_PROFESSIONAL modul);

    void eliminarModul(int id);
}