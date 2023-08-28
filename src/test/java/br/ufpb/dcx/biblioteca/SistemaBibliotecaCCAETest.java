package br.ufpb.dcx.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaBibliotecaCCAETest {

    SistemaBibliotecaCCAE sistema;
    Livro livro;
    List<String> autores;
    Map<String, Livro> livros;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaBibliotecaCCAE();
        autores = new LinkedList<>();
        autores.add("Nicolau Maquiavel");
        livro = new Livro("12345", "O Príncipe", autores);
        livros = sistema.getTodosOsLivros();
    }

    @Test
    public void testCadastrarLivroComSucesso() throws LivroJaExisteException {
        assertFalse(livros.containsKey(livro.getId()));
        sistema.cadastrarLivro(livro.getId(), livro.getTitulo(), autores);
        livros = sistema.getTodosOsLivros();
        assertTrue(livros.containsKey(livro.getId()));
        assertEquals("12345", livro.getId());
        assertEquals("O Príncipe", livro.getTitulo());
        assertEquals(autores, livro.getAutores());
    }

    @Test
    public void testCadastrarLivroRepetido() throws LivroJaExisteException {
        assertFalse(livros.containsKey(livro.getId()));
        sistema.cadastrarLivro(livro.getId(), livro.getTitulo(), autores);
        livros = sistema.getTodosOsLivros();
        assertTrue(livros.containsKey(livro.getId()));
        assertEquals("12345", livro.getId());
        assertEquals("O Príncipe", livro.getTitulo());
        assertEquals(autores, livro.getAutores());
        assertThrows(LivroJaExisteException.class,
                () -> sistema.cadastrarLivro(livro.getId(), livro.getTitulo(), autores));
    }

}
