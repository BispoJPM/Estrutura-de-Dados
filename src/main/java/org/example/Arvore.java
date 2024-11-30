package org.example;

import java.util.ArrayList;
import java.util.List;

class Arvore {
    int conteudo;
    Arvore esq;
    Arvore dir;

    Arvore(int conteudo) {
        this.conteudo = conteudo;
        this.esq = null;
        this.dir = null;
    }

    Arvore insere(Arvore raiz, int valor) {
        if (raiz == null) {
            return new Arvore(valor);
        }
        if (valor < raiz.conteudo) {
            raiz.esq = insere(raiz.esq, valor);
        } else {
            raiz.dir = insere(raiz.dir, valor);
        }
        return raiz;
    }

    void linhaHorizontal(Arvore raiz) {
        if (raiz != null) {
            linhaHorizontal(raiz.esq);
            System.out.print(raiz.conteudo + " ");
            linhaHorizontal(raiz.dir);
        }
    }
    
    List<Integer> buscaCaminho(Arvore raiz, int valor) {
        List<Integer> caminho = new ArrayList<>();
        Arvore notual = raiz;

        while (notual != null) {
            caminho.add(notual.conteudo);
            if (valor < notual.conteudo) {
                notual = notual.esq;
            } else if (valor > notual.conteudo) {
                notual = notual.dir;
            } else {
                break;
            }
        }

        return notual != null ? caminho : new ArrayList<>();
    }

    Arvore removeC(Arvore raiz, List<Integer> caminho) {
        if (caminho.isEmpty() || raiz == null) {
            return raiz; }

        Arvore notual = raiz;
        Arvore pai = null;

        for (int it = 0; it < caminho.size() - 1; it++) {
            pai = notual;
            notual = (caminho.get(it + 1) < notual.conteudo) ? notual.esq : notual.dir; }

        if (notual != null) {
            if (notual.esq == null && notual.dir == null) {
                if (pai != null) {
                    if (pai.esq == notual) pai.esq = null;
                    else pai.dir = null;
                } else {
                    raiz = null; }
            } else if (notual.esq == null || notual.dir == null) {
                Arvore filho = (notual.esq != null) ? notual.esq : notual.dir;
                if (pai != null) {
                    if (pai.esq == notual) pai.esq = filho;
                    else pai.dir = filho;
                } else {
                    raiz = filho; }

            } else {
                Arvore maiorzinho = encontraG(notual.esq);
                notual.conteudo = maiorzinho.conteudo;
                notual.esq = removeC(notual.esq, buscaCaminho(notual.esq, maiorzinho.conteudo)); }
        } return raiz; }

    // else {
            //             Arvore minimuzao = encontraP(notual.dir);
            //             notual.conteudo = minimuzao.conteudo;
            //             notual.dir = removeC(notual.dir, List.of(minimuzao.conteudo));
            //         }
            //     }
            //     return raiz;
            // }


    Arvore encontraG(Arvore raiz) {
        while (raiz.dir != null) {
            raiz = raiz.dir; }
        return raiz; }

    // Arvore encontraP(Arvore raiz) {
    //     while (raiz.esq != null) {
    //         raiz = raiz.esq;
    //     }
    //     return raiz;
    // }

    public static void main(String[] args) {
        Arvore arvore = new Arvore(25);
        Arvore raiz = arvore;

        raiz = arvore.insere(raiz, 5);
        raiz = arvore.insere(raiz, 15);
        raiz = arvore.insere(raiz, 3);
        raiz = arvore.insere(raiz, 7);
        raiz = arvore.insere(raiz, 12);
        raiz = arvore.insere(raiz, 18);
        raiz = arvore.insere(raiz, 24);
        raiz = arvore.insere(raiz, 19);
        raiz = arvore.insere(raiz, 31);
        raiz = arvore.insere(raiz, 45);
        raiz = arvore.insere(raiz, 52);
        raiz = arvore.insere(raiz, 81);

        System.out.println("Árvore:");
        arvore.linhaHorizontal(raiz);
        List<Integer> caminho = arvore.buscaCaminho(raiz, 18);
        if (!caminho.isEmpty()) {
            raiz = arvore.removeC(raiz, caminho);}
        System.out.println("\n" + "Árvere:");
        arvore.linhaHorizontal(raiz);
    }
}
