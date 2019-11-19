package com.db1.db1start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();
        List<Materia> materias = new ArrayList<>();
        List<Aula> aulas = new ArrayList<>();

        alunos.add(new Aluno("Leonardo Vendrame", "leonardo@gmail.com"));
        alunos.add(new Aluno("Lucas Ohaia", "lucas@gmail.com"));
        alunos.add(new Aluno("Maria Clara", "maria@gmail.com"));
        alunos.add(new Aluno("Nathália Gomes", "naThalia@gmail.com"));

        professores.add(new Professor("Maiko", "maiko@gmail.com"));
        professores.add(new Professor("Aline", "aline@gmail.com"));
        professores.add(new Professor("Robson", "Robson@gmail.com"));

        materias.add(new Materia("Programação Orientada a Objetos", "Teste",
                12, professores.get(0)));
        materias.add(new Materia("Banco de Dados", "Bancos de Teste",
                12, professores.get(1)));
        materias.add(new Materia("Estruturas de Dados", "Teste de estruturas",
                12, professores.get(2)));

        aulas.add(new Aula(new Date(11-04-2019), materias.get(0), Arrays.asList(alunos.get(0), alunos.get(2))));
        aulas.add(new Aula(new Date(11-05-2019), materias.get(1), alunos.subList(0,4)));

        aulas.get(0).printAlunosPresentes();
        printSeparador();
        aulas.get(1).printAlunosPresentes();
        printSeparador();
    }

    public static void printSeparador() {
        System.out.println("--------------------------");
    }
}
