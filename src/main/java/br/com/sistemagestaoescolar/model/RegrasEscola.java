package br.com.sistemagestaoescolar.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegrasEscola {

    private int maxAlunosPorTurma;
    private int maxAlunosPorProfessor;
    private int cargaHorariaDisciplina;
    private int cargaHorariaTurno;
}
