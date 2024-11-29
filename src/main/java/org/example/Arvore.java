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
    
    // Arvore buscaRecursiva(Arvore raiz, int valor) {
    //     if (raiz == null || raiz.conteudo == valor) {
    //         return raiz;
    //     }
    //     if (raiz.conteudo > valor) {
    //         return buscaRecursiva(raiz.esq, valor);
    //     } else {
    //         return buscaRecursiva(raiz.dir, valor);
    //     }
    // }

    // Arvore buscaIterativa(Arvore raiz, int valor) {
    //     while (raiz != null && raiz.conteudo != valor) {
    //         if (raiz.conteudo >valor) {
    //             raiz = raiz.esq;
    //         } else {
    //             raiz = raiz.dir;
    //         }
    //     }
    //     return raiz;
    // }

        void imprimeInOrderLinha(Arvore raiz) {
            if (raiz != null) {
                imprimeInOrderLinha(raiz.esq); 
                System.out.println(raiz.conteudo);
                imprimeInOrderLinha(raiz.dir);
            }
        }

    Arvore remove(Arvore raiz, int valor) {
        if (raiz == null) {
            return null;
        }

        if (valor < raiz.conteudo) {
            raiz.esq = remove(raiz.esq, valor);
        } else if (valor > raiz.conteudo) {
            raiz.dir = remove(raiz.dir, valor);
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
                raiz.esq = remove(raiz.esq, maiorzinho.conteudo);
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
        Arvore raiz = null;
        Arvore arvore = new Arvore(6);

        raiz = arvore.insere(raiz, 5);
        raiz = arvore.insere(raiz, 15);
        raiz = arvore.insere(raiz, 3);
        raiz = arvore.insere(raiz, 7);
        raiz = arvore.insere(raiz, 12);
        raiz = arvore.insere(raiz, 18);
        // raiz = arvore.remove(raiz, 15);  
        System.out.println("Valores da Árvore (um embaixo do outro):");
            arvore.imprimeInOrderLinha(raiz);
        
        // Arvore resultadoRecursivo = arvore.buscaRecursiva(raiz, 7);
        // if (resultadoRecursivo != null) {
        //     System.out.println("Recursivamente: " + resultadoRecursivo.conteudo);
        // } else {
        //     System.out.println("Não tem.");
        // }

        // Arvore resultadoIterativo = arvore.buscaIterativa(raiz, 12);
        // if (resultadoIterativo != null) {
        //     System.out.println("Iterativamente: " + resultadoIterativo.conteudo);
        // } else {
        //     System.out.println("Não tem.");
        }
    }
}
