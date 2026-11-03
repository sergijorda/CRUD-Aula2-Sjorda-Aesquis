package DAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DAO.MODUL_PROFESSIONAL_DAO;
import MODEL.MODUL_PROFESSIONAL;
import CONNEXIO.Utils;

public class MODUL_PROFESSIONAL_DAOIMPL implements MODUL_PROFESSIONAL_DAO {

    @Override
    public void addDam2(MODUL_PROFESSIONAL modul) {
        String sql = "INSERT INTO ModulsProfessionals (nom, id_professor) VALUES (?, ?)";
        try (Connection conn = Utils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, modul.getNom());
            ps.setInt(2, modul.getIdProfessor());

            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Mòdul professional afegit correctament!");
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    @Override
    public List<MODUL_PROFESSIONAL> readDam2() {
        List<MODUL_PROFESSIONAL> llista = new ArrayList<>();
        String sql = "SELECT m.id, m.nom, m.id_professor, p.nom AS nom_prof " +
                "FROM ModulsProfessionals m " +
                "LEFT JOIN Professors p ON m.id_professor = p.id";
        try (Connection conn = Utils.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                int idProf = rs.getInt("id_professor");
                String nomProf = rs.getString("nom_prof");
                if (nomProf == null) nomProf = "Sense professor assignat";

                llista.add(new MODUL_PROFESSIONAL(id, nom, idProf, nomProf));
            }
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        return llista;
    }

    @Override
    public void updateDam2(MODUL_PROFESSIONAL modul) {
        String sql = "UPDATE ModulsProfessionals SET nom = ?, id_professor = ? WHERE id = ?";
        try (Connection conn = Utils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, modul.getNom());
            ps.setInt(2, modul.getIdProfessor());
            ps.setInt(3, modul.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Mòdul professional actualitzat!");
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    @Override
    public void deleteDam2(int idModul) {
        String sql = "DELETE FROM ModulsProfessionals WHERE id = ?";
        try (Connection conn = Utils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idModul);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Mòdul professional eliminat!");
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
