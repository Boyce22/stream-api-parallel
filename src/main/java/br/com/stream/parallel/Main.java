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
            Digite sua opção:""";

    private static final int OPCAO_SEQUENCIAL = 1;
    private static final int OPCAO_PARALELO = 2;
    private static final int OPCAO_SAIR = 0;


    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Processamento processamentoCliente = new Processamento();
        int opcao = obterOpcaoDoUsuario();

        while (opcao != OPCAO_SAIR) {
            switch (opcao) {
                case OPCAO_SEQUENCIAL -> processamentoCliente.processamentoSequencial();
                case OPCAO_PARALELO -> processamentoCliente.processamentoParalelo();
                default -> System.out.println("Opção inválida! Por favor, escolha novamente.");
            }

            opcao = obterOpcaoDoUsuario();
        }

        System.out.println("Programa encerrado.");
    }

    private static int obterOpcaoDoUsuario() {
        Typing typing = new Typing();
        typing.typeText(MENU_OPCOES);

        if (SCANNER.hasNextInt()) {
            return SCANNER.nextInt();
        } else {
            System.out.println("Entrada inválida! Por favor, insira um número.");
            SCANNER.nextLine();
        }
        return -1;
    }
}