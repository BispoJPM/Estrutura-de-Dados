public class No { 
    int elemento; 
    No proximo; // ponteiro pro proximo [ X | ---]---> [ Y | ---]---> @ = nulo

    public No(int elemento) { 
        this.elemento = elemento;
        this.proximo = null; // inicializa a referência para o próximo nó como null [ Y | ---]---> @ = nulo
    }
}

public class Fila { 
    private No primeiro; 
    private No ultimo; 
    private int tamanho; 

    public Fila() { 
        this.primeiro = null; 
        this.ultimo = null; 
        this.tamanho = 0;
    } 

    public void adicionar(int elemento) {
        No novo = new No(elemento); // nova variavel (ponteiro)
        if (conteudo()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo; // variavel acessando o atributo e setando como novo
            ultimo = novo;
        }
        tamanho++;
    }

    public int remover() {
        if (conteudo()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        int elementoRemovido = primeiro.elemento; // variavel com o valor do 1
        primeiro = primeiro.proximo; // atualizando pro prox
        if (primeiro == null) {
            ultimo = null;
        }
        tamanho--;
        return elementoRemovido;
    }

    public int primeiro() {
        if (conteudo()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return primeiro.elemento;
    }

    public boolean conteudo() {
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
        System.out.println("Primeiro elemento: " + fila.primeiro());
        System.out.println("Tamanho da fila: " + fila.tamanho());
        System.out.println("A fila está vazia: " + fila.conteudo());
        
        fila.remover();
        fila.remover();
        
        System.out.println("Tamanho: " + fila.tamanho());
        System.out.println("A fila está vazia: " + fila.conteudo());
    }
}
