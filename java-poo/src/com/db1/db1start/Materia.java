package com.db1.db1start;

public class Materia {
    private String nome;
    private String conteudo;
    private Double cargaHoraria;
    private Professor professorResponsavel;
    private Integer qtdeAulas;

    public Materia(String nome, String conteudo, Double cargaHoraria, Professor professorResponsavel, Integer qtdeAulas) {
        this.nome = nome;
        this.conteudo = conteudo;
        this.cargaHoraria = cargaHoraria;
        this.professorResponsavel = professorResponsavel;
        this.qtdeAulas = qtdeAulas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getQtdeAulas() {
        return qtdeAulas;
    }

    public void setQtdeAulas(Integer qtdeAulas) {
        this.qtdeAulas = qtdeAulas;
    }
}
