package view;

import static java.util.Comparator.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import model.Cliente;
import model.Fornecedor;
import model.Funcionario;
import model.Produto;


public class Controlador {

    public void executor() {

        Scanner teclado = new Scanner(System.in);
        
        ControladorUs control = new ControladorUs();

        control.iniciar(); 
        

        //Variáveis final do MENU
        final int CADASTRO_CLIENTE = 1;
        final int CADASTRO_FUNCIONARIO = 2;
        final int CADASTRO_FORNECEDOR = 3;
        final int CADASTRO_PRODUTO = 4;        
        final int SAIR = 9;

        int escolha;

        do {
            System.out.println("\n");
            System.out.println("#----- SELEÇÃO DE CADASTROS -----#");
            System.out.println("1 - [CLIENTE]");
            System.out.println("2 - [FUNCIONÁRIO]");            
            System.out.println("3 - [FORNECEDOR]");
            System.out.println("4 - [PRODUTO]");
            System.out.println("9 - Sair");

            System.out.print("\nDigite aqui a sua opção: ");

            escolha = teclado.nextInt();
            teclado.nextLine();

            //Instanciação dos objetos de classes 
            Cliente cliente = new Cliente(0, null, null);
            Fornecedor forn = new Fornecedor(0, null, null, null,null, null, null);
            Produto prod = new Produto(0, null, null, null, null, 0, 0);            
            Funcionario func = new Funcionario(0, null, null, null, null);
            
            //Objetos criados para armazenar as informações que vão para o título à Receber que está sendo criado no momento
            Cliente ultimoCliente = new Cliente();            
            
            switch (escolha) {

                case CADASTRO_CLIENTE:

                    cliente = new Cliente();
                    cliente.cadastrar();                    
                    System.out.println(cliente+" Cadastrado com sucesso! ");

                    break;

                case CADASTRO_FUNCIONARIO:

                    func = new Funcionario();
                    func.cadastrar();                    
                    System.out.println(func+" Cadastrado com sucesso! ");

                    break;                               

                case CADASTRO_FORNECEDOR:

                    forn = new Fornecedor();
                    forn.cadastrar();                    
                    System.out.println(forn+" Cadastrado com sucesso! ");

                    break;

                case CADASTRO_PRODUTO:

                    prod = new Produto();  
                    prod.cadastrar(); 
                    System.out.println(prod+" Cadastrado com sucesso! ");

                    break;              

                case SAIR:
                
                    System.out.println("\nSair ...\n");
                
                    break;

                    default:
                        System.out.println("\nOpção inválida !  Tente novamente ...\n");
            }

        } while (escolha != SAIR);

    }
}
