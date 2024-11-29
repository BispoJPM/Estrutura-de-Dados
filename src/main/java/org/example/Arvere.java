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

    List<Integer> buscaCaminho(Arvere raiz, int valor) {
        List<Integer> caminho = new ArrayList<>();
        Arvere noAtual = raiz;

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

    List<Integer> buscaIntervalo(Arvere raiz, int min, int max) {
        List<Integer> resultado = new ArrayList<>();
        if (raiz == null) {
            return resultado;
        }

        if (raiz.conteudo >= min && raiz.conteudo <= max) {
            resultado.add(raiz.conteudo);
        }

        if (min < raiz.conteudo) {
            resultado.addAll(buscaIntervalo(raiz.esq, min, max));
        }

        if (max > raiz.conteudo) {
            resultado.addAll(buscaIntervalo(raiz.dir, min, max));
        }

        return resultado;
    }

    public static void main(String[] args) {
        Arvere arvore = new Arvere(17);
        Arvere raiz = arvore;
        
        raiz = arvore.insere(raiz, 5);
        raiz = arvore.insere(raiz, 15);
        raiz = arvore.insere(raiz, 3);
        raiz = arvore.insere(raiz, 7);
        raiz = arvore.insere(raiz, 12);
        raiz = arvore.insere(raiz, 18);
        raiz = arvore.insere(raiz, 34);
        raiz = arvore.insere(raiz, 41);
        raiz = arvore.insere(raiz, 22);
        raiz = arvore.insere(raiz, 19);
        raiz = arvore.insere(raiz, 11);
        raiz = arvore.insere(raiz, 28);

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

        List<Integer> caminho = arvore.buscaCaminho(raiz, 7);
        System.out.println("Caminho até 7: " + caminho);

        List<Integer> intervalo = arvore.buscaIntervalo(raiz, 5, 12);
        System.out.println("Intervalo [5, 12]: " + intervalo);
        }
    }
}
