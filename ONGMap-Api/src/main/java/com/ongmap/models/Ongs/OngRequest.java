package com.ongmap.models.Ongs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record OngRequest(@Pattern(regexp = "[0-9]{14}", message = "CNPJ inválido")
                         String cnpj,
                         @NotBlank(message = "Nome não pode ser vazio")
                         String nome,
                         @NotBlank(message = "Telefone não pode ser vazio")
                         String telefone,
                         @NotBlank(message = "Endereço não pode ser vazio")
                         Endereco endereco,
                         String missao,
                         @NotBlank(message = "Área de atuação não pode ser vazia")
                         AreaAtuacao areaAtuacao,
                         boolean ativo) {
    public Ong toOng() {
        return new Ong(cnpj, nome, telefone, endereco, missao, areaAtuacao, ativo);
    }
}
