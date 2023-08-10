package br.ufpb.dcx.diogo.amigosecreto;

public class TestaSistemaAmigo {

    public static void main(String[] args) {

        try {
            SistemaAmigo sistemaAmigo = new SistemaAmigo();

            sistemaAmigo.cadastraAmigo("José", "jose@gmail.com");
            sistemaAmigo.cadastraAmigo("Maria", "maria@gmail.com");

            sistemaAmigo.configuraAmigoSecretoDe("jose@gmail.com", "maria@gmail.com");
            sistemaAmigo.configuraAmigoSecretoDe("maria@gmail.com", "jose@gmail.com");

            sistemaAmigo.enviarMensagemParaAlguem(
                    "E agora José?", "maria@gmail.com", "jose@gmail.com", true);
            sistemaAmigo.enviarMensagemParaAlguem(
                    "Tá cheia de graça, hein?", "jose@gmail.com", "maria@gmail.com", true);

            for (Mensagem m : sistemaAmigo.pesquisaMensagensAnonimas())
                System.out.println(m.getTextoCompletoAExibir());

            Amigo jose = sistemaAmigo.pesquisaAmigo("jose@gmail.com");

            if (jose.getEmailAmigoSorteado().equals("maria@gmail.com"))
                System.out.println("OK");

        } catch (AmigoJaCadastradoException | AmigoInexistenteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
