package br.com.sistemagestaoescolar.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Disciplina {

    private String nome;
    private int cargaHoraria;
}
