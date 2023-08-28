package br.ufpb.dcx.sistemacomercial;

public class ClienteNaoExisteException extends Exception {

    public ClienteNaoExisteException(String mensagem) {
        super(mensagem);
    }

}
