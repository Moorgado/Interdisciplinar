package data;

import model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public void create(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO Funcionario (nomeFuncionario, cpfFuncionario, cargoFuncionario, contatoFuncionario) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNomeFuncionario());
            stmt.setString(2, funcionario.getCpfFuncionario());
            stmt.setString(3, funcionario.getCargo());
            stmt.setString(4, funcionario.getTelefoneFunc());
            stmt.executeUpdate();
        }
    }

public Funcionario read(int idFuncionario) throws SQLException {
        String sql = "SELECT * FROM Funcionario WHERE idFuncionario = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idFuncionario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Funcionario(
                        rs.getInt("idFuncionario"),
                        rs.getString("nomeFuncionario"),
                        rs.getString("cpfFuncionario"),
                        rs.getString("cargo"),
                        rs.getString("contatoFuncionario")
                    );
                }
            }
        }
        return null;
    }

public List<Funcionario> read() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM Funcionario";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                funcionarios.add(new Funcionario(
                    rs.getInt("idFuncionario"),
                    rs.getString("nomeFuncionario"),
                    rs.getString("cpfFuncionario"),
                    rs.getString("cargo"),
                    rs.getString("contatoFuncionario")
                ));
            }
        }
        return funcionarios;
    }

public void update(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE Funcionario SET nomeFuncionario = ?, cpfFuncionario = ?, cargoFuncionario = ?, contatoFuncionario = ? WHERE idFuncionario = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNomeFuncionario());
            stmt.setString(2, funcionario.getCpfFuncionario());
            stmt.setString(3, funcionario.getCargo());
            stmt.setString(4, funcionario.getTelefoneFunc());
            stmt.setInt(5, funcionario.getCodFunconario());
            stmt.executeUpdate();
    }
}

public void delete(int codFunconario) throws SQLException {
    String sql = "DELETE FROM Funcionario WHERE codFunconario = ?";
    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, codFunconario);
        stmt.executeUpdate();
        }
    }
}

