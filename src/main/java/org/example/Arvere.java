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
        Arvore noAtual = raiz;

        while (noAtual != null) {
            caminho.add(noAtual.conteudo);
            if (valor < noAtual.conteudo) {
                noAtual = noAtual.esq;
            } else if (valor > noAtual.conteudo) {
                noAtual = noAtual.dir;
            } else {
                break;
            }
        }

        return noAtual != null ? caminho : new ArrayList<>();
    }
    
    Arvore removeC(Arvore raiz, List<Integer> caminho) {
        if (caminho.isEmpty() || raiz == null) {
            return raiz;
        }
        Arvore noAtual = raiz;
        Arvore pai = null;
        
        for (int a = 0; a < caminho.size(); a++) {
            pai = noAtual;
            if (caminho.get(a) < noAtual.conteudo) {
                noAtual = noAtual.esq;
            } else if (caminho.get(a) > noAtual.conteudo) {
                noAtual = noAtual.dir;
            } else {
                break;
            }
        }
        
        if (noAtual != null) {
            if (noAtual.esq == null && noAtual.dir == null) {
                if (pai != null) {
                    if (pai.esq == noAtual) {
                        pai.esq = null;
                    } else {
                        pai.dir = null;
                    }
                } else {
                    raiz = null;
                }
            }
            else if (noAtual.esq == null || noAtual.dir == null) {
                Arvore filho = (noAtual.esq != null) ? noAtual.esq : noAtual.dir;
                if (pai != null) {
                    if (pai.esq == noAtual) {
                        pai.esq = filho;
                    } else {
                        pai.dir = filho;
                    }
                } else {
                    raiz = filho;
                }
            }
            else {
                Arvore maiorzinho = encontraMaior(noAtual.esq);
                noAtual.conteudo = maiorzinho.conteudo;
                noAtual.esq = removeC(noAtual.esq, List.of(maiorzinho.conteudo));
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

        List<Integer> caminho = arvore.buscaCaminho(raiz, 18);
        if (!caminho.isEmpty()) {
            raiz = arvore.removeC(raiz, caminho);
        }

        System.out.println("\n" + "Árvore após remoção:");
        arvore.linhaHorizontal(raiz);
    }
}
