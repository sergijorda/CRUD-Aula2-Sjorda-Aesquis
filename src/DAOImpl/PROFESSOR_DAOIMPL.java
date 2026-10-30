package DAOImpl;

import DAO.PROFESSOR_DAO;
import MODEL.PROFESSOR;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PROFESSOR_DAOIMPL implements PROFESSOR_DAO {

    private final Connection connexio;

    public PROFESSOR_DAOIMPL(Connection connexio) {
        this.connexio = connexio;
    }

    @Override
    public void afegirProfessor(PROFESSOR professor) {
        String sql = "INSERT INTO professors (nom, cognom) VALUES (?, ?)";

        try (PreparedStatement stmt = connexio.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, professor.getNom());
            stmt.setString(2, professor.getCognom());

            stmt.executeUpdate();

            // Recuperem l'id que ha generat la base de dades.
            try (ResultSet resultat = stmt.getGeneratedKeys()) {
                if (resultat.next()) {
                    professor.setId(resultat.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No s'ha pogut afegir el professor.", e);
        }
    }

    @Override
    public List<PROFESSOR> llistarProfessors() {
        List<PROFESSOR> professors = new ArrayList<>();

        String sql = "SELECT id, nom, cognom FROM professors ORDER BY id";

        try (PreparedStatement stmt = connexio.prepareStatement(sql);
             ResultSet resultat = stmt.executeQuery()) {

            while (resultat.next()) {
                PROFESSOR professor = new PROFESSOR(
                        resultat.getString("nom"),
                        resultat.getString("cognom")
                );

                professor.setId(resultat.getInt("id"));
                professors.add(professor);
            }

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No s'han pogut llistar els professors.", e);
        }

        return professors;
    }

    @Override
    public void actualitzarProfessor(int id, PROFESSOR professor) {
        String sql = "UPDATE professors SET nom = ?, cognom = ? WHERE id = ?";

        try (PreparedStatement stmt = connexio.prepareStatement(sql)) {

            stmt.setString(1, professor.getNom());
            stmt.setString(2, professor.getCognom());
            stmt.setInt(3, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No s'ha pogut actualitzar el professor.", e);
        }
    }

    @Override
    public void eliminarProfessor(int id) {
        String sql = "DELETE FROM professors WHERE id = ?";

        try (PreparedStatement stmt = connexio.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No s'ha pogut eliminar el professor.", e);
        }
    }
}