package br.ufpb.dcx.biblioteca;

public class UsuarioJaExisteException extends Exception {

    public UsuarioJaExisteException(String mensagem) {
        super(mensagem);
    }

}
