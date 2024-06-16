package model;

import java.util.Scanner;

public class Fornecedor {  

    private int codFornecedor;
    private String razaoSocial;
    private String cpfCNPJ;
    private String nomeFantasia;
    private String tipoPessoa;
    private String emailForn;
    private String telefoneForn;
    
    Scanner teclado = new Scanner(System.in);
    
    public Fornecedor() {  
        }

    public Fornecedor(int codFornecedor, String razaoSocial, String cpfCNPJ, String nomeFantasia, String tipoPessoa,
            String emailForn, String telefoneForn) {
        this.codFornecedor = codFornecedor;
        this.razaoSocial = razaoSocial;
        this.cpfCNPJ = cpfCNPJ;
        this.nomeFantasia = nomeFantasia;
        this.tipoPessoa = tipoPessoa;
        this.emailForn = emailForn;
        this.telefoneForn = telefoneForn;
    }

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCpfCNPJ() {
        return cpfCNPJ;
    }

    public void setCpfCNPJ(String cpfCNPJ) {
        this.cpfCNPJ = cpfCNPJ;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getEmailForn() {
        return emailForn;
    }

    public void setEmailForn(String emailForn) {
        this.emailForn = emailForn;
    }

    public String getTelefoneForn() {
        return telefoneForn;
    }

    public void setTelefoneForn(String telefoneForn) {
        this.telefoneForn = telefoneForn;
    }

    public void cadastrar()
    {
        //ajustar primeiro sout
      System.out.printf("Informe o ID: ");
      codFornecedor = teclado.nextInt();
      teclado.nextLine();
      
      System.out.printf("Informe a razão social: ");
      razaoSocial = teclado.nextLine();
      
      System.out.printf("Digite CPF ou CNPJ: ");
      cpfCNPJ = teclado.nextLine();

      System.out.printf("Digite o nome Fantasia, caso possua: ");
      nomeFantasia = teclado.nextLine();

      System.out.printf("[J] para Pessoa júridica // [F] para Pessoa Física: ");
      tipoPessoa = teclado.next();

      System.out.printf("E-mail fornecedor: ");
      emailForn = teclado.nextLine();
      
      System.out.printf("Telefone fornecedor");
      telefoneForn = teclado.nextLine();
    }
  
    @Override
    public String toString() {
      return "Fornecedor: " + getRazaoSocial();
    }
  
}



    

