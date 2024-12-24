package br.com.stream.parallel.services;

public class Typing {
    private static final int TYPING_SPEED = 8;

    /**
     * Simula texto digitado no console.
     * @param text Texto a ser exibido com efeito de digitação.
     */

    public void typeText(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(TYPING_SPEED);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("\n[Erro na simulação de digitação.]");
                break;
            }
        }

        System.out.println("\n");
    }
}
