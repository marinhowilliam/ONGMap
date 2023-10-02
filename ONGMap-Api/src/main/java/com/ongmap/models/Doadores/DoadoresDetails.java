package com.ongmap.models.Doadores;

public record DoadoresDetails(String cpf,
                              String nome,
                              String contato,
                              String historicoDoacoes,
                              String endereco) {
    public DoadoresDetails(Doadores doadores){
        this(doadores.getCpf(),
                doadores.getNome(),
                doadores.getContato(),
                doadores.getHistoricoDoacoes(),
                doadores.getEndereco());
    }
}
