package model;
import java.util.Date;

public class Caixa {
    
    private int idCaixa;
    private double subTotal; 
    private Date dtvMovimentacao; 

    //Construtor, getters e setters;

    public Caixa (int idCaixa, double subTotal, Date dtvMovimentacao) {
        this.subTotal = subTotal;
        this.dtvMovimentacao = dtvMovimentacao;
        
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Date getDtvMovimentacao() {
        return dtvMovimentacao;
    }

    public void setDtvMovimentacao(Date dtvMovimentacao) {
        this.dtvMovimentacao = dtvMovimentacao;
    }
     
    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }
}
