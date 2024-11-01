package org.example;

public class Exec {
    public static void main(String[] args) {
        No primeiro = null;
        No ultimo = null;
        int tamanho = 0;

        Fila fila = new Fila();

        primeiro = fila.adicionar(10, primeiro, ultimo);
        ultimo = primeiro;
        tamanho++;
        primeiro = fila.adicionar(20, primeiro, ultimo);
        ultimo = ultimo.proximo;
        tamanho++;
        primeiro = fila.adicionar(30, primeiro, ultimo);
        ultimo = ultimo.proximo;
        tamanho++;

        System.out.println("Primeiro elemento: " + fila.topo(primeiro));
        System.out.println("Tamanho da fila: " + tamanho);

        if (tamanho > 0) {
            primeiro = fila.remover(primeiro, ultimo);
            tamanho--;

            System.out.println("Elemento removido: " + 10);
            System.out.println("Primeiro elemento após remoção: " + fila.topo(primeiro));
            System.out.println("Tamanho da fila após remoção: " + tamanho);
        }
    }
}
