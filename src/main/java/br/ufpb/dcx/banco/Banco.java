package br.ufpb.dcx.banco;

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class Banco {

    private Map<Integer, Agencia> mapAgencias;

    public Banco() {
        this.mapAgencias = new HashMap<>();
    }

    public boolean adicionarAgencia(Agencia agencia) {
        if (!this.mapAgencias.containsValue(agencia)) {
            this.mapAgencias.put(agencia.getNumero(), agencia);
            return true;
        }
        return false;
    }

    public Collection<Cliente> pesquisarClientesDaAgencia(int numAgencia) {
        Collection<Cliente> clientesDaAgencia = new LinkedList<>();
        for (Agencia a : this.mapAgencias.values()) {
            if (a.getNumero() == numAgencia)
                clientesDaAgencia.addAll(a.getClientes());
        }
        return clientesDaAgencia;
    }

    public boolean transferir(int numAgenciaOrigem, int numContaOrigem,
            int numAgenciaDest, int numContaDest, double valor) {
        Agencia agenciaOrigem = this.mapAgencias.get(numAgenciaOrigem);
        Agencia agenciaDest = this.mapAgencias.get(numAgenciaDest);

        Conta contaOrigem = agenciaOrigem.pesquisarConta(numContaOrigem);
        Conta contaDest = agenciaDest.pesquisarConta(numContaDest);

        if (contaOrigem.debitar(valor)) {
            contaDest.creditar(valor);
            return true;
        }
        return false;
    }

    public Agencia pesquisaAgencia(int numAgencia) {
        return this.mapAgencias.get(numAgencia);
    }

    public Collection<Agencia> getAgencias() {
        return new LinkedList<>(this.mapAgencias.values());
    }

    public boolean criarConta(int numAgencia, int numConta, String nomeCliente, double saldoInicial) {
        Agencia agencia = new Agencia(numAgencia);
        Conta novaConta = new Conta(nomeCliente, numConta, saldoInicial);
        return agencia.adicionarConta(novaConta);
    }

    public double pesquisarSaldoDeConta(int numAgencia, int numConta) {
        Agencia agencia = this.mapAgencias.get(numAgencia);
        Conta conta = agencia.pesquisarConta(numConta);
        return conta.getSaldo();
    }

}
