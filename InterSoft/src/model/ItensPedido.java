package model;

public class ItensPedido {
    
    private int numTransCompra;
    private int quantidadeCompra;
    
    public ItensPedido(int numTransCompra, int quantidadeCompra) {
        this.numTransCompra = numTransCompra;
        this.quantidadeCompra = quantidadeCompra;
    }

    public int getNumTransCompra() {
        return numTransCompra;
    }

    public void setNumTransCompra(int numTransCompra) {
        this.numTransCompra = numTransCompra;
    }

    public int getQuantidadeCompra() {
        return quantidadeCompra;
    }

    public void setQuantidadeCompra(int quantidadeCompra) {
        this.quantidadeCompra = quantidadeCompra;
    } 
    
    
}
