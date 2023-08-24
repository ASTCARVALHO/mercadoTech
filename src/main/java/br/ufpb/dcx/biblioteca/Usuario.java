package br.ufpb.dcx.biblioteca;

import java.util.Collection;

public class Usuario {

    private String matricula;
    private String nome;
    private TipoUsuario tipo;
    private Collection<Livro> livrosEmprestados;

    public Usuario(String matricula, String nome, TipoUsuario tipo) {
        this.matricula = matricula;
        this.nome = nome;
        this.tipo = tipo;
    }

    public void adicionarEmprestimoDeLivro(Livro livro) {
        if (!livro.isEstahEmprestado()) this.livrosEmprestados.add(livro);
    }

    public boolean removerEmprestimoDeLivro(Livro livro) {
        if (livro.isEstahEmprestado()) {
            this.livrosEmprestados.remove(livro);
            return true;
        }
        return false;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public TipoUsuario getTipo() {
        return this.tipo;
    }

    public Collection<Livro> getLivrosEmprestados() {
        return this.livrosEmprestados;
    }

}
