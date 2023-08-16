package br.ufpb.dcx.diogo.amigosecreto;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SistemaAmigoMap {

    private List<Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap() {
        this.mensagens = new LinkedList<>();
        this.amigos = new HashMap<>();
    }

    public Map<String, Amigo> getAmigos() {
        return this.amigos;
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaCadastradoException {
        Amigo amigo = new Amigo(nomeAmigo, emailAmigo);
        if (!this.amigos.containsKey(emailAmigo))
            this.amigos.put(emailAmigo, amigo);
        else
            throw new AmigoJaCadastradoException("Amigo de email " + emailAmigo + " já cadastrado anteriormente");
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        if (this.amigos.containsKey(emailAmigo))
            return amigos.get(emailAmigo);
        throw new AmigoInexistenteException("Amigo de email " + emailAmigo + " não encontrado");
    }

    public void enviarMensagensParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem mensagem = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente,
                                         String emailDestinatario, boolean ehAnonima) {
        Mensagem mensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        this.mensagens.add(mensagem);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new LinkedList<>();
        for (Mensagem m : this.mensagens)
            if (m.ehAnonima()) mensagensAnonimas.add(m);
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return this.mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado)
            throws AmigoInexistenteException {
        Amigo amigo = null;
        if (this.amigos.containsKey(emailDaPessoa))
            amigo = this.amigos.get(emailDaPessoa);
        if (amigo == null)
            throw new AmigoInexistenteException("Amigo de email " + emailDaPessoa + " não encontrado");
        amigo.setEmailAmigoSorteado(emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa)
            throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo amigo = null;
        if (this.amigos.containsKey(emailDaPessoa))
            amigo = this.amigos.get(emailDaPessoa);
        if (amigo == null)
            throw new AmigoInexistenteException("Amigo de email " + emailDaPessoa + " não encontrado");
        if (amigo.getEmailAmigoSorteado() == null)
            throw new AmigoNaoSorteadoException("Amigo secreto de " + emailDaPessoa + " ainda não foi sorteado");
        return amigo.getEmailAmigoSorteado();
    }

}
