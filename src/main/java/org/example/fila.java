public class No { 
    int elemento; 
    No proximo; // ponteiro pro proximo [ X | ---]---> [ Y | ---]---> @ = nulo

    public No(int elemento) { 
        this.elemento = elemento;
        this.proximo = null; // inicializa a referência para o próximo nó como null [ Y | ---]---> @ = nulo
    }
}

public class FilaTest {
    public static void main(String[] args) {
        
        No primeiro = null;
        No ultimo = null;
        int tamanho = 0;

        void adicionar(int elemento) {
            No novo = new No(elemento); // nova variável (ponteiro)
            if (conteudo()) {
                primeiro = novo;
                ultimo = novo;
            } else {
                ultimo.proximo = novo; // variável acessando o atributo e setando como novo
                ultimo = novo;
            }
            tamanho++;
        }

        int remover() {
            if (conteudo()) {
                throw new IllegalStateException("A fila está vazia.");
            }
            int elementoRemovido = primeiro.elemento; // variável com o valor do primeiro
            primeiro = primeiro.proximo; // atualizando para o próximo
            if (primeiro == null) {
                ultimo = null;
            }
            tamanho--;
            return elementoRemovido;
        }

        boolean conteudo() {
            return tamanho == 0;
        }

        int tamanhoFila() {
            return tamanho;
        }

        adicionar(10);
        adicionar(20);
        adicionar(30);

        System.out.println("Primeiro elemento: " + (conteudo() ? "Fila vazia" : primeiro.elemento));
        System.out.println("Tamanho da fila: " + tamanhoFila());
        System.out.println("Elemento removido: " + remover());
        System.out.println("Primeiro elemento: " + (conteudo() ? "Fila vazia" : primeiro.elemento));
        System.out.println("Tamanho da fila: " + tamanhoFila());
        System.out.println("A fila está vazia: " + conteudo());

        remover();
        remover();

        System.out.println("Tamanho: " + tamanhoFila());
        System.out.println("A fila está vazia: " + conteudo());
    }
}
