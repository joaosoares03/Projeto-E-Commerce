import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();
    private int proximoId = 1;

    public Usuario cadastrarUsuario(String nome, String email, String senha, String cpf, String telefone, String cep, String endereco) {
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || cep.isEmpty() || endereco.isEmpty()) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos!");
        }
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Email inválido!");
        }
        if (cpfJaExiste(cpf)) {
            throw new IllegalArgumentException("CPF já cadastrado!");
        }

        Usuario usuario = new Usuario(proximoId++, nome, email, senha, cpf, telefone, cep, endereco);
        usuarios.add(usuario);
        return usuario;
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    public Usuario alterarUsuario(int id, String novoNome, String novoEmail, String novoTelefone, String novoCep, String novoEndereco) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                u.setNome(novoNome);
                u.setEmail(novoEmail);
                u.setTelefone(novoTelefone);
                u.setCep(novoCep);
                u.setEndereco(novoEndereco);
                return u;
            }
        }
        return null;
    }


    public boolean ativarUsuario(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                u.ativar();
                return true;
            }
        }
        return false;
    }

    public boolean desativarUsuario(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                u.desativar();
                return true;
            }
        }
        return false;
    }

    public boolean alterarSenha(int id, String novaSenha) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                u.alterarSenha(novaSenha);
                return true;
            }
        }
        return false;
    }

    private boolean cpfJaExiste(String cpf) {
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
}
