package com.ongmap.models.parceiro;

public record   ParceiroDetails(String cnpj,
                              String nome,
                              String tipoDeParceria) {
    public ParceiroDetails(Parceiros parceiros){
        this(parceiros.getCnpj(),
                parceiros.getNome(),
                parceiros.getTipoDeParceria()
        );
    }
}
