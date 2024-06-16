package data;

import model.PDV;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class pdvDAO {
    public void create(PDV pdv) throws SQLException {
        String sql = "INSERT INTO PDV (numPDV, idFuncionario) VALUES (?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pdv.getNumPDV());
            stmt.executeUpdate();
        }
    }

    public PDV read(int numPDV) throws SQLException {
        String sql = "SELECT * FROM PDV WHERE numPDV = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numPDV);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PDV(
                        rs.getInt("numPDV")
                    );
                }
            }
        }
        return null;
    }

    public List<PDV> readAll() throws SQLException {
        List<PDV> pdvs = new ArrayList<>();
        String sql = "SELECT * FROM PDV";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                pdvs.add(new PDV(
                    rs.getInt("numPDV")

                ));
            }
        }
        return pdvs;
    }

    public void update(PDV pdv) throws SQLException {
        String sql = "UPDATE PDV SET idFuncionario = ? WHERE numPDV = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(2, pdv.getNumPDV());
            stmt.executeUpdate();
        }
    }

    public void delete(int numPDV) throws SQLException {
        String sql = "DELETE FROM PDV WHERE numPDV = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numPDV);
            stmt.executeUpdate();
        }
    }
}
