package com.ongmap.models.ong;

public record OngDetails(String cnpj,
                         String nome,
                         String telefone,
                         Endereco endereco,
                         String missao,
                         AreaAtuacao areaAtuacao,
                         boolean ativo) {
    public OngDetails(Ong ong) {
        this(ong.getCnpj(),
                ong.getNome(),
                ong.getTelefone(),
                ong.getEndereco(),
                ong.getMissao(),
                ong.getAreaAtuacao(),
                ong.isAtivo());
    }
}
