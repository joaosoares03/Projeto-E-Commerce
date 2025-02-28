import java.util.Scanner;

public class UsuarioController {
    private UsuarioService usuarioService = new UsuarioService();
    private Scanner scanner = new Scanner(System.in);


    private void ativarUsuario() {
        System.out.print("ID do usuário para ativar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (usuarioService.ativarUsuario(id)) {
            System.out.println("Usuário ativado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private void desativarUsuario() {
        System.out.print("ID do usuário para desativar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (usuarioService.desativarUsuario(id)) {
            System.out.println("Usuário desativado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private void alterarSenha() {
        System.out.print("ID do usuário para alterar a senha: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nova senha: ");
        String novaSenha = scanner.nextLine();

        if (usuarioService.alterarSenha(id, novaSenha)) {
            System.out.println("Senha alterada com sucesso!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }


    public void iniciar() {
        while (true) {
            System.out.println("\n1. Cadastrar Usuário");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Alterar Usuário");
            System.out.println("4. Ativar Usuário");
            System.out.println("5. Desativar Usuário");
            System.out.println("6. Alterar Senha");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    alterarUsuario();
                    break;
                case 4:
                    ativarUsuario();
                    break;
                case 5:
                    desativarUsuario();
                    break;
                case 6:
                    alterarSenha();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarUsuario() {
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("CEP: ");
            String cep = scanner.nextLine();
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();

            Usuario usuario = usuarioService.cadastrarUsuario(nome, email, senha, cpf, telefone, cep, endereco);
            System.out.println("Usuário cadastrado: " + usuario);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void listarUsuarios() {
        for (Usuario u : usuarioService.listarUsuarios()) {
            System.out.println(u);
        }
    }

    private void alterarUsuario() {
        System.out.print("ID do usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo Nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo Email: ");
        String novoEmail = scanner.nextLine();
        System.out.print("Novo Telefone: ");
        String novoTelefone = scanner.nextLine();
        System.out.print("Novo CEP: ");
        String novoCep = scanner.nextLine();
        System.out.print("Novo Endereço: ");
        String novoEndereco = scanner.nextLine();

        Usuario usuario = usuarioService.alterarUsuario(id, novoNome, novoEmail, novoTelefone, novoCep, novoEndereco);
        if (usuario != null) {
            System.out.println("Usuário atualizado: " + usuario);
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}
