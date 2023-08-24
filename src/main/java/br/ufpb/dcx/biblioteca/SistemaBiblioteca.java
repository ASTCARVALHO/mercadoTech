package br.ufpb.dcx.biblioteca;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collection;

public interface SistemaBiblioteca {

     boolean pegarLivro(String matriculaUsuario, String idLivro)
            throws UsuarioInexistenteException, LivroInexistenteException;

     boolean devolverLivro(String matriculaUsuario, String idLivro)
             throws UsuarioInexistenteException, LivroInexistenteException;

     boolean cadastrarUsuario(String matricula, String nome, TipoUsuario tipo)
         throws UsuarioJaExisteException;

     void cadastrarLivro(String id, String titulo, List<String> autores)
             throws LivroJaExisteException;

     Map<String, Livro> getTodosOsLivros();

     Collection<Usuario> getUsuarios();

     Collection<Livro> getLivrosEmprestadosA(String matriculaUsuario);

}
