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

    void erd(Arvore raiz) {
        if (raiz != null) {
            erd(raiz.esq);
            System.out.println(raiz.conteudo);
            erd(raiz.dir);
        }
    }

    void red(Arvore raiz) {
        if (raiz != null) {
            System.out.println(raiz.conteudo);
            red(raiz.esq);
            red(raiz.dir);
        }
    }

    void edr(Arvore raiz) {
        if (raiz != null) {
            edr(raiz.esq);
            edr(raiz.dir);
            System.out.println(raiz.conteudo);
        }
    }

    Arvore removeRaiz(Arvore raiz) {
        if (raiz == null) {
            return null;  // Se a árvore está vazia, não há nada para remover
        }

        // Caso 1: A raiz não tem filhos (nó folha)
        if (raiz.esq == null && raiz.dir == null) {
            return null;  // Apenas remove a raiz (deixa a árvore vazia)
        }

        // Caso 2: A raiz tem um filho (esquerdo ou direito)
        if (raiz.esq == null) {
            return raiz.dir;  // Substitui a raiz pelo filho direito
        } else if (raiz.dir == null) {
            return raiz.esq;  // Substitui a raiz pelo filho esquerdo
        }

        // Caso 3: A raiz tem dois filhos
        // Nesse caso, vamos encontrar o sucessor (menor valor na subárvore direita)
        raiz.conteudo = minValue(raiz.dir);  // Substitui o valor da raiz pelo sucessor
        raiz.dir = remove(raiz.dir, raiz.conteudo);  // Remove o sucessor da subárvore direita
        return raiz;  // Retorna a nova raiz após a substituição
    }

    // Método auxiliar para encontrar o menor valor na subárvore direita
    int minValue(Arvore raiz) {
        int minValue = raiz.conteudo;
        while (raiz.esq != null) {
            minValue = raiz.esq.conteudo;
            raiz = raiz.esq;
        }
        return minValue;
    }

    // Método para remover um valor específico da árvore
    Arvore remove(Arvore raiz, int valor) {
        if (raiz == null) {
            return raiz;  // Se o nó é nulo, retorna nulo
        }

        if (valor < raiz.conteudo) {
            raiz.esq = remove(raiz.esq, valor);
        } else if (valor > raiz.conteudo) {
            raiz.dir = remove(raiz.dir, valor);
        } else {
            // Nó encontrado
            if (raiz.esq == null) {
                return raiz.dir;
            } else if (raiz.dir == null) {
                return raiz.esq;
            }
            raiz.conteudo = minValue(raiz.dir);
            raiz.dir = remove(raiz.dir, raiz.conteudo);
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

        System.out.println("\nEsq - > Raiz - > Dir:");
        arvore.erd(raiz);
        System.out.println("\nRaiz -> Esq - > Dir:");
        arvore.red(raiz);
        System.out.println("\nDir -> Raiz -> Esq:");
        arvore.edr(raiz);
    }
}
