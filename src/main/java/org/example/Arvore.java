package org.example;

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
            System.out.print(raiz.conteudo + " "); // Imprime na mesma linha
            linhaHorizontal(raiz.dir);
        }
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

    Arvore remove(Arvore raiz, Arvore buscaRe) {
        if (raiz == null) {
            return null;
        }

        if (raiz == buscaRe) {
            if (raiz.esq == null && raiz.dir == null) {
                return null;
            }
            if (raiz.esq == null) {
                return raiz.dir;
            }
            if (raiz.dir == null) {
                return raiz.esq;
            }
            Arvore maiorzinho = encontraMaior(raiz.esq);
            raiz.conteudo = maiorzinho.conteudo;
            raiz.esq = remove(raiz.esq, maiorzinho);
        } else {
            if (buscaRe.conteudo < raiz.conteudo) {
                raiz.esq = remove(raiz.esq, buscaRe);
            } else {
                raiz.dir = remove(raiz.dir, buscaRe);
            }
        }
        return raiz;
    }

    Arvore encontraMaior(Arvore raiz) {
        while (raiz.dir != null) {
            raiz = raiz.dir;
        }
        return raiz;
    }

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
        Arvore buscaRe = arvore.buscaRecursiva(raiz, 18);
        if (buscaRe != null) {
            raiz = arvore.remove(raiz, buscaRe);}
        System.out.println("\n" + "Árvore após remoção:");
        arvore.linhaHorizontal(raiz);
    }
}
