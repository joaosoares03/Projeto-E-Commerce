public class AlteradorSenha {
    private IdentificadorUsuario identificador;

    public AlteradorSenha(IdentificadorUsuario identificador) {
        this.identificador = identificador;
    }

    public void alterarSenha(int id, String novaSenha) {
        Usuario usuario = identificador.identificarPorId(id);
        if (usuario != null) {
            usuario.setSenha(novaSenha);
            System.out.println("Senha do usuário " + usuario.getNome() + " alterada com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}
