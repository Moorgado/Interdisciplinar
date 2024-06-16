package data;

import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    public void create(Produto produto) throws SQLException {
        String sql = "INSERT INTO Produto (descricaoProd, precoProd, categoriaProd, embalagemProd, unitCaixa) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getDescricaoProd());
            stmt.setDouble(2, produto.getPrecoProd());
            stmt.setString(3, produto.getCategoriaProd());
            stmt.setString(4, produto.getEmbalagemProd());
            stmt.setInt(5, produto.getUnitCaixa());
            stmt.executeUpdate();
        }
    }

    public Produto read(int codProduto) throws SQLException {
        String sql = "SELECT * FROM Produto WHERE codProduto = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codProduto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Produto(
        
                    );
                }
            }
        }
        return null;
    }

    public List<Produto> readAll() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produto";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                produtos.add(new Produto(
                 
                ));
            }
        }
        return produtos;
    }

    public void update(Produto produto) throws SQLException {
        String sql = "UPDATE Produto SET descricaoProd = ?, precoProd = ?, categoriaProd = ?, embalagemProd = ?, unitCaixa = ? WHERE codProduto = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getDescricaoProd());
            stmt.setDouble(2, produto.getPrecoProd());
            stmt.setString(3, produto.getCategoriaProd());
            stmt.setString(4, produto.getEmbalagemProd());
            stmt.setInt(5, produto.getUnitCaixa());
            stmt.setInt(6, produto.getCodProduto());
            stmt.executeUpdate();
        }
    }

    public void delete(int codProduto) throws SQLException {
        String sql = "DELETE FROM Produto WHERE codProduto = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codProduto);
            stmt.executeUpdate();
        }
    }
}
