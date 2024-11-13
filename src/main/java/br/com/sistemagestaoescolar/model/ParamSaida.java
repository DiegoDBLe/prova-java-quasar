package br.com.sistemagestaoescolar.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ParamSaida {

    private List<Professor> professores;
}
