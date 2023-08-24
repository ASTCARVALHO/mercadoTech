package br.ufpb.dcx.amigosecreto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import br.ufpb.dcx.amigosecreto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaAmigoMapTest {

    SistemaAmigoMap sistema;

    @BeforeEach
    void setUp()  {
        this.sistema = new SistemaAmigoMap();
    }

    @Test
    void testSistemaAmigo() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        assertThrows(AmigoInexistenteException.class,
                ()-> sistema.pesquisaAmigo("diogo@teste.com"));
    }

    @Test
    void testPesquisaECadastraAmigo() {
        try {
            sistema.pesquisaAmigo("diogo@teste.com");
            fail("Deveria falhar pois não existe ainda");
        } catch (AmigoInexistenteException e) {
            System.out.println("Exceção: " + e.getMessage());
        }

        try {
            sistema.cadastraAmigo("diogo", "diogo@teste.com");
            Amigo a = sistema.pesquisaAmigo("diogo@teste.com");
            assertEquals("diogo", a.getNome());
            assertEquals("diogo@teste.com", a.getEmail());
        } catch (AmigoJaCadastradoException | AmigoInexistenteException  e) {
            fail("Não deveria lançar exceção");
        }


    }

    @Test
    void testEnviarMensagemParaTodos() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        sistema.enviarMensagensParaTodos("texto", "diogo@dcx.ufpb.br", true);
        List<Mensagem> mensagensAchadas = sistema.pesquisaTodasAsMensagens();
        assertTrue(mensagensAchadas.size() == 1);
        assertTrue(mensagensAchadas.get(0).getEmailRemetente().equals("diogo@dcx.ufpb.br"));
    }

    @Test
    void testEnviarMensagemParaAlguem() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        sistema.enviarMensagemParaAlguem("texto", "diogo@dcx.ufpb.br", "givanildo@dcx.ufpb.br", true);
        List<Mensagem> mensagensAchadas = sistema.pesquisaTodasAsMensagens();
        assertEquals(1, mensagensAchadas.size());
        assertTrue(mensagensAchadas.get(0) instanceof MensagemParaAlguem);
        assertTrue(mensagensAchadas.get(0).getTexto().equals("texto"));
    }

    @Test
    void testPesquisaMensagensAnonimas() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        sistema.enviarMensagemParaAlguem("texto 1", "diogo@dcx.ufpb.br", "givanildo@dcx.ufpb.br", false);
        assertTrue(sistema.pesquisaMensagensAnonimas().isEmpty());
        sistema.enviarMensagemParaAlguem("texto 2", "diogo@dcx.ufpb.br", "givanildo@dcx.ufpb.br", true);
        assertTrue(sistema.pesquisaMensagensAnonimas().size() == 1);
    }

    @Test
    void testPesquisaTodasAsMensagens() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        sistema.enviarMensagemParaAlguem("texto 1", "diogo@dcx.ufpb.br", "givanildo@dcx.ufpb.br", false);
        assertTrue(sistema.pesquisaTodasAsMensagens().size() == 1);
        sistema.enviarMensagemParaAlguem("texto 2", "diogo@dcx.ufpb.br", "givanildo@dcx.ufpb.br", true);
        assertTrue(sistema.pesquisaTodasAsMensagens().size() == 2);
    }

    @Test
    void testPesquisaAmigoEConfiguraAmigoSecretoDe() {
        assertThrows(AmigoInexistenteException.class,
                ()-> sistema.pesquisaAmigoSecretoDe("diogo@dcx.ufpb.br"));
        try {
            sistema.cadastraAmigo("Diogo", "diogo@dcx.ufpb.br");
            sistema.cadastraAmigo("Ana", "ana@dcx.ufpb.br");
            sistema.configuraAmigoSecretoDe("diogo@dcx.ufpb.br", "ana@dcx.ufpb.br");
            sistema.configuraAmigoSecretoDe("ana@dcx.ufpb.br", "diogo@dcx.ufpb.br");
            assertEquals("ana@dcx.ufpb.br", sistema.pesquisaAmigoSecretoDe("diogo@dcx.ufpb.br"));
            assertEquals("diogo@dcx.ufpb.br", sistema.pesquisaAmigoSecretoDe("ana@dcx.ufpb.br"));
        } catch (AmigoInexistenteException | AmigoJaCadastradoException | AmigoNaoSorteadoException e) {
            fail("Não deveria lançar exceção");
        }
    }


}
