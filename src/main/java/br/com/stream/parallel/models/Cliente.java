package br.com.stream.parallel.models;

import java.util.UUID;

public class Cliente {
    private String id;

    private String nome;

    public Cliente preencher(Long id, String nome, String cpf, String email, String telefone) {
        this.id = criarIdentificadorUnico();
        this.nome = nome;
        return this;
    }

    private String criarIdentificadorUnico() {
        return UUID.randomUUID().toString();
    }

    public Cliente() {

    }

    public static Cliente  criarInstancia() {
        return new Cliente();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
