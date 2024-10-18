package org.example;

import java.util.Scanner;

class No {
    int posicao;
    No proximo;

    public No(int posicao) {
        this.posicao = posicao;
        this.proximo = null;
    }
}

public class fila {
    private No proximo; // ponteiro pro prox


    public fila() {
        this.proximo = null; // começa vazia
    }

    public void enqueue(int posicao) { // add
        No novinho = new No(posicao); // instanciando um novo nó

        if (proximo == null) {
            proximo = novinho;}
        else {
            No primeiro = proximo;
            
            while (primeiro.proximo != null) { 
                primeiro = primeiro.proximo; }

            primeiro.proximo = novinho;
        }
    }
    
    public int dequeue() {
        if (proximo == null) {
            return -9; } // valor de erro

        int posicaoTirar = proximo.posicao;
        proximo = proximo.proximo; // aponta pro prox nó
        return posicaoTirar;
    }

    public String conteudo() {
        StringBuilder conteudo = new StringBuilder(); // para concatenar strings
        No novinho = proximo; // começa do primeiro nó
        while (novinho != null) {
            conteudo.append(novinho.posicao).append("\n");
            novinho = novinho.proximo;
        }
        return conteudo.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        fila fila = new fila();

        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        System.out.print("Conteúdo da fila:" + fila.conteudo());
        System.out.println("Retirando: " + fila.dequeue());
        System.out.print("Novo conteúdo da fila:" + fila.conteudo());
        scanner.close();
    }
}