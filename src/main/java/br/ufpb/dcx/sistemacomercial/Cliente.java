package br.ufpb.dcx.sistemacomercial;

public abstract class Cliente {

    private String nome;
    private String endereco;
    private String email;

    public abstract String getId();

    public Cliente(String nome, String endereco, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
    }

    public Cliente() {
        this("", "", "");
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        if (this instanceof ClientePF) {
            return "Cliente PF {" + "\n" +
                    "Nome: " + this.nome + '\n' +
                    "CPF: " + this.getId() + '\n' +
                    "Endereço: " + this.endereco + '\n' +
                    "Email: " + this.email +
                    " }";
        }
        return "Cliente PF {" + "\n" +
                "Nome: " + this.nome + '\n' +
                "CNPJ: " + this.getId() + '\n' +
                "Endereço: " + this.endereco + '\n' +
                "Email: " + this.email +
                " }";
    }

}
