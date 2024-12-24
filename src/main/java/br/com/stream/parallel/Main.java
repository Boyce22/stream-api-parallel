package br.com.stream.parallel;

import br.com.stream.parallel.services.Processamento;
import br.com.stream.parallel.services.Typing;

import java.util.Scanner;

public class Main {
    private static final String MENU_OPCOES = """
            \n=== Escolha uma forma de processamento ===
            1 - Processamento sequencial
            2 - Processamento paralelo
            0 - Sair
            ==========================================
            Digite sua opção: 
            """;
    private static final int OPCAO_SEQUENCIAL = 1;

    private static final int OPCAO_PARALELO = 2;

    public static void main(String[] args) {
        Processamento processamentoCliente = new Processamento();

        int opcao = obterOpcaoDoUsuario();

        if (opcao == OPCAO_SEQUENCIAL) {
            processamentoCliente.processamentoSequencial();
            return;
        }

        if (opcao == OPCAO_PARALELO) {
            processamentoCliente.processamentoParalelo();
            return;
        }

        System.out.println("Opção inválida, encerrando o programa.");
    }

    private static int obterOpcaoDoUsuario() {
        Typing typing = new Typing();
        typing.typeText(MENU_OPCOES); ;

        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
        }
        return -1;
    }
}