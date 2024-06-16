package data;

import model.PedidoCompra;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoCompraDAO {
    public void create(PedidoCompra pedidoCompra) throws SQLException {
        String sql = "INSERT INTO PedidoCompra (dataPedido, statusPedido, idFornecedor) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(pedidoCompra.getDataPedido()));
            stmt.setString(2, pedidoCompra.getStatusPedido());
            stmt.setInt(3, pedidoCompra.getIdFornecedor());
            stmt.executeUpdate();
        }
    }

    public PedidoCompra read(int numPedidoCompra) throws SQLException {
        String sql = "SELECT * FROM PedidoCompra WHERE numPedidoCompra = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numPedidoCompra);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PedidoCompra(
                        rs.getInt("numPedidoCompra"),
                        rs.getDate("dataPedido").toLocalDate(),
                        rs.getString("statusPedido"),
                        rs.getInt("idFornecedor")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    public List<PedidoCompra> readAll() throws SQLException {
        List<PedidoCompra> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM PedidoCompra";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                pedidos.add(new PedidoCompra(
                    rs.getInt("numPedidoCompra"),
                    rs.getDate("dataPedido").toLocalDate(),
                    rs.getString("statusPedido"),
                    rs.getInt("idFornecedor")
                ));
            }
        }
        return pedidos;
    }

    public void update(PedidoCompra pedidoCompra) throws SQLException {
        String sql = "UPDATE PedidoCompra SET dataPedido = ?, statusPedido = ?, idFornecedor = ? WHERE numPedidoCompra = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(pedidoCompra.getDataPedido()));
            stmt.setString(2, pedidoCompra.getStatusPedido());
            stmt.setInt(3, pedidoCompra.getIdFornecedor());
            stmt.setInt(4, pedidoCompra.getNumPedidoCompra());
            stmt.executeUpdate();
        }
    }

    public void delete(int numPedidoCompra) throws SQLException {
        String sql = "DELETE FROM PedidoCompra WHERE numPedidoCompra = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numPedidoCompra);
            stmt.executeUpdate();
        }
    }
}
