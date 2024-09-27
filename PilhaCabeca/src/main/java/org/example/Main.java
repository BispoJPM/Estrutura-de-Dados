package org.example;

import java.util.Scanner;

public class Main {

    private class nozinho { // classe privada pra coisar o nó ou cabeça
        String livro; 
        nozinho prox; 

        public nozinho(String livro, nozinho prox) {
            this.livro = livro; 
            this.prox = prox; // Próximo nó 
        }
    }

    private nozinho cabeca; // topo do pilha

    public Main() {cabeca = null; }

    public boolean estado() { return cabeca == null; } // estado da pilha = vazio ou não

    public void push(String livro) {cabeca = new nozinho(livro, cabeca); } // adiciono o livro e mudo a ordem

    public String pop() { // tiro o livro do topo e atuliazo a pilha
        if (estado()) return null; 
        String livro = cabeca.livro; 
        cabeca = cabeca.prox; 
        return livro; 
    }

    public String topo() {return estado() ? null : cabeca.livro;} // mostra o livro que está no topo

    // adiciona livro na pilha (stringbuild foi a melhor escolha)
    public String conteudo() {
        StringBuilder livros = new StringBuilder(); 
        nozinho gabi = cabeca; 
        while (gabi != null) {
            livros.append(gabi.livro).append("\n");
            gabi = gabi.prox; 
        }
        return livros.toString(); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        Main stack = new Main(); 
        int option; 
        
        do {
            System.out.println("\n======Menu de Opções:=====");
            System.out.println("1. Empilhar");
            System.out.println("2. Desempilhar");
            System.out.println("3. Mostrar o topo");
            System.out.println("4. A pilha esá vazia ou não?");
            System.out.println("5. Mostrar a pilha");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt(); 
            scanner.nextLine();  

            
            switch (option) {
                case 1: 
                    System.out.print("Digite o livro a ser empilhado: ");
                    String livroPush = scanner.nextLine(); 
                    stack.push(livroPush); 
                    System.out.println("Livro: \"" + livroPush + "\" empilhado com sucesso!");
                    break;

                case 2: 
                    String poparlivro = stack.pop(); 
                    if (poparlivro != null) {
                        System.out.println("Livro desempilhado: " + poparlivro);
                    } else {
                        System.out.println("A pilha está vazia!"); 
                    }
                    break;

                case 3: 
                    String cabecalivro = stack.topo(); 
                    if (cabecalivro != null) {
                        System.out.println("Livro no topo: " + cabecalivro);
                    } else {
                        System.out.println("A pilha está vazia!"); 
                    }
                    break;

                case 4: 
                    System.out.println(stack.estado() ? "A pilha está vazia!" : "A pilha não está vazia.");
                    break;

                case 5: 
                    System.out.println("O conteúdo da pilha é:\n" + stack.conteudo());
                    break;

                case 0:
                    System.out.println("Sakaue me ajuda!");
                    break;

                default: 
                    System.out.println("Digite algo entre 0 a 5!!");
            }
        } while (option != 0); 

        scanner.close(); 
    }
}
