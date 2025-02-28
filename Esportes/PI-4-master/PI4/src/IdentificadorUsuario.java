import java.util.ArrayList;
import java.util.List;

public class IdentificadorUsuario {
    private List<Usuario> usuarios;

    public IdentificadorUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario identificarPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario identificarPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}