package br.ufpb.dcx.banco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestConta {

    Banco banco;
    Conta conta;

    @BeforeEach
    public void setUp() {
        banco = new Banco();
        conta = new Conta("Carlos", 777, 390);
    }

    @Test
    public void testarConta() {
        assertEquals(390, conta.getSaldo());
        assertFalse(conta.debitar(600));
        assertEquals(390, conta.getSaldo());
    }

}
