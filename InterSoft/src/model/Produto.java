package model;

import java.util.Scanner;

public class Produto {

    private int codProduto;
    private String descricaoProd;
    private Double precoProd;
    private String categoriaProd;
    private String embalagemProd;
    private int unitCaixa;
    private double descontoProduto; 

    Scanner teclado = new Scanner(System.in);

    public Produto() {
    }

    public Produto(int codProduto, String descricaoProd, Double precoProd, String categoriaProd, String embalagemProd, int unitCaixa, double descontoProduto) {
        this.codProduto = codProduto;
        this.descricaoProd = descricaoProd;
        this.precoProd = precoProd;
        this.categoriaProd = categoriaProd;
        this.embalagemProd = embalagemProd;
        this.unitCaixa = unitCaixa;
        this.descontoProduto = descontoProduto;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescricaoProd() {
        return descricaoProd;
    }

    public void setDescricaoProd(String descricaoProd) {
        this.descricaoProd = descricaoProd;
    }

    public Double getPrecoProd() {
        return precoProd;
    }

    public void setPrecoProd(Double precoProd) {
        this.precoProd = precoProd;
    }

    public String getCategoriaProd() {
        return categoriaProd;
    }

    public void setCategoriaProd(String categoriaProd) {
        this.categoriaProd = categoriaProd;
    }

    public String getEmbalagemProd() {
        return embalagemProd;
    }

    public void setEmbalagemProd(String embalagemProd) {
        this.embalagemProd = embalagemProd;
    }

    public int getUnitCaixa() {
        return unitCaixa;
    }

    public void setUnitCaixa(int unitCaixa) {
        this.unitCaixa = unitCaixa;
    }
    

    public double getDescontoProduto() {
        return descontoProduto;
    }

    public void setDescontoProduto(double descontoProduto) {
        this.descontoProduto = descontoProduto;
    }

    public void cadastrar() {
        // tratar campo id, pois o mesmo será do tipo identity
        System.out.printf("Informe o ID: ");
        codProduto = teclado.nextInt();
        teclado.nextLine();

        System.out.printf("Descrição do produto: ");
        descricaoProd = teclado.nextLine();
        System.out.printf("Informe o preço unitário: ");
        precoProd = teclado.nextDouble();
        teclado.nextLine(); // Consumir nova linha

        System.out.printf("Categoria produto: ");
        categoriaProd = teclado.nextLine();

        System.out.printf("Embalagem: [Exemplo 200ml/ 500gr]: ");
        embalagemProd = teclado.nextLine();

        System.out.printf("Informe a quantidade master [unidade por caixa]: ");
        unitCaixa = teclado.nextInt();
    }

    @Override
    public String toString() {
        return "Produto: " + getDescricaoProd();
    }
}
