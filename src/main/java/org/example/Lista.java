package org.example;

    class Lista {
        int elemento;
        Lista proximo; // ponteiro pro proximo [ X | ---]---> [ Y | ---]---> @ = nulo

        public Lista(int elemento) {
            this.elemento = elemento;
            this.proximo = null; // inicializa a referência para o próximo nó como null [ Y | ---]---> @ = nulo
        }
    }

    class Fila {
        public Lista adicionar(int elemento, Lista primeiro, Lista ultimo) {
            Lista novo = new Lista(elemento);
            if (primeiro == null) {
                primeiro = novo;
                ultimo = novo;
            } else {
                ultimo.proximo = novo;
                ultimo = novo;
            }
            return primeiro;
        }

        public Lista remover(Lista primeiro, Lista ultimo) {
            if (primeiro == null) {
                throw new IllegalStateException("Fila vazia");
            }
            int elementoRemovido = primeiro.elemento;
            primeiro = primeiro.proximo;
            if (primeiro == null) {
                ultimo = null;
            }
            return primeiro;
        }

        public int topo(Lista primeiro) {
            if (primeiro == null) {
                throw new IllegalStateException("Fila vazia");
            }
            return primeiro.elemento;
        }

        public boolean isEmpty(Lista primeiro) {
            return primeiro == null;
        }
    }
