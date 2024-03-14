public class Main {
    public static void main(String[] args) {

        ListaEncadeada listaEncadeada = new ListaEncadeada();

        ListaEncadeada lista = new ListaEncadeada();

        System.out.println("Lista vazia? " + lista.estaVazia());

        lista.inserirInicio(5);
        lista.inserirFim(10);
        lista.inserirMeio(3, 2);
        lista.inserirInicio(1);
        lista.inserirFim(15);

        System.out.println("Tamanho da lista: " + lista.tamanho());
        System.out.print("Elementos da lista: ");
        lista.imprimir();

        System.out.println("\nRemovendo do início: " + lista.removerInicio());

        System.out.print("Elementos após remoção: ");
        lista.imprimir();

        System.out.println("\nRemovendo do meio (posição 3): " + lista.removerMeio(3));

        System.out.print("Elementos após remoção: ");
        lista.imprimir();

        System.out.println("\nTamanho da lista: " + lista.tamanho());


    }
}
