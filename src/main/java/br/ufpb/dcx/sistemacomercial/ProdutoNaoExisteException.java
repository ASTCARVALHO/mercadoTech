package br.ufpb.dcx.sistemacomercial;

public class ProdutoNaoExisteException extends Exception {

    public ProdutoNaoExisteException(String mensagem) {
        super(mensagem);
    }

}
