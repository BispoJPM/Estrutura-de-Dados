package org.example;

public class cabeca {
    // Classe que representa um nó da lista encadeada
    private class No {
        Object valor;
        No proximo;

        No(Object valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No cabeca;  // Cabeça da pilha (nó especial que não armazena valor significativo)
    private int tamanho;

    public cabeca() {
        this.cabeca = new No(null);  // A cabeça é inicializada com valor nulo
        this.tamanho = 0;
    }

    // Verifica se a pilha está vazia
    public boolean pilhaVazia() {
        return this.tamanho == 0;
    }

    // Retorna o tamanho da pilha
    public int tamanho() {
        return this.tamanho;
    }

    // Retorna o último valor (no topo da pilha) sem removê-lo
    public Object exibeUltimoValor() {
        if (this.pilhaVazia()) {
            return null;
        }
        return this.cabeca.proximo.valor;
    }

    // Remove e retorna o último valor da pilha
    public Object desempilhar() {
        if (this.pilhaVazia()) {
            return null;
        }
        Object valor = this.cabeca.proximo.valor;  // Valor do nó a ser removido
        this.cabeca.proximo = this.cabeca.proximo.proximo;  // Avança a cabeça
        this.tamanho--;
        return valor;
    }

    // Empilha um valor no topo
    public void empilhar(Object valor) {
        No novoNo = new No(valor);
        novoNo.proximo = this.cabeca.proximo;  // O novo nó aponta para o antigo primeiro elemento
        this.cabeca.proximo = novoNo;  // A cabeça aponta para o novo nó
        this.tamanho++;
    }

    public static void main(String[] args) {
        cabeca pilha = new cabeca();
        pilha.empilhar("Portuguesa");
        pilha.empilhar("Frango com catupiry");
        pilha.empilhar("Calabresa");
        pilha.empilhar("Quatro queijos");
        pilha.empilhar(10);

        while (!pilha.pilhaVazia()) {
            System.out.println(pilha.desempilhar());
        }
    }
}

