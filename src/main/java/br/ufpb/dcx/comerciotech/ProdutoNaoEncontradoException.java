package br.ufpb.dcx.comerciotech;

public class ProdutoNaoEncontradoException extends Exception {
    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
