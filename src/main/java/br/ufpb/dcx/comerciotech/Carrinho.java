package br.ufpb.dcx.comerciotech;

import java.util.List;
import java.util.LinkedList;

public class Carrinho extends Estoque {

    private List<Produto> produtosNoCarrinho;

    public Carrinho() {
        this.produtosNoCarrinho = new LinkedList<>();
    }


    /*public void adicionarProdutoNoCarrinho(Produto produto, int quantidadeASerAdicionada) throws ProdutoNaoEncontradoException {
        if (!super.getProdutosNoEstoque().contains(produto)) {
            throw new ProdutoNaoEncontradoException("Produto de ID " + produto.getIdProduto() + " não encontrado");
        }
        for (int i = 0; i < quantidadeASerAdicionada; i++) {
            this.produtosNoCarrinho.add(produto);
        }
    }

    public void removerProdutoNoCarrinho(Produto produto, int quantidadeASerRemovida) throws ProdutoNaoEncontradoException {
        if (!super.getProdutosNoEstoque().contains(produto)) {
            throw new ProdutoNaoEncontradoException("Produto de ID " + produto.getIdProduto() + " não encontrado");
        }
        for (int i = 0; i < quantidadeASerRemovida; i++) {
            this.produtosNoCarrinho.remove(produto);
        }
    }*/

}
