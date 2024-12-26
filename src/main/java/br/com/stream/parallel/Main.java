package br.com.stream.parallel;

import br.com.stream.parallel.services.Processamento;
import br.com.stream.parallel.services.Typing;

import java.util.Scanner;

public class Main {
    private static final String MENU_OPCOES = """
            ==========================================
               Bem-vindo ao Processador de Números
            ==========================================
              Escolha uma forma de processamento:
              
              1 - Processamento Sequencial
              2 - Processamento Paralelo
              0 - Sair
            ==========================================
              Sua opção: """;

    private static final int OPCAO_SEQUENCIAL = 1;
    private static final int OPCAO_PARALELO = 2;
    private static final int OPCAO_SAIR = 0;

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Processamento processamentoCliente = new Processamento();

        int opcao;
        do {
            opcao = obterOpcaoDoUsuario();
            processarOpcao(opcao, processamentoCliente);
            limparTela();
        } while (opcao != OPCAO_SAIR);

        exibirMensagemEncerramento();
    }

    private static void processarOpcao(int opcao, Processamento processamentoCliente) {
        switch (opcao) {
            case OPCAO_SEQUENCIAL -> processamentoCliente.processamentoSequencial();
            case OPCAO_PARALELO -> processamentoCliente.processamentoParalelo();
            case OPCAO_SAIR -> System.out.println("Saindo do programa...");
            default -> System.out.println("Opção inválida! Por favor, insira um número válido.");
        }
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

    private static void limparTela() {
       try {
           Thread.sleep(5000);

           for (int i = 0; i < 50; i++) {
               System.out.println();
           }
       } catch (InterruptedException e) {
           System.out.printf("Ocorreu um erro ao tentar limpar a tela, %s%n", e.getMessage());
       }
    }

    private static void exibirMensagemEncerramento() {
        System.out.println("==========================================");
        System.out.println("   Obrigado por usar o Processador de Números!");
        System.out.println("==========================================");
    }
}