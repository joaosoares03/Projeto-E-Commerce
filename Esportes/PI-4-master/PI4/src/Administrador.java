import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private List<Usuario> usuarios = new ArrayList<>();
    private int proximoId = 1;

    public void cadastrarUsuario(String nome, String email) {
        Usuario novoUsuario = new Usuario(proximoId++, nome, email);
        usuarios.add(novoUsuario);
        System.out.println("Usuário cadastrado: " + novoUsuario);
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario u : usuarios) {
                System.out.println(u);
            }
        }
    }

    public void alterarUsuario(int id, String novoNome, String novoEmail) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                u.setNome(novoNome);
                u.setEmail(novoEmail);
                System.out.println("Usuário atualizado: " + u);
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }
}