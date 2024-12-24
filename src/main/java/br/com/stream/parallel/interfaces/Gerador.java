package br.com.stream.parallel.interfaces;

import br.com.stream.parallel.models.Cliente;

import java.util.List;

public interface Gerador {
    List<? extends Cliente> gerar();
}
