package DAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DAO.PROFESSOR_DAO;
import MODEL.PROFESSOR;
import CONNEXIO.Utils;

public class PROFESSOR_DAOIMPL implements PROFESSOR_DAO {

    @Override
    public void addDam2(PROFESSOR professor) {
        String sql = "INSERT INTO Professors (nom, cognoms) VALUES (?, ?)";

        try (Connection conn = Utils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, professor.getNom());
            ps.setString(2, professor.getCognom());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Professor entrat correctament!");
            }
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    @Override
    public List<PROFESSOR> readDam2() {
        List<PROFESSOR> llista = new ArrayList<>();
        String sql = "SELECT * FROM Professors";

        // Fem servir Statement en comptes de PreparedStatement perquè no hi ha paràmetres d'entrada
        try (Connection conn = Utils.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String cognoms = rs.getString("cognoms");

                // Creem l'objecte professor recuperant el seu ID de la BBDD
                // Assegura't de tenir un constructor al teu MODEL que accepti (id, nom, cognom)
                PROFESSOR p = new PROFESSOR(id, nom, cognoms);
                llista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("ERROR al llistar professors: " + e.getMessage());
        }
        return llista;
    }

    @Override
    public void updateDam2(PROFESSOR professor) {
        String sql = "UPDATE Professors SET nom = ?, cognoms = ? WHERE id = ?";

        try (Connection conn = Utils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, professor.getNom());
            ps.setString(2, professor.getCognom());
            ps.setInt(3, professor.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Professor actualitzat correctament!");
            } else {
                System.out.println("No s'ha trobat cap professor amb l'ID especificat.");
            }
        } catch (SQLException e) {
            System.err.println("ERROR al modificar professor: " + e.getMessage());
        }
    }

    @Override
    public void deleteDam2(int idProfessor) {
        String sql = "DELETE FROM Professors WHERE id = ?";

        try (Connection conn = Utils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idProfessor); // Passem l'ID rebut per paràmetre

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Professor eliminat correctament!");
            } else {
                System.out.println("No s'ha trobat cap professor amb l'ID especificat.");
            }
        } catch (SQLException e) {
            System.err.println("ERROR al eliminar professor: " + e.getMessage());
        }
    }
}
