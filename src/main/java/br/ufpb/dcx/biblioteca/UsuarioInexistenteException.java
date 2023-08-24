package br.ufpb.dcx.biblioteca;

public class UsuarioInexistenteException extends Exception {

    public UsuarioInexistenteException(String mensagem) {
        super(mensagem);
    }

}
