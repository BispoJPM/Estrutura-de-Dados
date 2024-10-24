package org.example;

import java.util.Scanner;

public class fila {
    private static int posicao = -1; // valor inicial
    private static fila proximo = null; // próximo na fila

    public fila(int posicao) {
        fila.posicao = posicao;
        fila.proximo = null;
    }

    public static void enqueue(int valor) {
        if (posicao == -1) { // Caso a fila esteja vazia
            posicao = valor;
            proximo = null;
        } else {
            fila atual = new fila(valor);
            fila temp = fila.proximo;
            fila ultimo = fila.proximo;

            if (ultimo == null) {
                proximo = atual;
            } else {
                while (ultimo.proximo != null) {
                    ultimo = ultimo.proximo;
                }
                ultimo.proximo = atual;
            }
        }
    }

    public static int dequeue() {
        if (posicao == -1) {
            System.out.println("Fila vazia.");
            return -9; // valor de erro
        }

        int valorRemovido = posicao; // pega o valor da frente
        if (proximo != null) {
            posicao = proximo.posicao;
            proximo = proximo.proximo; // move o próximo na fila
        } else {
            posicao = -1; // esvaziando a fila
            proximo = null;
        }
        return valorRemovido;
    }

    public static String conteudo() {
        StringBuilder sb = new StringBuilder();
        if (posicao == -1) {
            return "Fila vazia.";
        }

        sb.append(posicao).append("\n");
        fila atual = proximo;
        while (atual != null) {
            sb.append(atual.posicao).append("\n");
            atual = atual.proximo;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        enqueue(10);
        enqueue(20);
        enqueue(30);

        System.out.print("Conteúdo da fila:\n" + conteudo());
        System.out.println("Retirando: " + dequeue());
        System.out.print("Novo conteúdo da fila:\n" + conteudo());

        scanner.close();
    }
}
