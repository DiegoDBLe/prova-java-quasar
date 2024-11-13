package br.com.sistemagestaoescolar.model;

import br.com.sistemagestaoescolar.enums.Turno;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Aluno {

    private String nome;
    private int cargaHorariaDisponivel;
    private List<Turno> turnnos;

}
