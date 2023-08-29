package br.ufpb.dcx.banco;

public class Conta {

    private final int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(String nomeCliente, int numero, double saldo) {
        this.cliente = new Cliente(nomeCliente);
        this.numero = numero;
        this.saldo = saldo;
    }

    public boolean debitar(double valor) {
        if (valor > this.saldo || this.saldo < 0) return false;
        this.saldo -= valor;
        return true;
    }

    public void creditar(double valor) {
        this.saldo += valor;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getNumero() {
        return this.numero;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public String nomeCliente() {
        return this.cliente.getNome();
    }

}
