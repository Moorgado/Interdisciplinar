package model;

import java.util.Scanner;

public class Cliente {  

    private int codCliente;
    private String telefoneCliente;
    private String nomeCliente;
    private String cpfCliente; 
    private String dividaCli;
    private String valorDivida;

    Scanner teclado = new Scanner(System.in);

    public Cliente() {
    }

    public Cliente(int codCliente, String telefoneCliente, String nomeCliente) {
        this.codCliente = codCliente;
        this.telefoneCliente = telefoneCliente;
        this.nomeCliente = nomeCliente;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getDividaCli() {
        return dividaCli;
    }

    public void setDividaCli(String dividaCli) {
        this.dividaCli = dividaCli;
    }

    public String getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(String valorDivida) {
        this.valorDivida = valorDivida;
    }

    public void cadastrar()
    {
        //tratar campo id, pois o mesmo será do tipo identity
      System.out.printf("Informe o ID: ");
      codCliente = teclado.nextInt();
      teclado.nextLine();

      System.out.printf("Informe o nome do cliente: ");
      nomeCliente = teclado.nextLine();
      
      System.out.printf("Contato do cliente: ");
      telefoneCliente = teclado.nextLine();  
    }
  
    @Override
    public String toString() {
      return "Cliente: " + getNomeCliente();
    }

}
