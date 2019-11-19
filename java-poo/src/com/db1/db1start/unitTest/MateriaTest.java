package com.db1.db1start.unitTest;

import com.db1.db1start.Aluno;
import com.db1.db1start.Materia;
import com.db1.db1start.Professor;
import org.junit.Assert;
import org.junit.Test;

public class MateriaTest {

    @Test
    public void esperaCriacaoDeMateriaPorConstrutor() {
        String nomeEsperado = "Matéria";
        String conteudoEsperado = "Teste Unitário";
        Double cargaHorariaEsperada = 23.5;
        Integer qtdeAulasEsperada = 4;
        Professor professor = new Professor("Professor", "professor@teste.com");
        Materia materia = new Materia("Matéria", "Teste Unitário", 23.5,
                professor, 4);

        Assert.assertEquals(materia.getNome(), nomeEsperado);
        Assert.assertEquals(materia.getConteudo(), conteudoEsperado);
        Assert.assertEquals(materia.getCargaHoraria(), cargaHorariaEsperada);
        Assert.assertEquals(materia.getQtdeAulas(), qtdeAulasEsperada);
        Assert.assertEquals(materia.getProfessorResponsavel(), professor);
    }
}
