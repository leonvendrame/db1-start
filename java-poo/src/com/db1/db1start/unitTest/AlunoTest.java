package com.db1.db1start.unitTest;

import com.db1.db1start.Aluno;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class AlunoTest {

    @Test
    public void esperaCriacaoDeAlunoPorConstrutor() {
        String emailEsperado = "teste@teste.com";
        String nomeEsperado = "Teste";
        Aluno aluno = new Aluno("Teste", "teste@teste.com");
        Assert.assertEquals(aluno.getNome(), nomeEsperado);
        Assert.assertEquals(aluno.getEmail(), emailEsperado);
    }
}
