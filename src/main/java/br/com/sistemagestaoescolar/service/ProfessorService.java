package br.com.sistemagestaoescolar.service;

import br.com.sistemagestaoescolar.enums.Turno;
import br.com.sistemagestaoescolar.model.Disciplina;
import br.com.sistemagestaoescolar.model.Professor;
import br.com.sistemagestaoescolar.model.RegrasEscola;
import br.com.sistemagestaoescolar.model.Turma;

import java.util.ArrayList;
import java.util.List;

public class ProfessorService {

    public int calcularProfessoresBerçario(List<Turma> turmas, int maxAlunosPorProfessor) {
        int professoresNecessarios = 0;

        for (Turma turma : turmas) {
            int numeroDeAlunos = turma.getAlunos().size();

            // Calcula o número de professores necessários para a turma
            int professoresParaTurma = (int) Math.ceil((double) numeroDeAlunos / maxAlunosPorProfessor);
            professoresNecessarios += professoresParaTurma;
        }

        return professoresNecessarios;
    }

    // Método para calcular professores para o Ensino Fundamental
    public int calcularProfessoresFundamental(List<Turma> turmas, int cargaHorariaDisciplina, int cargaHorariaMaximaProfessor) {
        int professoresNecessarios = 0;

        for (Turma turma : turmas) {
            int disciplinasPorTurma = turma.getDisciplinas().size();

            // Cálculo da carga horária total da turma (número de disciplinas * carga horária de cada disciplina)
            int cargaHorariaTotal = disciplinasPorTurma * cargaHorariaDisciplina;

            // Calcula o número de professores necessários para cobrir a carga horária da turma
            int professoresParaTurma = (int) Math.ceil((double) cargaHorariaTotal / cargaHorariaMaximaProfessor);

            // Adiciona o número de professores necessários para essa turma ao total geral
            professoresNecessarios += professoresParaTurma;
        }

        return professoresNecessarios;
    }

    public int calcularProfessoresMedio(List<Turma> turmas, int cargaHorariaDisciplina, int cargaHorariaMaximaProfessor) {
        int professoresNecessarios = 0;

        for (Turma turma : turmas) {
            int disciplinasPorTurma = turma.getDisciplinas().size();

            // Cálculo da carga horária total da turma (número de disciplinas * carga horária de cada disciplina)
            int cargaHorariaTotal = disciplinasPorTurma * cargaHorariaDisciplina;

            // Calcula o número de professores necessários para cobrir a carga horária da turma
            int professoresParaTurma = (int) Math.ceil((double) cargaHorariaTotal / cargaHorariaMaximaProfessor);

            // Adiciona o número de professores necessários para essa turma ao total geral
            professoresNecessarios += professoresParaTurma;
        }

        return professoresNecessarios;
    }

    public List<Professor> distribuirProfessoresNasTurmas(List<Turma> turmas, Turno turno, RegrasEscola regras) {
        List<Professor> professoresAlocados = new ArrayList<>();

        for (Turma turma : turmas) {
            List<Disciplina> disciplinas = turma.getDisciplinas();

            System.out.println("Disciplinas na turma: " + (disciplinas != null ? disciplinas.size() : "Nenhuma"));
            if (disciplinas == null || disciplinas.isEmpty()) {
                System.out.println("A turma não possui disciplinas. Verifique a configuração de disciplinas.");
                continue;
            }

            int disciplinasPorTurma = disciplinas.size();
            System.out.println("Número de disciplinas na turma: " + disciplinasPorTurma);

            int cargaHorariaTotal = disciplinasPorTurma * regras.getCargaHorariaDisciplina();
            System.out.println("Carga horária total da turma: " + cargaHorariaTotal);

            int professoresNecessarios = (int) Math.ceil((double) cargaHorariaTotal / regras.getCargaHorariaTurno());
            System.out.println("Professores necessários para a turma: " + professoresNecessarios);

            for (int i = 0; i < professoresNecessarios; i++) {
                Professor professor = new Professor();
                professor.setTurnosDisponiveis(List.of(turno));
                professor.setCargaHorariaMaxima(regras.getCargaHorariaTurno());
                professor.setDisciplinas(disciplinas);
                professoresAlocados.add(professor);
            }
        }

        System.out.println("Total de professores alocados: " + professoresAlocados.size());
        return professoresAlocados;
    }

    public int obterCargaHorariaTotalDaTurma(Turma turma, int cargaHorariaDisciplina) {
        int disciplinasPorTurma = turma.getDisciplinas().size();
        return disciplinasPorTurma * cargaHorariaDisciplina;
    }
}
