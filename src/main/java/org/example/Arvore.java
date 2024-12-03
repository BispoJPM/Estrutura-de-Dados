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

    Arvore remover(Arvore pai, Arvore no) {
        if (no == null) {
            return null;
        }

        if (no.esq == null && no.dir == null) {
            if (pai != null) {
                if (pai.esq == no) {
                    pai.esq = null;
                } else if (pai.dir == no) {
                    pai.dir = null;
                }
            }
            return null;
        }

        if (no.esq == null) {
            if (pai != null) {
                if (pai.esq == no) {
                    pai.esq = no.dir;
                } else if (pai.dir == no) {
                    pai.dir = no.dir;
                }
            }
            return no.dir;
        } else if (no.dir == null) {
            if (pai != null) {
                if (pai.esq == no) {
                    pai.esq = no.esq;
                } else if (pai.dir == no) {
                    pai.dir = no.esq;
                }
            }
            return no.esq;
        }

        Arvore sucessor = obterSucessor(no.dir);
        no.conteudo = sucessor.conteudo;
        no.dir = remover(no, sucessor);
        return no;
    }

    Arvore obterSucessor(Arvore no) {
        Arvore atual = no;
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
            Arvore no = Busca.procurado;

            if (pai == null) {
                raiz = arvore.remover(null, no);
            } else {
                arvore.remover(pai, no);
            }

            System.out.println("\nÁrvore:");
            arvore.erd(raiz);
        }
    }
}
