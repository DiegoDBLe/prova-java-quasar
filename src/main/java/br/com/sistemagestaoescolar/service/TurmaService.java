package br.com.sistemagestaoescolar.service;

import br.com.sistemagestaoescolar.model.Aluno;
import br.com.sistemagestaoescolar.model.Turma;

import java.util.ArrayList;
import java.util.List;

public class TurmaService {

    // Método para agrupar alunos em turmas com base no número máximo de alunos por turma
    public List<Turma> agruparAlunosEmTurmas(List<Aluno> alunos, int maxAlunosPorTurma) {
        List<Turma> turmas = new ArrayList<>();
        List<Aluno> turmaAtual = new ArrayList<>();

        for (Aluno aluno : alunos) {
            turmaAtual.add(aluno);

            // Quando a turma atinge o máximo de alunos, cria uma nova turma
            if (turmaAtual.size() == maxAlunosPorTurma) {
                Turma novaTurma = new Turma();
                novaTurma.setAlunos(new ArrayList<>(turmaAtual));
                turmas.add(novaTurma);
                turmaAtual.clear();
            }
        }

        // Caso ainda haja alunos que não completam uma turma cheia
        if (!turmaAtual.isEmpty()) {
            Turma ultimaTurma = new Turma();
            ultimaTurma.setAlunos(new ArrayList<>(turmaAtual));
            turmas.add(ultimaTurma);
        }

        return turmas;
    }

    // Calcula o número total de alunos em uma lista de turmas
    public int calcularTotalDeAlunos(List<Turma> turmas) {
        int totalAlunos = 0;
        for (Turma turma : turmas) {
            totalAlunos += turma.getAlunos().size();
        }
        return totalAlunos;
    }

    // Adiciona um aluno a uma turma, respeitando o limite máximo de alunos
    public boolean adicionarAlunoNaTurma(Turma turma, Aluno aluno, int maxAlunosPorTurma) {
        if (turma.getAlunos().size() < maxAlunosPorTurma) {
            turma.getAlunos().add(aluno);
            return true; // Aluno adicionado com sucesso
        }
        return false; // Turma cheia, aluno não adicionado
    }

    // Remove um aluno de uma turma
    public boolean removerAlunoDaTurma(Turma turma, Aluno aluno) {
        return turma.getAlunos().remove(aluno);
    }

}
