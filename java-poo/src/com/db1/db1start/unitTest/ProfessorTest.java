package com.db1.db1start.unitTest;

import com.db1.db1start.CampoNaoPodeSerNulo;
import com.db1.db1start.Professor;
import org.junit.Assert;
import org.junit.Test;

public class ProfessorTest {

    @Test
    public void esperaCriacaoDeProfessorPorConstrutor() {
        String nomeEsperado = "Professor";
        String emailEsperado = "professor@teste.com";
        Professor professor = new Professor("Professor", "PROFESSOR@teste.com");

        Assert.assertEquals(nomeEsperado, professor.getNome());
        Assert.assertEquals(emailEsperado, professor.getEmail());
    }

    @Test
    public void esperaExcecaoNomeNaoPodeSerNulo() {
        try {
            Professor professor = new Professor(null, "teste@teste.com");
        } catch (CampoNaoPodeSerNulo campoNaoPodeSerNulo) {
            Assert.assertEquals("Nome não pode ser nulo", campoNaoPodeSerNulo.getMessage());
        }
    }

    @Test
    public void esperaExcecaoEmailNaoPodeSerNulo() {
        try {
            Professor professor = new Professor("Teste", null);
        } catch (CampoNaoPodeSerNulo campoNaoPodeSerNulo) {
            Assert.assertEquals("Email não pode ser nulo", campoNaoPodeSerNulo.getMessage());
        }
    }
}
