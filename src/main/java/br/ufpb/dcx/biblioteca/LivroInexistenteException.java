package br.ufpb.dcx.biblioteca;

public class LivroInexistenteException extends Exception {

    public LivroInexistenteException(String mensagem) {
        super(mensagem);
    }

}
