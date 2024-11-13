package br.com;

import br.com.sistemagestaoescolar.enums.Escola;
import br.com.sistemagestaoescolar.enums.Turno;
import br.com.sistemagestaoescolar.model.*;
import br.com.sistemagestaoescolar.service.EscolaService;
import br.com.sistemagestaoescolar.service.ProfessorService;
import br.com.sistemagestaoescolar.service.TurmaService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Inicialização dos serviços
        TurmaService turmaService = new TurmaService();
        ProfessorService professorService = new ProfessorService();
        EscolaService escolaService = new EscolaService(turmaService, professorService);

        // === Teste para o Berçário ===
        System.out.println("=== Teste para o Berçário ===");
        List<Aluno> alunosBercario = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            alunosBercario.add(new Aluno("Criança " + i, 4, List.of(Turno.TARDE)));
        }
        ParamEntrada paramEntradaBercario = new ParamEntrada();
        paramEntradaBercario.setAlunos(alunosBercario);
        paramEntradaBercario.setEscola(Escola.BERCARIO);
        paramEntradaBercario.setTurno(Turno.TARDE);

        // === Teste para o Ensino Fundamental ===
        System.out.println("\n=== Teste para o Ensino Fundamental ===");
        List<Aluno> alunosFundamental = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            alunosFundamental.add(new Aluno("Aluno " + i, 4, List.of(Turno.MANHA)));
        }
        List<Disciplina> disciplinasFundamental = List.of(
                new Disciplina("Português", 2),
                new Disciplina("Matemática", 2),
                new Disciplina("Ciências", 2)
        );
        List<Turma> turmasFundamental = turmaService.agruparAlunosEmTurmas(alunosFundamental, 20);
        turmasFundamental.forEach(turma -> turma.setDisciplinas(disciplinasFundamental)); // Associando disciplinas

        // Verificação das disciplinas associadas para Ensino Fundamental
        turmasFundamental.forEach(turma ->
                System.out.println("Fundamental - Disciplinas da turma: " + turma.getDisciplinas().size()));

        ParamEntrada paramEntradaFundamental = new ParamEntrada();
        paramEntradaFundamental.setAlunos(alunosFundamental);
        paramEntradaFundamental.setEscola(Escola.ENSINO_FUNDAMENTAL);
        paramEntradaFundamental.setTurno(Turno.MANHA);
        paramEntradaFundamental.setSerie("5ª Série");

        // === Teste para o Ensino Médio ===
        System.out.println("\n=== Teste para o Ensino Médio ===");
        List<Aluno> alunosMedio = new ArrayList<>();
        for (int i = 1; i <= 60; i++) {
            alunosMedio.add(new Aluno("Estudante " + i, 4, List.of(Turno.MANHA, Turno.TARDE)));
        }
        List<Disciplina> disciplinasMedio = List.of(
                new Disciplina("Física", 1),
                new Disciplina("Química", 1),
                new Disciplina("Biologia", 1)
        );
        List<Turma> turmasMedio = turmaService.agruparAlunosEmTurmas(alunosMedio, 30);
        turmasMedio.forEach(turma -> turma.setDisciplinas(disciplinasMedio)); // Associando disciplinas

        // Verificação das disciplinas associadas para Ensino Médio
        turmasMedio.forEach(turma ->
                System.out.println("Médio - Disciplinas da turma: " + turma.getDisciplinas().size()));

        ParamEntrada paramEntradaMedio = new ParamEntrada();
        paramEntradaMedio.setAlunos(alunosMedio);
        paramEntradaMedio.setEscola(Escola.ENSINO_MEDIO);
        paramEntradaMedio.setTurno(Turno.MANHA);
        paramEntradaMedio.setSerie("1º Ano");

        // Criação da lista de ParamEntrada contendo todos os tipos de escola
        List<ParamEntrada> listaParamEntrada = List.of(paramEntradaBercario, paramEntradaFundamental, paramEntradaMedio);

        // Teste do método principal do EscolaService para os três tipos de escola
        List<ParamSaida> listaParamSaida = escolaService.organizarEscolaPorTipo(listaParamEntrada);

        // Exibição dos resultados para o Berçário, Ensino Fundamental e Ensino Médio
        System.out.println("\n=== Resultados dos Testes ===");
        for (int i = 0; i < listaParamSaida.size(); i++) {
            ParamSaida paramSaida = listaParamSaida.get(i);
            Escola tipoEscola = listaParamEntrada.get(i).getEscola();
            System.out.println("\nEscola: " + tipoEscola);
            System.out.println("Professores alocados: " + paramSaida.getProfessores().size());

            for (Professor professor : paramSaida.getProfessores()) {
                System.out.println("Professor - Carga Horária Máxima: " + professor.getCargaHorariaMaxima());
                System.out.println("Turnos Disponíveis: " + professor.getTurnosDisponiveis());
                System.out.println("Disciplinas: " + professor.getDisciplinas());
            }
        }
    }
}
