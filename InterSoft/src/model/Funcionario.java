package model;

import java.util.Scanner;

public class Funcionario {

    private int idFunconario;
    private String nomeFuncionario;
    private String cpfFuncionario;
    private String cargo;
    private String telefoneFunc;

    Scanner teclado = new Scanner(System.in);
   
    public Funcionario() {
    }

    public Funcionario(int codFunconario, String nomeFuncionario, String cpfFuncionario, String cargo,
        String telefoneFunc) {
        this.idFunconario = codFunconario;
        this.nomeFuncionario = nomeFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.cargo = cargo;
        this.telefoneFunc = telefoneFunc;
    }

    public int getCodFunconario() {
        return idFunconario;
    }

    public void setCodFunconario(int codFunconario) {
        this.idFunconario = codFunconario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefoneFunc() {
        return telefoneFunc;
    }

    public void setTelefoneFunc(String telefoneFunc) {
        this.telefoneFunc = telefoneFunc;
    }  
    
    public void cadastrar()
    {
      //tratar campo id, pois o mesmo será do tipo identity
      System.out.printf("Informe o ID: ");
      idFunconario = teclado.nextInt();
      teclado.nextLine();

      System.out.printf("Nome do Funcionário: ");
      nomeFuncionario = teclado.nextLine();
      
      System.out.printf("Informe CPF: ");
      cpfFuncionario = teclado.nextLine();  

      System.out.printf("Cargo/ função: ");
      cargo = teclado.nextLine();

      System.out.printf("Telefone do funcionário: ");
      telefoneFunc = teclado.nextLine();
    }    

    @Override
    public String toString() {
      return "Funcionário: " + getNomeFuncionario();
    }

}
