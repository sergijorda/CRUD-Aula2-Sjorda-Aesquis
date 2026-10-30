package DAOImpl;

import DAO.MODUL_PROFESSIONAL_DAO;
import MODEL.MODOL_PROFESSIONAL;
import MODEL.PROFESSOR;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MODUL_PROFESSIONAL_DAOIMPL
        implements MODUL_PROFESSIONAL_DAO {

    private final Connection connexio;

    public MODUL_PROFESSIONAL_DAOIMPL(Connection connexio) {
        this.connexio = connexio;
    }

    @Override
    public void afegirModul(MODOL_PROFESSIONAL modul) {
        String sql = "INSERT INTO moduls_professionals "
                + "(id, nom, professor_id) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connexio.prepareStatement(sql)) {

            stmt.setInt(1, modul.getId());
            stmt.setString(2, modul.getNom());
            stmt.setInt(3, modul.getProfessor().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No s'ha pogut afegir el mòdul.", e);
        }
    }

    @Override
    public List<MODOL_PROFESSIONAL> llistarModuls() {
        List<MODOL_PROFESSIONAL> moduls = new ArrayList<>();

        // El JOIN permet recuperar també les dades del professor.
        String sql = "SELECT m.id, m.nom, "
                + "p.id AS professor_id, "
                + "p.nom AS professor_nom, "
                + "p.cognom AS professor_cognom "
                + "FROM moduls_professionals m "
                + "JOIN professors p ON m.professor_id = p.id "
                + "ORDER BY m.id";

        try (PreparedStatement stmt = connexio.prepareStatement(sql);
             ResultSet resultat = stmt.executeQuery()) {

            while (resultat.next()) {
                PROFESSOR professor = new PROFESSOR(
                        resultat.getString("professor_nom"),
                        resultat.getString("professor_cognom")
                );

                professor.setId(resultat.getInt("professor_id"));

                MODOL_PROFESSIONAL modul = new MODOL_PROFESSIONAL(
                        resultat.getInt("id"),
                        resultat.getString("nom"),
                        professor
                );

                moduls.add(modul);
            }

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No s'han pogut llistar els mòduls.", e);
        }

        return moduls;
    }

    @Override
    public void actualitzarModul(int id, MODOL_PROFESSIONAL modul) {
        String sql = "UPDATE moduls_professionals "
                + "SET nom = ?, professor_id = ? WHERE id = ?";

        try (PreparedStatement stmt = connexio.prepareStatement(sql)) {

            stmt.setString(1, modul.getNom());
            stmt.setInt(2, modul.getProfessor().getId());
            stmt.setInt(3, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No s'ha pogut actualitzar el mòdul.", e);
        }
    }

    @Override
    public void eliminarModul(int id) {
        String sql = "DELETE FROM moduls_professionals WHERE id = ?";

        try (PreparedStatement stmt = connexio.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No s'ha pogut eliminar el mòdul.", e);
        }
    }
}