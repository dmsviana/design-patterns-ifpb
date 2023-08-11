package br.edu.ifpb.ads.view;

import java.util.List;
import java.util.Scanner;

import br.edu.ifpb.ads.controller.ProdutoController;
import br.edu.ifpb.ads.controller.UsuarioController;
import br.edu.ifpb.ads.dao.ProdutoDAO;
import br.edu.ifpb.ads.dao.ProdutoDAOImpl;
import br.edu.ifpb.ads.dao.UsuarioDAO;
import br.edu.ifpb.ads.dao.UsuarioDAOImpl;
import br.edu.ifpb.ads.dto.ProdutoDTO;
import br.edu.ifpb.ads.dto.UsuarioDTO;

public class ConsoleGUI {
	 

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	
        ProdutoDAO produtoDAO = new ProdutoDAOImpl();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

        ProdutoController produtoController = new ProdutoController(produtoDAO);
        UsuarioController usuarioController = new UsuarioController(usuarioDAO);

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("4. Buscar Produto por Nome");
            System.out.println("5. Listar Produtos");
            System.out.println("6. Adicionar Usuário");
            System.out.println("7. Atualizar Usuário");
            System.out.println("8. Remover Usuário");
            System.out.println("9. Buscar Usuário por Email");
            System.out.println("10. Listar Usuários");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
            case 1:
                System.out.println("Digite o nome do produto:");
                String nomeProduto = scanner.nextLine();
                System.out.println("Digite a descrição do produto:");
                String descricaoProduto = scanner.nextLine();
                System.out.println("Digite o preço do produto:");
                double precoProduto = scanner.nextDouble();
                
                ProdutoDTO novoProduto = new ProdutoDTO(nomeProduto, descricaoProduto, precoProduto);
                produtoController.adicionarProduto(novoProduto);
                System.out.println("Produto adicionado com sucesso!");
                break;

            case 2:
                System.out.println("Digite o nome do produto a ser atualizado:");
                String nomeProdutoAtualizar = scanner.nextLine();
                System.out.println("Novo nome: ");
                String novoNomeProduto = scanner.nextLine();
                System.out.println("Novo descricao: ");
                String novaDescricao = scanner.nextLine();
                System.out.println("Novo preço: ");
                double novoPreco = scanner.nextDouble();
                
                ProdutoDTO produtoAtualizado = new ProdutoDTO(novoNomeProduto, novaDescricao, novoPreco);
                produtoController.atualizarProduto(nomeProdutoAtualizar, produtoAtualizado);
                System.out.println("Produto atualizado com sucesso!");
                break;

            case 3:
                System.out.println("Digite o nome do produto a ser removido:");
                String nomeProdutoRemover = scanner.nextLine();
                produtoController.removerProduto(nomeProdutoRemover);
                System.out.println("Produto removido com sucesso!");
                break;

            case 4:
                System.out.println("Digite o nome do produto a ser buscado:");
                String nomeProdutoBuscar = scanner.nextLine();
                ProdutoDTO produtoEncontrado = produtoController.buscarProdutoPorNome(nomeProdutoBuscar);
                if (produtoEncontrado != null) {
                    System.out.println("Produto encontrado:");
                    System.out.println("Nome: " + produtoEncontrado.getNome());
                    System.out.println("Descrição: " + produtoEncontrado.getDescricao());
                    System.out.println("Preço: " + produtoEncontrado.getPreco());
                } else {
                    System.out.println("Produto não encontrado.");
                }
                break;

            case 5:
                List<ProdutoDTO> listaProdutos = produtoController.listarProdutos();
                System.out.println("Lista de Produtos:");
                for (ProdutoDTO produto : listaProdutos) {
                    System.out.println("Nome: " + produto.getNome());
                    System.out.println("Descrição: " + produto.getDescricao());
                    System.out.println("Preço: " + produto.getPreco());
                    System.out.println("------------------------");
                }
                break;

            case 6:
                System.out.println("Digite o nome do usuário:");
                String nomeUsuario = scanner.nextLine();
                System.out.println("Digite o email do usuário:");
                String emailUsuario = scanner.nextLine();
                System.out.println("Digite o telefone do usuário:");
                String telefoneUsuario = scanner.nextLine();
                
                UsuarioDTO novoUsuario = new UsuarioDTO(nomeUsuario, emailUsuario, telefoneUsuario);
                usuarioController.adicionarUsuario(novoUsuario);
                System.out.println("Usuário adicionado com sucesso!");
                break;

            case 7:
                System.out.println("Digite o email do usuário a ser atualizado:");
                String emailUsuarioAtualizar = scanner.nextLine();

                System.out.println("Digite o novo nome do usuário:");
                String novoNomeUsuario = scanner.nextLine();
                System.out.println("Digite o novo email do usuário:");
                String novoEmail = scanner.nextLine();
                System.out.println("Digite o novo telefone do usuário:");
                String novoTelefone = scanner.nextLine();
                
                
                UsuarioDTO usuarioAtualizado = new UsuarioDTO(novoNomeUsuario, novoEmail, novoTelefone);
                usuarioController.atualizarUsuario(emailUsuarioAtualizar, usuarioAtualizado);
                System.out.println("Usuário atualizado com sucesso!");
                break;

            case 8:
                System.out.println("Digite o email do usuário a ser removido:");
                String emailUsuarioRemover = scanner.nextLine();
                usuarioController.removerUsuario(emailUsuarioRemover);
                System.out.println("Usuário removido com sucesso!");
                break;

            case 9:
                System.out.println("Digite o email do usuário a ser buscado:");
                String emailUsuarioBuscar = scanner.nextLine();
                UsuarioDTO usuarioEncontrado = usuarioController.buscarUsuarioPorEmail(emailUsuarioBuscar);
                if (usuarioEncontrado != null) {
                    System.out.println("Usuário encontrado:");
                    System.out.println("Nome: " + usuarioEncontrado.getNome());
                    System.out.println("Email: " + usuarioEncontrado.getEmail());
                    System.out.println("Telefone: " + usuarioEncontrado.getTelefone());
                } else {
                    System.out.println("Usuário não encontrado.");
                }
                break;

            case 10:
                List<UsuarioDTO> listaUsuarios = usuarioController.listarUsuarios();
                System.out.println("Lista de Usuários:");
                for (UsuarioDTO usuario : listaUsuarios) {
                    System.out.println("Nome: " + usuario.getNome());
                    System.out.println("Email: " + usuario.getEmail());
                    System.out.println("Telefone: " + usuario.getTelefone());
                    System.out.println("------------------------");
                }
                break;

            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
        } while (opcao != 0);
    }
}