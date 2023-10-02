package com.ongmap.models.Doadores;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DoadoresRequest(@Pattern(regexp = "[0-9]{11}", message = "CPF inválido")
                              String cpf,
                              @NotBlank
                              String nome,
                              @NotBlank
                              String historicoDoacoes,
                              @NotBlank
                              String contato,
                              String endereco) {
    public Doadores ToDoadores(){
        return new Doadores(cpf, nome, historicoDoacoes, contato, endereco);
    }
}
