package br.ufpb.dcx.sistemacomercial;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SistemaComercialMap implements SistemaComercial {

    private Map<String, Cliente> clientes;
    private Map<String, Produto> produtos;

    public SistemaComercialMap() {
        this.clientes = new HashMap<>();
        this.produtos = new HashMap<>();
    }

    public boolean cadastraCliente(Cliente cliente) {
        if (!existeCliente(cliente)) {
            this.clientes.put(cliente.getId(), cliente);
            return true;
        }
        return false;
    }

    public Collection<Cliente> pesquisaClientesComNomeComecandoCom(String prefixo) {
        Collection<Cliente> clientesComNomeComecandoCom = new LinkedList<>();
        for (Cliente cliente : this.clientes.values()) {
            if (cliente.getNome().startsWith(prefixo))
                clientesComNomeComecandoCom.add(cliente);
        }
        return clientesComNomeComecandoCom;
    }

    @Override
    public boolean existeProduto(Produto produto) {
        return this.produtos.containsValue(produto);
    }

    @Override
    public Produto pesquisaProduto(String codigo) throws ProdutoNaoExisteException {
        if (!this.produtos.containsKey(codigo))
            throw new ProdutoNaoExisteException("Produto com o código " + codigo + " não existe");
        return this.produtos.get(codigo);
    }

    @Override
    public boolean cadastraProduto(Produto produto) {
        if (!existeProduto(produto)) {
            this.produtos.put(produto.getCodigo(), produto);
            return true;
        }
        return false;
    }

    @Override
    public boolean existeCliente(Cliente cliente) {
        return this.clientes.containsValue(cliente);
    }

    @Override
    public Cliente pesquisaCliente(String id) throws ClienteNaoExisteException {
        Cliente cliente = this.clientes.get(id);
        if (cliente == null)
            throw new ClienteNaoExisteException("Cliente de id " + id + " não existente");
        return cliente;
    }

    @Override
    public Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria) {
        Collection<Produto> produtosDaCategoria = new LinkedList<>();
        for (Produto produto : this.produtos.values()) {
            if (produto.getCategoria().equals(categoria))
                produtosDaCategoria.add(produto);
        }
        return produtosDaCategoria;
    }

}
