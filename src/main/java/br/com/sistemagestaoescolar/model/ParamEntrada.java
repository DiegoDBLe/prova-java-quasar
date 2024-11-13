package br.com.sistemagestaoescolar.model;

import br.com.sistemagestaoescolar.enums.Escola;
import br.com.sistemagestaoescolar.enums.Turno;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ParamEntrada {

    private List<Aluno> alunos;
    private Escola escola;
    private Turno turno;
    private String serie;


}
