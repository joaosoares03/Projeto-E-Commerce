public class GerenciadorUsuario {
    private IdentificadorUsuario identificador;

    public GerenciadorUsuario() {
        this.identificador = new IdentificadorUsuario();
    }

    public void adicionarUsuario(Usuario usuario) {
        identificador.adicionarUsuario(usuario);
    }

    public void ativarUsuario(int id) {
        Usuario usuario = identificador.identificarPorId(id);
        if (usuario != null) {
            usuario.ativar();
            System.out.println("Usuário " + usuario.getNome() + " ativado.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void desativarUsuario(int id) {
        Usuario usuario = identificador.identificarPorId(id);
        if (usuario != null) {
            usuario.desativar();
            System.out.println("Usuário " + usuario.getNome() + " desativado.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void exibirUsuarios() {
        for (Usuario usuario : identificador.getUsuarios()) {
            System.out.println(usuario);
        }
    }

    public static void main(String[] args) {
        GerenciadorUsuario gerenciador = new GerenciadorUsuario();


        gerenciador.adicionarUsuario(new Usuario(1, "Alice", "alice@example.com"));
        gerenciador.adicionarUsuario(new Usuario(2, "Bob", "bob@example.com"));


        System.out.println("Usuários antes da ativação/desativação:");
        gerenciador.exibirUsuarios();


        gerenciador.desativarUsuario(1);
        gerenciador.ativarUsuario(1);


        System.out.println("Usuários após a ativação/desativação:");
        gerenciador.exibirUsuarios();
    }
}
