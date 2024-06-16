package model;

import java.time.LocalDate;
import java.util.List;

public class PedidoCompra {
    
    private int idPedidoCompra; 
    private int numPedidoCompra;
    private LocalDate dataPedido;
    private String statusPedido;
    private List<ItensPedido> itensPedido;
    private int idFornecedor;

    public PedidoCompra(int idPedidoCompra, LocalDate dataPedido, String statusPedido,
            int idFornecedor) {
        this.idPedidoCompra = idPedidoCompra;
        this.numPedidoCompra = numPedidoCompra;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.itensPedido = itensPedido;
        this.idFornecedor = idFornecedor;
    }

    // Getters e Setters
    public int getNumPedidoCompra() {
        return numPedidoCompra;
    }
 
    public int getIdPedidoCompra() {
        return idPedidoCompra;
    }

    public void setIdPedidoCompra(int idPedidoCompra) {
        this.idPedidoCompra = idPedidoCompra;
    }

    public void setNumPedidoCompra(int numPedidoCompra) {
        this.numPedidoCompra = numPedidoCompra;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public List<ItensPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItensPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
    
}
