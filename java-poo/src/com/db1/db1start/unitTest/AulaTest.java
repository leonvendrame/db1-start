package com.db1.db1start.unitTest;

import com.db1.db1start.Aluno;
import com.db1.db1start.Aula;
import com.db1.db1start.Materia;
import com.db1.db1start.Professor;
import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals(aula.getMateria(), materia);
    }
}
