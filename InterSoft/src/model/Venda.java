package model;

import java.util.List;

public class Venda {

    private int idVenda; 
    private List<ItemVenda> itensVenda;
    
    
    public Venda(int idVenda, List<ItemVenda> itensVenda) {
        this.idVenda = idVenda;
        this.itensVenda = itensVenda;
    }


    public int getIdVenda() {
        return idVenda;
    }


    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }


    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }


    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    
    

}
