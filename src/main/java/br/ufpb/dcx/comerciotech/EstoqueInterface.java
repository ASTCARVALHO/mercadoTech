package br.ufpb.dcx.comerciotech;

import java.io.Serializable;

public interface EstoqueInterface extends Serializable {
    void adicionarProduto(String id, Produto produto, int quantidade) throws ProdutoJaCadastradoException, EstoqueCheioException;
    void removerProduto(String id) throws ProdutoNaoEncontradoException;
    double consultarPrecoDoProduto(String id) throws ProdutoNaoEncontradoException;
    boolean verificarDisponibilidade(String id, int quantidade) throws ProdutoNaoEncontradoException;
  /*  void gerarRelatorio(String nomeDoArquivo);*/

}
