package br.ufpb.dcx.sistemacomercial;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static br.ufpb.dcx.sistemacomercial.CategoriaProduto.ALIMENTO;

public class SistemaComercialMapTest {

    @Test
    public void testaCadastraProduto() {
        SistemaComercialMap sistema = new SistemaComercialMap();
        Collection<Produto> alimentos = sistema.pesquisaProdutosDaCategoria(ALIMENTO);
        assertTrue(alimentos.size() == 0);

        Produto produto = new Produto(
                "1234", "Biscoito recheado", 4.30, 30, ALIMENTO);

        boolean existe = sistema.cadastraProduto(produto);
        assertTrue(existe);

        alimentos.add(produto);
        assertTrue(alimentos.size() == 1);
    }
}
