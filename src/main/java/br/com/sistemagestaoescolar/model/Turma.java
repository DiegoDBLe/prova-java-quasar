package br.com.sistemagestaoescolar.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Turma {

    private List<Aluno> alunos;
    private List<Disciplina> disciplinas = new ArrayList<>();
    private String serie;
    private List<Professor> professores;
    private int maxAlunos;

}
