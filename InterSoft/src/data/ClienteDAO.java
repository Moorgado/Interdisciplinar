package data;

import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void create(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (nomeCliente, cpfCliente, contatoCliente, dividaCli, valorDivida) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getCpfCliente());
            stmt.setString(3, cliente.getTelefoneCliente());
            stmt.setString(4, cliente.getDividaCli());
            stmt.setString(5, cliente.getValorDivida());
            stmt.executeUpdate();
        }
    }

    public Cliente read(int idCliente) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE idCliente = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                    );
                }
            }
        }
        return null;
    }

    public List<Cliente> readAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Cliente(
                    rs.getInt("idCliente"),
                    rs.getString("nomeCliente"),
                    rs.getString("cpfCliente")
                ));
            }
        }
        return clientes;
    }

    public void update(Cliente cliente) throws SQLException {
        String sql = "UPDATE Cliente SET nomeCliente = ?, cpfCliente = ?, contatoCliente = ?, dividaCli = ?, valorDivida = ? WHERE idCliente = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getCpfCliente());
            stmt.setString(3, cliente.getTelefoneCliente());
            stmt.setString(4, cliente.getDividaCli());
            stmt.setString(5, cliente.getValorDivida());
            stmt.setInt(6, cliente.getCodCliente());
            stmt.executeUpdate();
        }
    }

    public void delete(int idCliente) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE idCliente = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        }
    }
}
