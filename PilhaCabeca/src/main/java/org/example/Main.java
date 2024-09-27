package org.example;

import java.util.Scanner;

public class Main {

    // Classe que representa um nó da pilha
    private class Node {
        String book; // Título do livro
        Node next; // Referência para o próximo nó

        // Construtor do nó
        public Node(String book, Node next) {
            this.book = book; // Inicializa o título do livro
            this.next = next; // Inicializa o próximo nó
        }
    }

    private Node top; // Referência para o topo da pilha

    // Construtor da pilha
    public Main() {
        top = null; // A pilha começa vazia
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return top == null; // Retorna true se o topo é nulo
    }

    // Adiciona um livro na pilha
    public void push(String book) {
        top = new Node(book, top); // Cria um novo nó e atualiza o topo
    }

    // Remove o livro do topo da pilha
    public String pop() {
        if (isEmpty()) return null; // Retorna nulo se a pilha estiver vazia
        String book = top.book; // Armazena o livro do topo
        top = top.next; // Atualiza o topo
        return book; // Retorna o livro desempilhado
    }

    // Obtém o livro no topo da pilha sem removê-lo
    public String peek() {
        return isEmpty() ? null : top.book; // Retorna o livro do topo ou nulo se a pilha estiver vazia
    }

    // Exibe todo o conteúdo da pilha
    public String display() {
        StringBuilder books = new StringBuilder(); // Usamos StringBuilder para melhor performance
        Node current = top; // Começa do topo

        // Adiciona os livros à string
        while (current != null) {
            books.append(current.book).append("\n");
            current = current.next; // Move para o próximo livro
        }

        return books.toString(); // Retorna a lista de livros
    }

    // Método principal que executa o programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria um scanner para ler entradas do usuário
        Main stack = new Main(); // Cria uma nova pilha
        int option; // Variável para armazenar a opção escolhida

        // Loop que exibe o menu e processa as opções
        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Empilhar");
            System.out.println("2. Desempilhar");
            System.out.println("3. Exibir topo");
            System.out.println("4. Verificar se a pilha está vazia");
            System.out.println("5. Exibir pilha");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt(); // Lê a opção escolhida
            scanner.nextLine();  // Limpa o buffer

            // Processa a opção escolhida
            switch (option) {
                case 1: // Empilhar
                    System.out.print("Digite o livro a ser empilhado: ");
                    String bookToPush = scanner.nextLine(); // Lê o título do livro
                    stack.push(bookToPush); // Empilha o livro
                    System.out.println("Livro: \"" + bookToPush + "\" empilhado com sucesso!");
                    break;

                case 2: // Desempilhar
                    String poppedBook = stack.pop(); // Desempilha o livro
                    if (poppedBook != null) {
                        System.out.println("Livro desempilhado: " + poppedBook);
                    } else {
                        System.out.println("A pilha está vazia!"); // Mensagem se a pilha estiver vazia
                    }
                    break;

                case 3: // Exibir topo
                    String topBook = stack.peek(); // Obtém o livro do topo
                    if (topBook != null) {
                        System.out.println("Livro no topo: " + topBook);
                    } else {
                        System.out.println("A pilha está vazia!"); // Mensagem se a pilha estiver vazia
                    }
                    break;

                case 4: // Verificar se a pilha está vazia
                    System.out.println(stack.isEmpty() ? "A pilha está vazia!" : "A pilha não está vazia.");
                    break;

                case 5: // Exibir pilha
                    System.out.println("O conteúdo da pilha é:\n" + stack.display());
                    break;

                case 0: // Sair
                    System.out.println("Saindo...");
                    break;

                default: // Opção inválida
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (option != 0); // Continua até que o usuário escolha sair

        scanner.close(); // Fecha o scanner
    }
}
