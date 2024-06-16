package data;

import model.Estoque;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {
    public void create(Estoque estoque) throws SQLException {
        String sql = "INSERT INTO Estoque (quantProduto, idProduto) VALUES (?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, estoque.getQuantProduto());
            stmt.setInt(2, estoque.getIdProduto());
            stmt.executeUpdate();
        }
    }

    public Estoque read(int idProduto) throws SQLException {
        String sql = "SELECT * FROM Estoque WHERE idProduto = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Estoque(
                        rs.getInt("quantProduto"),
                        rs.getInt("idProduto")
                    );
                }
            }
        }
        return null;
    }

    public List<Estoque> readAll() throws SQLException {
        List<Estoque> estoques = new ArrayList<>();
        String sql = "SELECT * FROM Estoque";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                estoques.add(new Estoque(
                    rs.getInt("quantProduto"),
                    rs.getInt("idProduto")
                ));
            }
        }
        return estoques;
    }

    public void update(Estoque estoque) throws SQLException {
        String sql = "UPDATE Estoque SET quantProduto = ? WHERE idProduto = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, estoque.getQuantProduto());
            stmt.setInt(2, estoque.getIdProduto());
            stmt.executeUpdate();
        }
    }

    public void delete(int idProduto) throws SQLException {
        String sql = "DELETE FROM Estoque WHERE idProduto = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            stmt.executeUpdate();
        }
    }
}
