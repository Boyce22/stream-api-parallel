package br.com.stream.parallel.models;

import java.util.UUID;

public class Cliente {
    private String id;

    private String nome;

    public Cliente preencher(String nome) {
        this.id = criarIdentificadorUnico();
        this.nome = nome;
        return this;
    }

    public Cliente() {

    }

    public static Cliente criarInstancia() {
        return new Cliente();
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    private String criarIdentificadorUnico() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Nome: %s", id, nome);
    }
}
