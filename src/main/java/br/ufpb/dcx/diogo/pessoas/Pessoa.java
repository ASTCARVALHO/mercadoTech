package br.ufpb.dcx.diogo.pessoas;

import java.time.Year;

public class Pessoa {
    private String nome;
    private int idade;
    private double altura;

    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public Pessoa() {
        this("", 0, 0.0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int anoDeNascimento() {
        return Year.now().getValue() - idade;
    }

    public boolean ehDeMaior(Pessoa pessoa) {
        return pessoa.getIdade() >= 18;
    }

    @Override
    public String toString() {
        return "Pessoa de nome " + nome + ", que possui " + idade +
                " anos de idade e tem " + altura + "m de altura";
    }

}
