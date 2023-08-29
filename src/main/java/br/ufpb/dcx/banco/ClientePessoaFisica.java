package br.ufpb.dcx.banco;

public class ClientePessoaFisica extends Cliente {

    private final String CPF;
    private final Sexo sexo;

    public ClientePessoaFisica(String nome, String CPF, Sexo sexo) {
        super(nome);
        this.CPF = CPF;
        this.sexo = sexo;
    }

    public String getCPF() {
        return this.CPF;
    }

    public Sexo getSexo() {
        return this.sexo;
    }

    public String getNome() {
        return super.getNome();
    }

}
