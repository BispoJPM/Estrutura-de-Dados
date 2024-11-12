package org.example;

import java.util.Scanner;

public class Pilha {

    private class nozinho {
        String livro;
        nozinho prox;

        public nozinho(String livro, nozinho prox) {
            this.livro = livro;
            this.prox = prox;
        }
    }

    private nozinho cabeca; // variavel de contrle que referencia ao topo e sempre começa null

    public Pilha() {
        cabeca = null;
    }

    public boolean estado() { // mostra o estado dela
        return cabeca == null;
    }

    public void push(String livro) { // cria uma nova instância e da o nó da lista para colocar livro no topo
        cabeca = new nozinho(livro, cabeca);
    }

    public String pop() { // pega o primeiro do topo e retira ele e atualiza o topo
        if (estado()) return null;
        String livro = cabeca.livro;
        cabeca = cabeca.prox;
        return livro;
    }

    public String topo() {
        return estado() ? null : cabeca.livro;  // mostra somente o topo
    }

    public String conteudo() { // mostra o conteudo da pilha
        StringBuilder livros = new StringBuilder(); // inicialização é sempre blabla = new blabla -- permite a concatenação de strings sem criar múltiplos objetos
        nozinho gabi = cabeca;
        while (gabi != null) {
            livros.append(gabi.livro).append("\n");
            gabi = gabi.prox;
        }
        return livros.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha stack = new Pilha();

        stack.push("GoT");
        stack.push("SdA");
        stack.push("CdN");

        System.out.println("Conteúdo da pilha:");
        System.out.println(stack.conteudo());
        System.out.println("Livro no topo: " + stack.topo());
        System.out.println("Retirando: " + stack.pop());
        System.out.println("Novo topo: " + stack.topo());
        System.out.println("Estado da pilha: " + (stack.estado() ? "vazia" : "não vazia"));
        scanner.close();
    }
}
