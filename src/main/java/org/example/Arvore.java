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

    void erd (Arvore raiz) {
        if (raiz != null) {
            erd(raiz.esq);
            System.out.print(raiz.conteudo + " ");
            erd(raiz.dir);
        }
    }
    
    class Busca {
        Arvore pai;
        Arvore procurado;

        Busca(Arvore pai, Arvore no) {
            this.pai = pai;
            this.procurado = no;
        }
    }

    Busca buscaCaminho(Arvore raiz, int valor) {
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

        return (procurado != null) ? new Busca(pai, procurado) : null;
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

    Arvore obtermenorzao(Arvore procura) {
        Arvore atual = procura;
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
        Busca Busca = arvore.buscaCaminho(raiz, 31);

        if (Busca != null) {
            Arvore pai = Busca.pai;
            Arvore procura = Busca.procurado;

            if (pai == null) {
                raiz = arvore.remover(null, procura);
            } else {
                arvore.remover(pai, procura);
            }

            System.out.println("\nÁrvore:");
            arvore.erd(raiz);
        }
    }
}
