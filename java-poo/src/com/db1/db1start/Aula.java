package com.db1.db1start;

import java.util.Date;
import java.util.List;

public class Aula {
    private Date data;
    private Materia materia;
    private List<Aluno> alunosPresentes;

    public Aula(Date data, Materia materia, List<Aluno> alunosPresentes) {
        this.data = data;
        this.materia = materia;
        this.alunosPresentes = alunosPresentes;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<Aluno> getAlunosPresentes() {
        return alunosPresentes;
    }

    public void setAlunosPresentes(List<Aluno> alunosPresentes) {
        this.alunosPresentes = alunosPresentes;
    }

    public void printAlunosPresentes() {
        this.getAlunosPresentes().forEach(aluno -> {
            System.out.println(aluno.getNome().toUpperCase());
        });
    }
}
