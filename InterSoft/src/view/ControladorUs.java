package view;

import data.*;
import model.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ControladorUs {

    private UsuarioDAO usuarioDAO;
    private FuncionarioDAO funcionarioDAO;
    private ClienteDAO clienteDAO;
    private FornecedorDAO fornecedorDAO;
    private pdvDAO pdvDAO;
    private ProdutoDAO produtoDAO;
    private EstoqueDAO estoqueDAO;
    private PedidoCompraDAO pedidoCompraDAO;

    private Scanner scanner;

    public ControladorUs() {
        usuarioDAO = new UsuarioDAO();
        funcionarioDAO = new FuncionarioDAO();
        clienteDAO = new ClienteDAO();
        fornecedorDAO = new FornecedorDAO();
        pdvDAO = new pdvDAO();
        produtoDAO = new ProdutoDAO();
        estoqueDAO = new EstoqueDAO();
        pedidoCompraDAO = new PedidoCompraDAO();

        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    gerenciarUsuarios();
                    break;
                case 2:
                    gerenciarFuncionarios();
                    break;
                case 3:
                    gerenciarClientes();
                    break;
                case 4:
                    gerenciarFornecedores();
                    break;
                case 5:
                    gerenciarProdutos();
                    break;
                case 6:
                    gerenciarEstoque();
                    break;
                case 7:
                    registrarVenda();
                    break;
                case 8:
                    registrarCompra();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("\nMenu Principal");
        System.out.println("1. Gerenciar Usuários");
        System.out.println("2. Gerenciar Funcionários");
        System.out.println("3. Gerenciar Clientes");
        System.out.println("4. Gerenciar Fornecedores");
        System.out.println("5. Gerenciar Produtos");
        System.out.println("6. Gerenciar Estoque");
        System.out.println("7. Registrar Venda");
        System.out.println("8. Registrar Compra");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void gerenciarUsuarios() {
        // Implementar operações CRUD para Funcionários
        System.out.println("Gerenciamento de Usuários não implementado.");
    }

    private void gerenciarFuncionarios() {
        // Implementar operações CRUD para Funcionários
        System.out.println("Gerenciamento de Funcionários não implementado.");
    }

    private void gerenciarClientes() {
        System.out.println("\nMenu de Gerenciamento de Clientes");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Atualizar Cliente");
        System.out.println("4. Remover Cliente");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        switch (opcao) {
            case 1:
                adicionarCliente();
                break;
            case 2:
                listarClientes();
                break;
            case 3:
                atualizarCliente();
                break;
            case 4:
                removerCliente();
                break;
            case 0:
                // Voltar ao menu principal
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void adicionarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Contato: ");
        String contato = scanner.nextLine();
        System.out.print("Dívida (true/false): ");
        boolean divida = scanner.nextBoolean();
        System.out.print("Valor da Dívida: ");
        double valorDivida = scanner.nextDouble();
        Cliente cliente = new Cliente();
        try {
            clienteDAO.create(cliente);
            System.out.println("Cliente adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
        }
    }

    private void listarClientes() {
        try {
            List<Cliente> clientes = clienteDAO.readAll();
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
    }

    private void atualizarCliente() {
        System.out.print("ID do Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Contato: ");
        String contato = scanner.nextLine();
        System.out.print("Dívida (true/false): ");
        boolean divida = scanner.nextBoolean();
        System.out.print("Valor da Dívida: ");
        double valorDivida = scanner.nextDouble();

        Cliente cliente = new Cliente();
        try {
            clienteDAO.update(cliente);
            System.out.println("Cliente atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    private void removerCliente() {
        System.out.print("ID do Cliente: ");
        int id = scanner.nextInt();
        try {
            clienteDAO.delete(id);
            System.out.println("Cliente removido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao remover cliente: " + e.getMessage());
        }
    }

    private void gerenciarFornecedores() {
        System.out.println("\nMenu de Gerenciamento de Fornecedores");
        System.out.println("1. Adicionar Fornecedor");
        System.out.println("2. Listar Fornecedores");
        System.out.println("3. Atualizar Fornecedor");
        System.out.println("4. Remover Fornecedor");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        switch (opcao) {
            case 1:
                adicionarFornecedor();
                break;
            case 2:
                listarFornecedores();
                break;
            case 3:
                atualizarFornecedor();
                break;
            case 4:
                removerFornecedor();
                break;
            case 0:
                // Voltar ao menu principal
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void adicionarFornecedor() {
        System.out.print("Razão Social: ");
        String razaoSocial = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Nome Fantasia: ");
        String nomeFantasia = scanner.nextLine();
        System.out.print("Tipo de Fornecedor: ");
        String tipoFornecedor = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contato: ");
        String contato = scanner.nextLine();

        Fornecedor fornecedor = new Fornecedor(0, razaoSocial, cnpj, nomeFantasia, tipoFornecedor, email, contato);
        try {
            fornecedorDAO.create(fornecedor);
            System.out.println("Fornecedor adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar fornecedor: " + e.getMessage());
        }
    }

    private void listarFornecedores() {
        try {
            List<Fornecedor> fornecedores = fornecedorDAO.readAll();
            for (Fornecedor fornecedor : fornecedores) {
                System.out.println(fornecedor);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar fornecedores: " + e.getMessage());
        }
    }

    private void atualizarFornecedor() {
        System.out.print("ID do Fornecedor: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha
        System.out.print("Razão Social: ");
        String razaoSocial = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Nome Fantasia: ");
        String nomeFantasia = scanner.nextLine();
        System.out.print("Tipo de Fornecedor: ");
        String tipoFornecedor = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contato: ");
        String contato = scanner.nextLine();

        Fornecedor fornecedor = new Fornecedor(id, razaoSocial, cnpj, nomeFantasia, tipoFornecedor, email, contato);
        try {
            fornecedorDAO.update(fornecedor);
            System.out.println("Fornecedor atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar fornecedor: " + e.getMessage());
        }
    }

    private void removerFornecedor() {
        System.out.print("ID do Fornecedor: ");
        int id = scanner.nextInt();
        try {
            fornecedorDAO.delete(id);
            System.out.println("Fornecedor removido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao remover fornecedor: " + e.getMessage());
        }
    }

    private void gerenciarProdutos() {
        System.out.println("\nMenu de Gerenciamento de Produtos");
        System.out.println("1. Adicionar Produto");
        System.out.println("2. Listar Produtos");
        System.out.println("3. Atualizar Produto");
        System.out.println("4. Remover Produto");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        switch (opcao) {
            case 1:
                adicionarProduto();
                break;
            case 2:
                listarProdutos();
                break;
            case 3:
                atualizarProduto();
                break;
            case 4:
                removerProduto();
                break;
            case 0:
                // Voltar ao menu principal
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void adicionarProduto() {
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();  // Consumir nova linha
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Embalagem: ");
        String embalagem = scanner.nextLine();
        System.out.print("Embalagem Master: ");
        int embalagemMaster = scanner.nextInt();
        System.out.print("ID Classificação Fiscal: ");
        int idClassificacaoFiscal = scanner.nextInt();

        Produto produto = new Produto();
        try {
            produtoDAO.create(produto);
            System.out.println("Produto adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar produto: " + e.getMessage());
        }
    }

    private void listarProdutos() {
        try {
            List<Produto> produtos = produtoDAO.readAll();
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
    }

    private void atualizarProduto() {
        System.out.print("ID do Produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();  // Consumir nova linha
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Embalagem: ");
        String embalagem = scanner.nextLine();
        System.out.print("Embalagem Master: ");
        int embalagemMaster = scanner.nextInt();
        System.out.print("ID Classificação Fiscal: ");
        int idClassificacaoFiscal = scanner.nextInt();

        Produto produto = new Produto();
        try {
            produtoDAO.update(produto);
            System.out.println("Produto atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    private void removerProduto() {
        System.out.print("ID do Produto: ");
        int id = scanner.nextInt();
        try {
            produtoDAO.delete(id);
            System.out.println("Produto removido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao remover produto: " + e.getMessage());
        }
    }

    private void gerenciarEstoque() {
        System.out.println("\nMenu de Gerenciamento de Estoque");
        System.out.println("1. Inserir Produto no Estoque");
        System.out.println("2. Remover Produto do Estoque");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        switch (opcao) {
            case 1:
                inserirProdutoNoEstoque();
                break;
            case 2:
                removerProdutoDoEstoque();
                break;
            case 0:
                // Voltar ao menu principal
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void inserirProdutoNoEstoque() {
        System.out.print("ID do Produto: ");
        int idProduto = scanner.nextInt();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        try {
            Estoque estoque = estoqueDAO.read(idProduto);
            if (estoque != null) {
                estoque.setQuantProduto(estoque.getQuantProduto() + quantidade);
                estoqueDAO.update(estoque);
            } else {
                estoque = new Estoque(quantidade, idProduto);
                estoqueDAO.create(estoque);
            }
            System.out.println("Produto inserido no estoque com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto no estoque: " + e.getMessage());
        }
    }

    private void removerProdutoDoEstoque() {
        System.out.print("ID do Produto: ");
        int idProduto = scanner.nextInt();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        try {
            Estoque estoque = estoqueDAO.read(idProduto);
            if (estoque != null && estoque.getQuantProduto() >= quantidade) {
                estoque.setQuantProduto(estoque.getQuantProduto() - quantidade);
                if (estoque.getQuantProduto() == 0) {
                    estoqueDAO.delete(idProduto);
                } else {
                    estoqueDAO.update(estoque);
                }
                System.out.println("Produto removido do estoque com sucesso!");
            } else {
                System.out.println("Quantidade insuficiente no estoque ou produto não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover produto do estoque: " + e.getMessage());
        }
    }

    private void registrarVenda() {
        System.out.print("ID do Cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("Número do PDV: ");
        int numPDV = scanner.nextInt();

        ItemVenda venda = new ItemVenda(numPDV, numPDV);
        // vendasDAO.create(venda);
        System.out.println("Venda registrada com sucesso!");
    }

    private void registrarCompra() {
        System.out.print("Data do Pedido (AAAA-MM-DD): ");
        String dataPedido = scanner.next();
        System.out.print("Status do Pedido: ");
        String statusPedido = scanner.next();
        System.out.print("ID do Fornecedor: ");
        int idFornecedor = scanner.nextInt();

        PedidoCompra pedidoCompra = new PedidoCompra(0, LocalDate.parse(dataPedido), statusPedido, idFornecedor);
        try {
            pedidoCompraDAO.create(pedidoCompra);
            System.out.println("Compra registrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao registrar compra: " + e.getMessage());
        }
    }

}