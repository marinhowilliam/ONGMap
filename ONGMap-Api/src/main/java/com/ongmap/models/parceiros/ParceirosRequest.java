package com.ongmap.models.parceiros;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ParceirosRequest(@Pattern(regexp = "[0-9]{14}", message = "CNPJ inválido")
                               String cnpj,
                               @NotBlank
                               String nome,
                               @NotBlank
                               String tipoParceria) {
    public Parceiros toParceiros(){
        return new Parceiros(cnpj, nome, tipoParceria);
    }
}
