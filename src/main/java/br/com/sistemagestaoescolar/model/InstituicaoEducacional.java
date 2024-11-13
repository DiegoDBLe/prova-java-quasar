package br.com.sistemagestaoescolar.model;

import br.com.sistemagestaoescolar.enums.Escola;
import br.com.sistemagestaoescolar.enums.Turno;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class InstituicaoEducacional {

    private Escola tipo;
    private List<Turno> turnos;
    private List<Turma> turmas;
    private RegrasEscola regras;
}
