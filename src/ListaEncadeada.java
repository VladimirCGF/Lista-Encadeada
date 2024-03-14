public class ListaEncadeada {
    private No inicio;
    private No fim;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void inserirInicio(int dado) {
        No novoNo = new No(dado);
        if (estaVazia()) {
            inicio = fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio = novoNo;
        }
        tamanho++;
    }


    public void inserirFim(int dado) {
        No novoNo = new No(dado);
        if (estaVazia()) {
            inicio = fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
        tamanho++;
    }


    public void inserirMeio(int dado, int posicao) {
        if (posicao < 1 || posicao > tamanho + 1) {
            throw new IllegalArgumentException("Posição inválida!");
        }

        No novoNo = new No(dado);
        if (posicao == 1) {
            inserirInicio(dado);
        } else if (posicao == tamanho + 1) {
            inserirFim(dado);
        } else {
            No anterior = inicio;
            for (int i = 1; i < posicao - 1; i++) {
                anterior = anterior.proximo;
            }
            No proximo = anterior.proximo;
            anterior.proximo = novoNo;
            novoNo.proximo = proximo;
            tamanho++;
        }
    }

    public int removerInicio() {
        if (estaVazia()) {
            throw new IllegalStateException("Lista vazia!");
        }

        int dadoRemovido = inicio.dado;
        if (tamanho == 1) {
            inicio = fim = null;
        } else {
            inicio = inicio.proximo;
        }
        tamanho--;
        return dadoRemovido;
    }

    public int removerFim() {
        if (estaVazia()) {
            throw new IllegalStateException("Lista vazia!");
        }

        int dadoRemovido = fim.dado;
        if (tamanho == 1) {
            inicio = fim = null;
        } else {
            No anterior = inicio;
            while (anterior.proximo != fim) {
                anterior = anterior.proximo;
            }
            anterior.proximo = null;
            fim = anterior;
        }
        tamanho--;
        return dadoRemovido;
    }

    public int removerMeio(int posicao) {
        if (posicao < 1 || posicao > tamanho) {
            throw new IllegalArgumentException("Posição inválida!");
        }

        if (posicao == 1) {
            return removerInicio();
        } else if (posicao == tamanho) {
            return removerFim();
        } else {
            No anterior = inicio;
            for (int i = 1; i < posicao - 1; i++) {
                anterior = anterior.proximo;
            }
            No noRemovido = anterior.proximo;
            anterior.proximo = noRemovido.proximo;
            tamanho--;
            return noRemovido.dado;
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void imprimir() {
        if (estaVazia()) {
            System.out.println("Lista vazia!");
            return;
        }

        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
    }
}
