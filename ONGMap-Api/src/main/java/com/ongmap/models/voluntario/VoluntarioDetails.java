package com.ongmap.models.voluntario;

public record VoluntarioDetails(String cpf,
                                String nome,
                                String disponibilidade,
                                String habilidades,
                                String contato) {
    public VoluntarioDetails(Voluntarios voluntario){
        this(voluntario.getCpf(),
                voluntario.getNome(),
                voluntario.getDisponibilidade(),
                voluntario.getHabilidades(),
                voluntario.getContato());
    }
}
