package br.ufpb.dcx.biblioteca;

import java.util.*;

public class SistemaBibliotecaCCAE implements SistemaBiblioteca {

    private Map<String, Livro> livros = new HashMap<String, Livro>();
    private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();

    public boolean pegarLivro(String matriculaUsuario, String idLivro)
            throws UsuarioInexistenteException, LivroInexistenteException {
        if (!this.usuarios.containsKey(matriculaUsuario))
            throw new UsuarioInexistenteException("Usuário de matrícula " + matriculaUsuario + " não encontrado.");

        if (!this.livros.containsKey(idLivro))
            throw new LivroInexistenteException("Livro de ID " + idLivro + " não encontrado.");

        Livro livro = this.livros.get(matriculaUsuario);
        Usuario usuario = this.usuarios.get(idLivro);

        if (livro.isEstahEmprestado()) return false;

        usuario.adicionarEmprestimoDeLivro(livro);
        livro.setEstahEmprestado(true);

        return true;
    }

    public boolean devolverLivro(String matriculaUsuario, String idLivro)
            throws UsuarioInexistenteException, LivroInexistenteException {
        if (!this.usuarios.containsKey(matriculaUsuario))
            throw new UsuarioInexistenteException("Usuário de matrícula " + matriculaUsuario + " não encontrado.");

        if (!this.livros.containsKey(idLivro))
            throw new LivroInexistenteException("Livro de ID " + idLivro + " não encontrado.");

        Livro livro = this.livros.get(matriculaUsuario);
        Usuario usuario = this.usuarios.get(idLivro);

        if (!livro.isEstahEmprestado()) return false;

        if (usuario.removerEmprestimoDeLivro(livro)) {
            livro.setEstahEmprestado(false);
        }

        return true;
    }

    public boolean cadastrarUsuario(String matricula, String nome, TipoUsuario tipo)
            throws UsuarioJaExisteException {
        if (this.usuarios.containsKey(matricula))
            throw new UsuarioJaExisteException("Usuário de matrícula " + matricula + " já está cadastrado.");

        Usuario usuario = new Usuario(matricula, nome, tipo);
        try {
            this.usuarios.put(matricula, usuario);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void cadastrarLivro(String id, String titulo, List<String> autores) throws LivroJaExisteException {
        if (this.livros.containsKey(id))
            throw new LivroJaExisteException("Livro de ID " + id + " já cadastrado.");

        Livro livro = new Livro(id, titulo, autores);
        this.livros.put(id, livro);
    }

    public Map<String, Livro> getTodosOsLivros() {
        return this.livros;
    }

    public Collection<Usuario> getUsuarios() {
        return new LinkedList<>(this.usuarios.values());
    }

    public Collection<Livro> getLivrosEmprestadosA(String matriculaUsuario) {
        Usuario usuario = this.usuarios.get(matriculaUsuario);
        return usuario.getLivrosEmprestados();
    }

}
