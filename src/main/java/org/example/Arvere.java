package org.example;

class Arvere {
    int conteudo;
    Arvere esq;
    Arvere dir;

    Arvere(int conteudo) {
        this.conteudo = conteudo;
        this.esq = null;
        this.dir = null;
    }

    Arvere insere(Arvere raiz, int valor) {
        if (raiz == null) {
            return new Arvere(valor);
        }
        if (valor < raiz.conteudo) {
            raiz.esq = insere(raiz.esq, valor);
        } else {
            raiz.dir = insere(raiz.dir, valor);
        }
        return raiz;
    }

    Arvere buscaRecursiva(Arvere raiz, int valor) {
        if (raiz == null || raiz.conteudo == valor) {
            return raiz;
        }
        if (raiz.conteudo > valor) {
            return buscaRecursiva(raiz.esq, valor);
        } else {
            return buscaRecursiva(raiz.dir, valor);
        }
    }

    Arvere buscaIterativa(Arvere raiz, int valor) {
        while (raiz != null && raiz.conteudo != valor) {
            if (raiz.conteudo > valor) {
                raiz = raiz.esq;
            } else {
                raiz = raiz.dir;
            }
        }
        return raiz;
    }

    public static void main(String[] args) {
        Arvere arvore = new Arvere(6);
        Arvere raiz = arvore;
        
        raiz = arvore.insere(raiz, 5);
        raiz = arvore.insere(raiz, 15);
        raiz = arvore.insere(raiz, 3);
        raiz = arvore.insere(raiz, 7);
        raiz = arvore.insere(raiz, 12);
        raiz = arvore.insere(raiz, 18);

        Arvere resultadoRecursivo = arvore.buscaRecursiva(raiz, 7);
        if (resultadoRecursivo != null) {
            System.out.println("Recursivamente: " + resultadoRecursivo.conteudo);
        } else {
            System.out.println("Não tem.");
        }

        Arvere resultadoIterativo = arvore.buscaIterativa(raiz, 12);
        if (resultadoIterativo != null) {
            System.out.println("Iterativamente: " + resultadoIterativo.conteudo);
        } else {
            System.out.println("Não tem.");
        }
    }
}
