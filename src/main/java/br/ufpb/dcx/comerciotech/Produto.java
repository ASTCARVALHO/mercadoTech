package br.ufpb.dcx.comerciotech;

import java.util.Objects;

public class Produto implements Comparable<Produto> {

    private String nomeProduto;
    private String idProduto;
    private String fabricante;
    private double preco;
    private int qntNoEstoque;

    public Produto(String nomeProduto, String idProduto, String fabricante, double preco, int qntNoEstoque) {
        this.nomeProduto = nomeProduto;
        this.idProduto = idProduto;
        this.fabricante = fabricante;
        this.preco = preco;
        this.qntNoEstoque = qntNoEstoque;
    }

    public String getNomeProduto() {
        return this.nomeProduto;
    }

    public String getIdProduto() {
        return this.idProduto;
    }

    public String getFabricante() {
        return this.fabricante;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQntNoEstoque() {
        return this.qntNoEstoque;
    }

    public void setQntNoEstoque(int qntNoEstoque) {
        this.qntNoEstoque = qntNoEstoque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(idProduto, produto.idProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeProduto, idProduto, fabricante, preco, qntNoEstoque);
    }

    @Override
    public int compareTo(Produto outroProduto) {
        return Double.compare(this.preco, outroProduto.getPreco());
    }

}
