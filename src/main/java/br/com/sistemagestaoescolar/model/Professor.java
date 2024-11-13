package br.com.sistemagestaoescolar.model;

import br.com.sistemagestaoescolar.enums.Turno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    private List<Disciplina> disciplinas;
    private int cargaHorariaMaxima;
    private List<Turno> turnosDisponiveis;

}
