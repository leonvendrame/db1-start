package com.db1.db1start.unitTest;

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
}
