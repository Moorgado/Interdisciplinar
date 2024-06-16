package model;

public class Estoque {
    
    private int idProduto;
    private int quantProduto;


    public Estoque(int quantProduto) {
        this.quantProduto = quantProduto;
    }

    public Estoque(int int1, int int2) {
        //TODO Auto-generated constructor stub
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantProduto() {
        return quantProduto;
    }

    public void setQuantProduto(int quantProduto) {
        this.quantProduto = quantProduto;
    } 


    
}
