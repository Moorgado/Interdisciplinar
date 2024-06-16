package model;

public class ItemVenda {
    
    private int numTransVenda;
    private int quantVenda;

    public ItemVenda(int numTransVenda, int quantVenda) {
        this.numTransVenda = numTransVenda;
        this.quantVenda = quantVenda;
    }

    public int getNumTransVenda() {
        return numTransVenda;
    }

    public void setNumTransVenda(int numTransVenda) {
        this.numTransVenda = numTransVenda;
    }

    public int getQuantVenda() {
        return quantVenda;
    }

    public void setQuantVenda(int quantVenda) {
        this.quantVenda = quantVenda;
    } 

    

}
