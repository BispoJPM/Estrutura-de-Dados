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
            System.out.print(raiz.conteudo + " ");
            erd(raiz.dir);
        }
    }

    Arvore[] busca(Arvore raiz, int valor) {
        Arvore procurado = raiz;
        Arvore pai = null;

        while (procurado != null && procurado.conteudo != valor) {
            pai = procurado;
            if (valor < procurado.conteudo) {
                procurado = procurado.esq;
            } else {
                procurado = procurado.dir;
            }
        }
        if (procurado != null) {
            return new Arvore[]{pai, procurado};
        } else {
            return null;
        }
    }

    Arvore remover(Arvore pai, Arvore procurado) {
        if (procurado == null) {
            return null;
        }

        if (procurado.esq == null && procurado.dir == null) {
            if (pai != null) {
                if (pai.esq == procurado) {
                    pai.esq = null;
                } else if (pai.dir == procurado) {
                    pai.dir = null;
                }
            }
            return null;
        }

        if (procurado.esq == null) {
            if (pai != null) {
                if (pai.esq == procurado) {
                    pai.esq = procurado.dir;
                } else if (pai.dir == procurado) {
                    pai.dir = procurado.dir;
                }
            }
            return procurado.dir;
        } else if (procurado.dir == null) {
            if (pai != null) {
                if (pai.esq == procurado) {
                    pai.esq = procurado.esq;
                } else if (pai.dir == procurado) {
                    pai.dir = procurado.esq;
                }
            }
            return procurado.esq;
        }

        Arvore menorzao = obtermenorzao(procurado.dir);
        procurado.conteudo = menorzao.conteudo;
        procurado.dir = remover(procurado, menorzao);
        return procurado;
    }

    Arvore obtermenorzao(Arvore procurado) {
        Arvore atual = procurado;
        while (atual.esq != null) {
            atual = atual.esq;
        }
        return atual;
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
        arvore.erd(raiz);
        Arvore[] resultado = arvore.busca(raiz, 31);
        if (resultado != null) {
            Arvore pai = resultado[0];
            Arvore procurado = resultado[1];
            if (pai == null) {
                raiz = arvore.remover(null, procurado);
            } else {
                arvore.remover(pai, procurado);
            }
            System.out.println("\nÁrvere:");
            arvore.erd(raiz);
        }
    }
}
