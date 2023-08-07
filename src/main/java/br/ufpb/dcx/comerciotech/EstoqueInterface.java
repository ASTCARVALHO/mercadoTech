package br.ufpb.dcx.comerciotech;

public interface EstoqueInterface {

    public void adicionarProduto(Produto produto) throws ProdutoJaCadastradoException;
    public void removerProduto(Produto produto) throws ProdutoNaoEncontradoException;
    public boolean verificarDisponibilidade(Produto produto, int pedidos) throws ProdutoNaoEncontradoException;

}
