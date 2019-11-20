package com.db1.db1start.unitTest;

import com.db1.db1start.Aluno;
import com.db1.db1start.CampoNaoPodeSerNulo;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class AlunoTest {

    @Test
    public void esperaCriacaoDeAlunoPorConstrutor() {
        String emailEsperado = "teste@teste.com";
        String nomeEsperado = "Teste";
        Aluno aluno = new Aluno("Teste", "teste@teste.com");
        Assert.assertEquals(nomeEsperado, aluno.getNome());
        Assert.assertEquals(emailEsperado, aluno.getEmail());
    }

    @Test
    public void esperaExcecaoNomeNaoPodeSerNulo() {
        try {
            Aluno aluno = new Aluno(null, "teste@teste.com");
        } catch (CampoNaoPodeSerNulo campoNaoPodeSerNulo) {
            Assert.assertEquals("Nome não pode ser nulo", campoNaoPodeSerNulo.getMessage());
        }
    }

    @Test
    public void esperaExcecaoEmailNaoPodeSerNulo() {
        try {
            Aluno aluno = new Aluno("Teste", null);
        } catch (CampoNaoPodeSerNulo campoNaoPodeSerNulo) {
            Assert.assertEquals("Email não pode ser nulo", campoNaoPodeSerNulo.getMessage());
        }
    }
}
