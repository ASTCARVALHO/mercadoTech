package br.ufpb.dcx.biblioteca;

public class LivroJaExisteException extends Exception {

    public LivroJaExisteException(String mensagem) {
        super(mensagem);
    }

}
