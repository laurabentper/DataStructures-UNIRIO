public class Main {
    public static void main(String[] args) {
        ListaCircular l1 = new ListaCircular();
        ListaCircular l2 = new ListaCircular();

        l1.insere(1);
        l1.insere(2);
        l1.insere(3);
        l1.insere(4);

        l2.insere(5);
        l2.insere(6);
        l2.insere(7);
        l2.insere(8);
        l2.insere(9);

        l1.merge(l2).imprime();

    /*Complexidade linear, pois no caso das listas nao estarem vazias, o primeiro loop 'do-while' executara
    min(n, m), e os loops while posteriores executarao o resto de elementos que sobrarem na lista de n ou m, resultando
    em uma complexidade O(n+m) */
    }
}
