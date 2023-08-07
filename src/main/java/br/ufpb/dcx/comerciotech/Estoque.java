package br.ufpb.dcx.comerciotech;

import java.util.LinkedList;
import java.util.List;

public class Estoque implements EstoqueInterface {

    private List<Produto> produtos;
    private int capacidadeMaxima;
    private int nivelAtual;

    public Estoque() {
        this.produtos = new LinkedList<>();
        this.capacidadeMaxima = 10000;
        this.nivelAtual = 0;
    }

    public int getNivelAtual() {
        return this.nivelAtual;
    }

    public void setNivelAtual(int quantidadeNoEstoqueDeUmProduto) {
        this.nivelAtual += quantidadeNoEstoqueDeUmProduto;
    }

    @Override
    public void adicionarProduto(Produto produto) throws ProdutoJaCadastradoException {
        if (this.produtos.contains(produto)) {
            throw new ProdutoJaCadastradoException("Produto de ID " + produto.getIdProduto() + " já cadastrado");
        }
        this.produtos.add(produto);
    }

    @Override
    public void removerProduto(Produto produto) throws ProdutoNaoEncontradoException {
        if (!this.produtos.contains(produto)) {
            throw new ProdutoNaoEncontradoException("Produto de ID " + produto.getIdProduto() + " não encontrado");
        }
        this.produtos.remove(produto);
    }

    @Override
    public boolean verificarDisponibilidade(Produto produto, int pedidos) throws ProdutoNaoEncontradoException {
        if (!this.produtos.contains(produto)) {
            throw new ProdutoNaoEncontradoException("Produto de ID " + produto.getIdProduto() + " não encontrado");
        }
        return produto.getQntNoEstoque() >= pedidos;
    }

}
