public class Main {
    public static void main(String[] args) {
        ListaDuplamente filaDeEspera = new ListaDuplamente();

        filaDeEspera.insere(1,23.50);
        filaDeEspera.insere(2, 1.00);
        filaDeEspera.insere(3, 0.99);
        filaDeEspera.insere(4, 5.50);
        filaDeEspera.insere(5, 10);
        filaDeEspera.insere(6, 9.50);
        filaDeEspera.insere(7, 1.00);
        filaDeEspera.insere(8, 10);

        filaDeEspera.imprime();

    }
}
