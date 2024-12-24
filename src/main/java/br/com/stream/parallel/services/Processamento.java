package br.com.stream.parallel.services;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.IntStream;

public class Processamento implements br.com.stream.parallel.interfaces.Processamento {

    private static final int LIMITE_SUPERIOR = 1_0000000;

    private final Typing typing;

    public  Processamento() {
        this.typing = new Typing();
    }

    @Override
    public void processamentoSequencial() {
        typing.typeText("Iniciando processamento sequencial...");
        Instant start = Instant.now();

        List<Integer> numerosPrimos = IntStream.rangeClosed(2, LIMITE_SUPERIOR)
                .filter(this::isPrimo)
                .boxed()
                .toList();

        Instant end = Instant.now();

        long elapsedMillis = Duration.between(start, end).toMillis();

        typing.typeText("Processamento concluído!");
        typing.typeText("Tempo total para processamento sequencial: " + elapsedMillis + " ms");
        typing.typeText("Total de números primos encontrados: " + numerosPrimos.size());
    }

    @Override
    public void processamentoParalelo() {
        typing.typeText("Iniciando processamento paralelo...");
        Instant start = Instant.now();

        List<Integer> numerosPrimos = IntStream.rangeClosed(2, LIMITE_SUPERIOR)
                .parallel()
                .filter(this::isPrimo)
                .boxed()
                .toList();

        Instant end = Instant.now();

        long elapsedMillis = Duration.between(start, end).toMillis();

        typing.typeText("Processamento paralelo concluído!");
        typing.typeText("Tempo total para processamento paralelo: " + elapsedMillis + " ms");
        typing.typeText("Total de números primos encontrados: " + numerosPrimos.size());
    }

    private boolean isPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}