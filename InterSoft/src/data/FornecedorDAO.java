package data;

import model.Fornecedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
    public void create(Fornecedor fornecedor) throws SQLException {
        String sql = "INSERT INTO Fornecedor (razaoSocial, CNPJ, nomeFantasia, tipoFornecedor, emailFornecedor, contatoFornec) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getRazaoSocial());
            stmt.setString(2, fornecedor.getCpfCNPJ());
            stmt.setString(3, fornecedor.getNomeFantasia());
            stmt.setString(4, fornecedor.getTipoPessoa());
            stmt.setString(5, fornecedor.getEmailForn());
            stmt.setString(6, fornecedor.getTelefoneForn());
            stmt.executeUpdate();
        }
    }

    public Fornecedor read(int idFornecedor) throws SQLException {
        String sql = "SELECT * FROM Fornecedor WHERE idFornecedor = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idFornecedor);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Fornecedor(
                    );
                }
            }
        }
        return null;
    }

    public List<Fornecedor> readAll() throws SQLException {
        List<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM Fornecedor";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                fornecedores.add(new Fornecedor(
                ));
            }
        }
        return fornecedores;
    }

    public void update(Fornecedor fornecedor) throws SQLException {
        String sql = "UPDATE Fornecedor SET razaoSocial = ?, CNPJ = ?, nomeFantasia = ?, tipoFornecedor = ?, emailFornecedor = ?, contatoFornec = ? WHERE idFornecedor = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getRazaoSocial());
            stmt.setString(2, fornecedor.getCpfCNPJ());
            stmt.setString(3, fornecedor.getNomeFantasia());
            stmt.setString(4, fornecedor.getTipoPessoa());
            stmt.setString(5, fornecedor.getEmailForn());
            stmt.setString(6, fornecedor.getTelefoneForn());
            stmt.setInt(7, fornecedor.getCodFornecedor());
            stmt.executeUpdate();
        }
    }

    public void delete(int idFornecedor) throws SQLException {
        String sql = "DELETE FROM Fornecedor WHERE idFornecedor = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idFornecedor);
            stmt.executeUpdate();
        }
    }
}
