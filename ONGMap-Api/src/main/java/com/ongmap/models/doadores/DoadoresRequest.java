package com.ongmap.models.doadores;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DoadoresRequest(@Pattern(regexp = "[0-9]{11}", message = "CPF inválido")
                              String cpf,
                              @NotBlank
                              String nome,
                              @NotBlank(message = "Contato não pode ser vazio")
                              String contato,
                              Endereco endereco) {
    public Doadores ToDoadores(){
        return new Doadores(cpf, nome, contato, endereco);
    }
}
