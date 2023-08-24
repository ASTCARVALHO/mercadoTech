package br.ufpb.dcx.biblioteca;

import java.util.LinkedList;
import java.util.List;

public class Livro {

    private String id;
    private String titulo;
    private List<String> autores;
    private boolean estahEmprestado;

    public Livro(String id, String titulo, List<String> autores) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
    }

    public boolean isEstahEmprestado() {
        return this.estahEmprestado;
    }

    public void setEstahEmprestado(boolean estahEmprestado) {
        this.estahEmprestado = estahEmprestado;
    }

    public String getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public List<String> getAutores() {
        return this.autores;
    }

}
