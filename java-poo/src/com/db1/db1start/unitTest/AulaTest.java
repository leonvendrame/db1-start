package com.db1.db1start.unitTest;

import com.db1.db1start.*;
import org.junit.Assert;
import org.junit.Test;

import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AulaTest {

    @Test
    public void esperaCriacaoDeAulaPorConstrutor() {
        Professor professor = new Professor("Professor", "professor@teste.com");
        Materia materia = new Materia("Matéria", "Teste Unitário", 23.5,
                professor, 4);
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Aluno 1", "aluno1@teste.com"));
        alunos.add(new Aluno("Aluno 2", "aluno2@teste.com"));
        Aula aula = new Aula(new Date(), materia, alunos);

        Assert.assertEquals(materia, aula.getMateria());
        Assert.assertEquals(alunos, aula.getAlunosPresentes());
    }

    @Test
    public void esperaExcecaoDataNaoPodeSerNula() {
        Professor professor= new Professor("Professor", "professor@teste.com");
        Materia materia = new Materia("Matéria", "Teste Unitário", 23.5,
                professor, 4);
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Aluno 1", "aluno1@teste.com"));
        alunos.add(new Aluno("Aluno 2", "aluno2@teste.com"));
        try {
            Aula aula = new Aula(null, materia, alunos);
        } catch (CampoNaoPodeSerNulo campoNaoPodeSerNulo) {
            Assert.assertEquals("Data não pode ser nula", campoNaoPodeSerNulo.getMessage());
        }
    }

    @Test
    public void esperaExcecaoMateriaNaoPodeSerNula() {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Aluno 1", "aluno1@teste.com"));
        alunos.add(new Aluno("Aluno 2", "aluno2@teste.com"));
        try {
            Aula aula = new Aula(new Date(), null, alunos);
        } catch (CampoNaoPodeSerNulo campoNaoPodeSerNulo) {
            Assert.assertEquals("Matéria não pode ser nula", campoNaoPodeSerNulo.getMessage());
        }
    }
}
