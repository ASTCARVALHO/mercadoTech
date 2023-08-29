package br.ufpb.dcx.banco;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Agencia {

    private int numero;
    private Map<Integer, Conta> contas;
    private Collection<Cliente> clientes;

    public Agencia(int numero) {
        this.numero = numero;
        this.contas = new HashMap<>();
        this.clientes = new LinkedList<>();
    }

    public int getNumero() {
        return this.numero;
    }

    public boolean adicionarConta(Conta c) {
        if (!this.contas.containsValue(c)) {
            this.contas.put(c.getNumero(), c);
            return true;
        }
        return false;
    }

    public Conta pesquisarConta(int numConta) {
        return this.contas.get(numConta);
    }

    public Collection<Cliente> getClientes() {
        for (Conta c : this.contas.values())
            this.clientes.add(c.getCliente());
        return this.clientes;
    }

}
