public class Main {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();
        lista.insere(1);
        lista.insere(2);
        lista.insere(3);
        lista.insere(4);
        lista.insere(5);

        lista.imprime();

        lista.inverteLista().imprime();

    }
}
