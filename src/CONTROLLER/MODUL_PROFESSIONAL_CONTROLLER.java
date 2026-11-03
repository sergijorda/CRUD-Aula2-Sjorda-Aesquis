package CONTROLLER;

import java.util.List;
import DAO.MODUL_PROFESSIONAL_DAO;
import DAOImpl.MODUL_PROFESSIONAL_DAOIMPL;
import MODEL.MODUL_PROFESSIONAL;

public class MODUL_PROFESSIONAL_CONTROLLER {
    private MODUL_PROFESSIONAL_DAO modulDAO;

    public MODUL_PROFESSIONAL_CONTROLLER() {
        this.modulDAO = new MODUL_PROFESSIONAL_DAOIMPL();
    }

    public void altaModul(MODUL_PROFESSIONAL modul) {
        modulDAO.addDam2(modul);
    }

    public List<MODUL_PROFESSIONAL> llistarModuls() {
        return modulDAO.readDam2();
    }

    public void actualitzarModul(MODUL_PROFESSIONAL modul) {
        modulDAO.updateDam2(modul);
    }

    public void eliminarModul(int id) {
        modulDAO.deleteDam2(id);
    }
}
