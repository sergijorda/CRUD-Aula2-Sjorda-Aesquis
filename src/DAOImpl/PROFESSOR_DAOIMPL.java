package DAOImpl;
import java.sql.*;

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
}
