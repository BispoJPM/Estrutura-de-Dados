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
    
        void linhaVertical(Arvore raiz) {
            if (raiz != null) {
                linhaVertical(raiz.esq);
                System.out.println(raiz.conteudo);
                linhaVertical(raiz.dir);
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

    public Arvore remove(int valor) {
        Arvore buscaRe = buscaRecursiva(this, valor);  
        if (buscaRe != null) {
            return remove(this, buscaRe);  
        }
        return this; 
    }

    public Arvore remove(Arvore raiz, Arvore buscaRe) {
        if (raiz == null) {
            return null;
        }

        if (buscaRe.conteudo < raiz.conteudo) {
            raiz.esq = remove(raiz.esq, buscaRe);
        } else if (buscaRe.conteudo > raiz.conteudo) {
            raiz.dir = remove(raiz.dir, buscaRe);
        } else {
            if (raiz.esq == null && raiz.dir == null) {
                return null;
            }
            else if (raiz.esq == null) {
                return raiz.dir;
            } else if (raiz.dir == null) {
                return raiz.esq;
            }
            else {
                Arvore maiorzinho = encontraMaior(raiz.esq);
                raiz.conteudo = maiorzinho.conteudo;
                raiz.esq = remove(raiz.esq, maiorzinho);
            }
        }
        return raiz;
    }
            // else {
            //             Arvore minimuzao = encontraMinimo(raiz.dir);
            //             raiz.conteudo = minimuzao.conteudo;
            //             raiz.dir = remove(raiz.dir, minimuzao.conteudo);
            //         }
            //     }
            //     return raiz;
            // }

    // Arvore encontraMinimo(Arvore raiz) {
    //     while (raiz.esq != null) {
    //         raiz = raiz.esq;
    //     }
    //     return raiz;
    // }

    Arvore encontraMaior(Arvore raiz) {
        while (raiz.dir != null) {
            raiz = raiz.dir;
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
        System.out.println("Árvore:");
        arvore.linhaVertical(raiz);
        raiz = arvore.remove(15);
        System.out.println("Árvere:");
        arvore.linhaVertical(raiz);
        }
    }

