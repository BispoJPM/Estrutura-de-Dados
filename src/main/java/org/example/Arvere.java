package org.example;

class Arvere {
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

    Arvore buscaRecursiva(Arvore raiz, int valor) {
        if (raiz == null || raiz.conteudo == valor) {
            return raiz;
        }
        if (raiz.conteudo > valor) {
            return buscaRecursiva(raiz.esq, valor);
        } else {
            return buscaRecursiva(raiz.dir, valor);
        }
    }

    Arvore buscaIterativa(Arvore raiz, int valor) {
        while (raiz != null && raiz.conteudo != valor) {
            if (raiz.conteudo >valor) {
                raiz = raiz.esq;
            } else {
                raiz = raiz.dir;
            }
        }
        return raiz;
    }


    public static void main(String[] args) {
        Arvore arvore = new Arvore(6);
        Arvore raiz = arvore;

        raiz = arvore.insere(raiz, 5);
        raiz = arvore.insere(raiz, 15);
        raiz = arvore.insere(raiz, 3);
        raiz = arvore.insere(raiz, 7);
        raiz = arvore.insere(raiz, 12);
        raiz = arvore.insere(raiz, 18);


    Arvore resultadoRecursivo = arvore.buscaRecursiva(raiz, 7);
        if (resultadoRecursivo != null) {
            System.out.println("Recursivamente: " + resultadoRecursivo.conteudo);
        } else {
            System.out.println("Não tem.");
        }

        Arvore resultadoIterativo = arvore.buscaIterativa(raiz, 12);
        if (resultadoIterativo != null) {
            System.out.println("Iterativamente: " + resultadoIterativo.conteudo);
        } else {
            System.out.println("Não tem.");
        }
    }
