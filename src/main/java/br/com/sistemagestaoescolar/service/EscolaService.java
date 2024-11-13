package br.com.sistemagestaoescolar.service;

import br.com.sistemagestaoescolar.enums.Escola;
import br.com.sistemagestaoescolar.enums.Turno;
import br.com.sistemagestaoescolar.model.*;

import java.util.ArrayList;
import java.util.List;

public class EscolaService {

    private final TurmaService turmaService;
    private final ProfessorService professorService;

    public EscolaService(TurmaService turmaService, ProfessorService professorService) {
        this.turmaService = turmaService;
        this.professorService = professorService;
    }

    // Método principal para organizar turmas e professores por tipo de escola
    public List<ParamSaida> organizarEscolaPorTipo(List<ParamEntrada> listaParamEntrada) {
        List<ParamSaida> listaParamSaida = new ArrayList<>();

        for (ParamEntrada entrada : listaParamEntrada) {
            Escola escola = entrada.getEscola();
            List<Aluno> alunos = entrada.getAlunos();
            Turno turno = entrada.getTurno();

            RegrasEscola regras = definirRegrasEscola(escola);

            // Agrupar alunos em turmas de acordo com o tipo de escola
            List<Turma> turmas = turmaService.agruparAlunosEmTurmas(alunos, regras.getMaxAlunosPorTurma());

            // Calcular e distribuir professores nas turmas
            List<Professor> professoresAlocados = professorService.distribuirProfessoresNasTurmas(turmas, turno, regras);

            // Criar ParamSaida para armazenar o resultado
            ParamSaida paramSaida = new ParamSaida();
            paramSaida.setProfessores(professoresAlocados);
            listaParamSaida.add(paramSaida);
        }

        return listaParamSaida;
    }

    private RegrasEscola definirRegrasEscola(Escola escola) {
        switch (escola) {
            case BERCARIO:
                return new RegrasEscola(10, 5, 4, 4);
            case ENSINO_FUNDAMENTAL:
                return new RegrasEscola(20, 1, 2, 4);
            case ENSINO_MEDIO:
                return new RegrasEscola(30, 1, 1, 4);
            default:
                throw new IllegalArgumentException("Tipo de escola não reconhecido");
        }
    }
}
