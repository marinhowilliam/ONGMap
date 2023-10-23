package com.ongmap.models.doadores;

public record DoadoresDetails(String cpf,
                              String nome,
                              String contato,
                              String endereco) {
    public DoadoresDetails(Doadores doadores){
        this(doadores.getCpf(),
                doadores.getNome(),
                doadores.getContato(),
                doadores.getEndereco());
    }
}
