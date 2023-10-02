package com.ongmap.models.parceiros;

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
