package br.ufpb.dcx.comerciotech;


public class Compra extends Carrinho {

    public int numeroDoPedido = 0;
    private double valorTotalDaCompra;

    public Compra() {
        this.numeroDoPedido += 1;
    }

    public void processarCompra(Estoque estoque, Carrinho carrinho) {
        for (Produto produto : estoque.getProdutosNoEstoque().values()) {
            int quantidadeNoCarrinho = carrinho.contarOcorrenciasNoCarrinho(produto);
            produto.atualizarQuantidade(-quantidadeNoCarrinho);
            estoque.atualizarNivelDoEstoque(-quantidadeNoCarrinho);
        }
        carrinho.limparCarrinho();
    }

    public double getValorTotalDaCompra() {
        return calculaTotal();
    }

    public String toString() {
        return "Valor total da transação " + getValorTotalDaCompra();
    }
}