package com.ongmap.models.voluntario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VoluntarioRequest(@Pattern(regexp = "[0-9]{11}", message = "CPF invalido")
                                String cpf,
                                @NotBlank(message = "nome nao pode ser vazio!")
                                String nome,
                                @NotBlank(message = "disponibilidade nao pode ser vazio!")
                                String disponibilidade,
                                @NotBlank(message = "habilidades nao pode ser vazio!")
                                String habilidade,
                                @NotBlank(message = "contato nao pode ser vazio!")
                                String contato
                                ) {
    public Voluntarios ToVoluntario(){
        return new Voluntarios(cpf, nome, disponibilidade, habilidade, contato);
    }
}
