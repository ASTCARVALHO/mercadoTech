package br.ufpb.dcx.sistemacomercial;

public class Produto {

    private String codigo;
    private String descricao;
    private double precoVenda;
    private int quantidadeEmEstoque;
    private CategoriaProduto categoria;

    public Produto(
            String codigo, String descricao,
            double precoVenda, int quantidadeEmEstoque,
            CategoriaProduto categoria) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.categoria = categoria;
    }

    public Produto() {
        this("", "", 0.0, -1, null);
    }

    @Override
    public String toString() {
        return "Produto {" + '\n' +
                "Código do produto: " + this.codigo + '\n' +
                "Descrição do produto: " + this.descricao + '\n' +
                "Preço de venda: R$ " + this.precoVenda + '\n' +
                "Quantidade em estoque: " + this.quantidadeEmEstoque + '\n' +
                "Categoria: " + this.categoria +
                " }";
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoVenda() {
        return this.precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidadeEmEstoque() {
        return this.quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public CategoriaProduto getCategoria() {
        return this.categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }


}
