public class Fila {
    private class Noz {
        int elemento;
        Noz proximo;

        Noz(int elemento) {
            this.elemento = elemento;
        }
    }

    private Noz primeiro;
    private Noz ultimo;
    private int tamanho;

    public Fila() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void adicionar(int elemento) {
        Noz novoNoz = new Noz(elemento);
        if (estaVazia()) {
            primeiro = novoNoz;
        } else {
            ultimo.proximo = novoNoz;
        }
        ultimo = novoNoz;
        tamanho++;
    }

    public int remover() {
        if (estaVazia()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        int elementoRemovido = primeiro.elemento;
        primeiro = primeiro.proximo;
        if (primeiro == null) {
            ultimo = null;
        }
        tamanho--;
        return elementoRemovido;
    }

    public int primeiro() {
        if (estaVazia()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return primeiro.elemento;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }
}

public class FilaTest {
    public static void main(String[] args) {
        Fila fila = new Fila();

        fila.adicionar(10);
        fila.adicionar(20);
        fila.adicionar(30);
        
        System.out.println("Primeiro elemento: " + fila.primeiro());
        System.out.println("Tamanho da fila: " + fila.tamanho());

        System.out.println("Elemento removido: " + fila.remover());
        System.out.println("Novo primeiro elemento: " + fila.primeiro());
        System.out.println("Tamanho da fila: " + fila.tamanho());

        System.out.println("A fila está vazia: " + fila.estaVazia());

        fila.remover();
        fila.remover();
        System.out.println("Tamanho da fila após remoções: " + fila.tamanho());
        System.out.println("A fila está vazia: " + fila.estaVazia());
    }
}
