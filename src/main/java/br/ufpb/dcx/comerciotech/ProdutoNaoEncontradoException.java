package br.ufpb.dcx.comerciotech;

public class ProdutoNaoEncontradoException extends Exception {
    public ProdutoNaoEncontradoException(String id) {
        super("Produto de " + id + " não encontrado.");
    }
}
