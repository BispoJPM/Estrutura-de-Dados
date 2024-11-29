<details>
<summary>Lista Encadeada</summary>
  
## O que é uma pilha?

  #### A pilha é uma das estruturas de dados e trabalha com o formato LIFO (o último a entrar é o primeiro a sair, “Last In, First Out”, em inglês). Lembrar da pilha como uma pilha de livros, em que o primeiro livro que foi inserido na pilha, normalmente é o último que sai dela, enquanto o último adicionado é o primeiro a ser retirado

![image](https://github.com/user-attachments/assets/dedf3128-0571-46ae-8666-04f836ffcccd)

## O que é uma fila?

#### Uma fila é uma estrutura de dados linear que segue o princípio “primeiro a entrar, primeiro a sair” (FIFO – First-In-First-Out). Isso significa que o primeiro elemento inserido em uma fila será o primeiro a ser removido.

![image](https://github.com/user-attachments/assets/e6401c64-e479-4c1f-9c74-3ec0375d016e)

## O que é uma lista encadeada?

#### Uma lista encadeada é uma estrutura de dados linear que consiste em uma sequência de elementos chamados de nós. Cada nó contém dois componentes: um campo de valor e uma referência (ou ponteiro) para o próximo nó na sequência.

![image](https://github.com/user-attachments/assets/f514148e-ca61-4692-b48b-2a4f1b47e8fa)
</details>

<details>
<summary>Ordenações</summary>

## O que é Select?
#### O Selection ordena o array iterativamente ao encontrar o menor elemento e colocá-lo na posição correta, repetindo o processo para os elementos restantes, ineficiente para grandes listas.
![image](https://github.com/user-attachments/assets/83010184-a665-48cd-8ed1-0f1f1b953584)


## O que é Insert?
#### O Insertion percorre o array e, a cada passo, insere o elemento atual na posição correta dentro da parte já ordenada. Ele é eficiente para arrays pequenos ou parcialmente ordenados
![image](https://github.com/user-attachments/assets/787e9387-52eb-4f9e-aa5e-c16f379d3ab7)

 
## O que é Shell?
#### O Shell é uma variação do Insertion que melhora a eficiência ao comparar e ordenar elementos distantes uns dos outros com diferentes valores de gap. 
![image](https://github.com/user-attachments/assets/79e07233-9756-4210-802f-1777d5f55112)


## O que é Merge?
#### O Merge é um algoritmo recursivo que divide o array em duas metades e as ordena individualmente, depois combina as metades de maneira ordenada.
![image](https://github.com/user-attachments/assets/87680449-ad2e-4cdb-8ace-4d3404df9c18)


## O que é Quick?
#### O Quick escolhe um pivô, divide o array em elementos menores e maiores que o pivô, e ordena recursivamente as sublistas.
![image](https://github.com/user-attachments/assets/d8b402ef-0be3-4c3c-bde7-77a20202f16d)

## Complexidades:
![image](https://github.com/user-attachments/assets/d4a1c137-9269-4f8d-a3f8-6134d3720526)

</details>

<details>
<summary>Árvore</summary>

## O que é Árvore?
#### Uma árvore é uma estrutura de dados hierárquica composta por nós, onde cada nó contém um valor e referências para seus filhos (esquerda e direita, em árvores binárias). O nó superior é chamado de raiz, e os nós sem filhos são chamados de folhas.
![image](https://github.com/user-attachments/assets/3f117040-d8b7-47c7-8487-8a2e9385ee41)

> Inserir: Insere um novo nó na árvore, geralmente seguindo a regra de que valores menores que o nó atual vão para a esquerda e valores maiores para a direita. Ele é recursivo, até encontrar uma posição vaga para o nó.

> A busca percorre a árvore para encontrar um valor específico, comparando o valor com o nó atual. Se o valor for menor, busca-se à esquerda, e se for maior, à direita. Pode ser feita recursivamente ou iterativamente.

> A remoção exclui um nó da árvore, ajustando a estrutura conforme necessário. Se o nó tiver filhos, o nó é substituído pelo nó mais adequado (geralmente o menor nó da subárvore à direita ou o maior da subárvore à esquerda). Se não tiver filhos, é apenas desconectado.
</details>
