package br.ufpb.dcx.comerciotech;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Comparable<Produto>, Serializable {

    private final String nomeProduto;
    private final String idProduto;
    private final String fabricante;
    private final TipoProduto tipoProduto;
    private double preco;
    private int qntNoEstoque;

    public Produto(String nomeProduto, String idProduto, String fabricante,
                   TipoProduto tipoProduto, double preco, int qntNoEstoque)
    {
        this.nomeProduto = nomeProduto;
        this.idProduto = idProduto;
        this.fabricante = fabricante;
        this.tipoProduto = tipoProduto;
        this.preco = preco;
        this.qntNoEstoque = qntNoEstoque;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQntNoEstoque() {
        return qntNoEstoque;
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

    public String toString() {
        return  nomeProduto + "\n"
                + "ID: " + idProduto + "\n"
                + "Fabricante: " + fabricante + "\n"
                + "Categoria: " + tipoProduto + "\n"
                + "Valor: R$ " + preco + "\n"
                + "Quantidade no estoque: " + qntNoEstoque;
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